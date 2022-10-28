package com.lxf.utils.RedisTemplate;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 缓存工具类
 */
//@Service
public class CacheUtil implements InitializingBean {


  @Autowired
  private RedisTemplateService redisTemplateService;

  private ConsistencyHashSelectedKey selectKey;

  /**
   * 获取缓存，无过期时间，无回调函数
   *
   * @param key 键
   * @param cls 缓存的类
   * @param <T> 类信息
   * @return
   */
  public <T> T getCache(String key, Class<T> cls) {
    return getCacheForRead(key, -1, cls, null);
  }

  /**
   * 获取缓存，有过期时间和回调函数
   *
   * @param key         键
   * @param expinSecond 过期时间
   * @param cls         缓存的类
   * @param callable    回调方法
   * @param <T>         类信息
   * @return
   */
  public <T> T getCache(String key, int expinSecond, Class<T> cls, Callable<T> callable) {
    return getCacheForRead(key, expinSecond, cls, callable);
  }

  /**
   * 当读的命中率高的时候适合这种方式
   */
  private <T> T getCacheForRead(String key, int expinSecond, Class<T> cls, Callable<T> callable) {
    T t = get(key, cls);

    if (t == null && callable != null) {
        // 在命中率高的情况下，miss相对少，所以真正进入lock的比较少，从而放开了对读的锁操作
        ReentrantLock lock = selectKey.selectForKey(key);
        lock.lock();
        try {
          t = get(key, cls);
          if (t == null) {
            try {
              t = callable.call();
            } catch (Exception e) {
              e.printStackTrace();
            }
            if (t != null) {
              set(key, t, expinSecond);
            }
          }
        } finally {
          lock.unlock();
        }

    }
    return t;

  }

  /**
   *
   */
  public String getCacheList(String key, int expired, Class<String> cls, Callable<Map<String, String>> callable) {
    return getCacheForReadList(key, expired, cls, callable);
  }

  /**
   * 当读的命中率高的时候适合这种方式
   */
  private String getCacheForReadList(String key, int expired, Class<String> cls, Callable<Map<String, String>> callable) {
    String t = get(key, cls);

    if (t == null) {
      // 在命中率高的情况下，miss相对少，所以真正进入lock的比较少，从而放开了对读的锁操作
      ReentrantLock lock = selectKey.selectForKey(key);
      lock.lock();
      try {
        if (t == null) {
          try {
            Map<String, String> params = callable.call();
            for (String pp : params.keySet()) {
              if (pp != null) {
                set(pp, params.getOrDefault(pp, ""), expired);
              }
            }
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
        t = get(key, cls);
      } finally {
        lock.unlock();
      }
    }
    return t;

  }

  @Override
  public void afterPropertiesSet() {
    selectKey = new ConsistencyHashSelectedKey();
    selectKey.init();

  }

  /**
   * 设置缓存
   *
   * @param key
   * @param t
   * @param expinSecond
   * @param <T>
   */
  public <T> void set(String key, T t, int expinSecond) {
    redisTemplateService.setObjectWithEx(key, t, expinSecond);
  }

  /**
   * 获取缓存
   *
   * @param key
   * @param cls
   * @param <T>
   * @return
   */
  public <T> T get(String key, Class<T> cls) {
    return redisTemplateService.getObject(key, cls);
  }

  /**
   * 清理缓存
   */
  public void remove(String key) {

    redisTemplateService.del(key);
  }

  /**
   * 一致性hash
   */
  private class ConsistencyHashSelectedKey {

    // use for select key
    private int size = 1024;// total lock

    private int replicaNumber = 160;// split share

    private ReentrantLock[] locks = new ReentrantLock[size];

    private TreeMap<Long, ReentrantLock> map = new TreeMap<>();

    private void init() {
      for (int i = 0; i < size; i++) {
        locks[i] = new ReentrantLock();
      }
      for (ReentrantLock lock : locks) {
        for (int i = 0; i < replicaNumber / 4; i++) {
          byte[] digest = md5(lock.toString() + i);
          for (int j = 0; j < 4; j++) {
            map.put(hash(digest, j), lock);
          }
        }
      }
    }

    public ReentrantLock selectForKey(String key) {
      long h = hash(md5(key), 0);
      Map.Entry<Long, ReentrantLock> entry = map.floorEntry(h);
      if (entry == null) {
        entry = map.lastEntry();
      }
      return entry.getValue();
    }

    private long hash(byte[] digest, int number) {
      return (((long) (digest[3 + number * 4] & 0xFF) << 24) | ((long) (digest[2 + number * 4] & 0xFF) << 16)
          | ((long) (digest[1 + number * 4] & 0xFF) << 8) | (digest[0 + number * 4] & 0xFF)) & 0xFFFFFFFFL;
    }

    private byte[] md5(String value) {
      MessageDigest md5;
      try {
        md5 = MessageDigest.getInstance("MD5");
      } catch (NoSuchAlgorithmException e) {
        throw new IllegalStateException(e.getMessage(), e);
      }
      md5.reset();
      byte[] bytes = null;
      try {
        bytes = value.getBytes("UTF-8");
      } catch (UnsupportedEncodingException e) {
        throw new IllegalStateException(e.getMessage(), e);
      }
      md5.update(bytes);
      return md5.digest();
    }
  }
}
