package com.lxf.utils.RedisTemplate;

import com.lxf.config.Config;
import com.lxf.utils.JsonUtils;
import com.lxf.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 * redis template 工具类
 */
//@Component
public class RedisTemplateService {
  public static final int DEFAULT_TIME = 60 * 10;// 10分钟
  private static Logger logger = LoggerFactory.getLogger(RedisTemplateService.class);


  @Autowired
  RedisTemplate<String, String> stringRedisTemplate;

  public void test() {
    ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
    opsForValue.set("redisKey", "cluster test");
    System.out.println("11" + opsForValue.get("test"));
  }

  public void set(String key, String value) {
    ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
    opsForValue.set("redisKey", "cluste rtest");
  }

  /**
   * 普通缓存放入并设置时间
   *
   * @param key   键
   * @param value 值
   * @param time  时间(秒) time要大于0 如果time小于等于0 将设置无限期
   * @return true成功 false 失败
   */
  public boolean set(String key, String value, long time) {
    try {
      if (time > 0) {
        stringRedisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
      } else {
        set(key, value);
      }
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }


  public String get(String key) {
    ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
    return opsForValue.get(key);
  }


  public String exists(String key) {
    ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
    return opsForValue.get(key);
  }

  private void setRetryMethod(String key, String value, int seconds, int retryTimes) {
    int i = 0;
    while (i < retryTimes) {
      try {
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        logger.info("set cache value: " + value);
        opsForValue.set(key, value, seconds, TimeUnit.SECONDS);
        break;
      } catch (Exception e) {
        i++;
        if (i >= retryTimes)
          throw e;
      }
    }
  }

  private void setex(String key, String value, int seconds, int retryTimes) {
    setRetryMethod(key, value, seconds, retryTimes);
  }

  private String getRetryMethod(String key, int retryTimes) {
    String value = null;
    int i = 0;
    while (i < retryTimes) {
      try {
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        value = opsForValue.get(key);
//        log.info("get cached value: " + value);
        if (StringUtils.isNotBlank(value)) {
          value = value.trim();
        }
        break;
      } catch (Exception e) {
        i++;
        if (i >= retryTimes)
          throw e;
      }
    }
    return value;
  }

  private String get(String key, int retryTimes) {
    return getRetryMethod(key, retryTimes);
  }

  public <T> void setObjectWithEx(String key, T t, int expinSecond) {
    String value = JsonUtils.toJson((t)).trim();
    setex(key, value, expinSecond, 3);
  }

  public <T> T getObject(String key, Class<T> clazz) {
    if (StringUtils.isBlank(key)) {
      return null;
    }
    String value = get(key, 3);
    if (StringUtils.isBlank(value)) {
      return null;
    } else {
      value = value.trim();
    }

    return JsonUtils.fromJson(value, clazz);
  }

  public Long increment(String key) {
    return stringRedisTemplate.opsForValue().increment(key, 1);
  }

  public void del(String key) {
    stringRedisTemplate.delete(key);
  }

  public Set<String> getLike(String keyLike) {
    return stringRedisTemplate.keys("*" + keyLike);
  }

  public Long hincrby(String key, String field) {
    return stringRedisTemplate.opsForHash().increment(key, field, 1);
  }

  public boolean lock(String key) {

    String lock = Config.LOCK_PREFIX + key;

    return (Boolean) stringRedisTemplate.execute((RedisCallback) connection -> {
      long expireAt = System.currentTimeMillis() + 600000; //10分钟之后过期
//      return connection.setNX(lock.getBytes(), String.valueOf(expireAt).getBytes());
      Boolean acquire = connection.setNX(lock.getBytes(), String.valueOf(expireAt).getBytes());
      if (acquire) {
        connection.expireAt(lock.getBytes(), expireAt);
        return true;
      }
      return false;

//      } else {
//        return false;
//        byte[] value = connection.get(lock.getBytes());
//        if (Objects.nonNull(value) && value.length > 0) {
//          long expireTime = Long.parseLong(new String(value));
//          if (expireTime < System.currentTimeMillis()) {
//            byte[] oldValue = connection.getSet(lock.getBytes(), String.valueOf(System.currentTimeMillis() + Config.LOCK_PREFIX + 1).getBytes());
//            return Long.parseLong(new String(oldValue)) < System.currentTimeMillis();
//          }
//        }
//      }
//      return false;
    });
  }

  public Map<Object, Object> getStatFields(String redisKey) {
    return stringRedisTemplate.opsForHash().entries(redisKey);
//    return stringRedisTemplate.opsForHash().keys(redisKey);
  }
}
