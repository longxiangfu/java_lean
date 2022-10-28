package com.lxf.utils;

import org.springframework.stereotype.Component;
import redis.clients.jedis.*;

import java.util.List;
import java.util.Map;

public class JedisUtil {
    private static JedisPool pool = SpringContextUtil.getBean(JedisPool.class);

    public static void returnResource(JedisPool pool, Jedis redis) {
        if (redis != null) {
            pool.returnResource(redis);
        }
    }

    public static void publish(String channel, String msg) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            jedis.publish(channel, msg);
        }
        catch (Exception e) {

        }
        finally {
            returnResource(pool, jedis);
        }
    }

    public static void subsribe(String channel, JedisPubSub ps) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            jedis.subscribe(ps, channel);
        }
        catch (Exception e) {

        }
        finally {
            returnResource(pool, jedis);
        }
    }

    public static Long hdel(String key, String key1) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.hdel(key, key1);
        }
        catch (Exception e) {

        }
        finally {
            returnResource(pool, jedis);
        }
        return null;
    }


    public static byte[] get(byte[] key) {
        Jedis jedis = null;
        byte[] value = null;
        try {
            jedis = pool.getResource();
            value = jedis.get(key);
        }catch (Exception e) {

        }finally {
            returnResource(pool, jedis);
        }
        return value;
    }

    /**
     * 根据key获取字符串值
     *
     * @param key
     * @return
     */
    public static String get(String key) {
        Jedis jedis = null;
        String value = null;
        try {
            jedis = pool.getResource();
            value = jedis.get(key);
        }
        catch (Exception e) {

        }
        finally {
            returnResource(pool, jedis);
        }
        return value;
    }

    public static boolean exists(byte[] key) {
        Jedis jedis = null;
        boolean value = false;
        try {
            jedis = pool.getResource();
            value = jedis.exists(key);
        }catch (Exception e) {

        }finally {
            returnResource(pool, jedis);
        }
        return value;
    }


    public static boolean exists(String key) {
        Jedis jedis = null;
        boolean value = false;
        try {
            jedis = pool.getResource();
            value = jedis.exists(key);
        }
        catch (Exception e) {

        }
        finally {
            returnResource(pool, jedis);
        }
        return value;
    }

    /**
     * set字节数组
     */
    public static String set(byte[] key, byte[] value) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.set(key, value);
        }catch (Exception e) {
            return "0";
        }
        finally {
            returnResource(pool, jedis);
        }
    }

    /**
     * set字符串
     */
    public static String set(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.set(key, value);
        }
        catch (Exception e) {

            return "0";
        }
        finally {
            returnResource(pool, jedis);
        }
    }

    public static String set(String key, String value, int expire) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            String set = jedis.set(key, value);
            jedis.expire(key, expire);
            return set;
        }
        catch (Exception e) {

            return "0";
        }
        finally {
            returnResource(pool, jedis);
        }
    }

    public static Long del(String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.del(key);
        }
        catch (Exception e) {
            return null;
        }
        finally {
            returnResource(pool, jedis);
        }
    }

    /**
     * @Description 操作list类型数据的
     * @param @param key
     * @param @param strings  list.add(object)
     * @param @return 参数
     * @return Long 返回类型
     * @throws
     */

    public static Long lpush(String key, String... strings) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.lpush(key, strings);
        }
        catch (Exception e) {

            return 0L;
        }
        finally {
            returnResource(pool, jedis);
        }
    }

    public static List<String> lrange(String key) {
        Jedis jedis = null;
        String value = null;
        try {
            jedis = pool.getResource();
            return jedis.lrange(key, 0, -1);
        }
        catch (Exception e) {
            return null;
        }
        finally {
            returnResource(pool, jedis);
        }
    }

    public static String hmset(String key, Map map) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.hmset(key, map);
        }
        catch (Exception e) {

            return "0";
        }
        finally {
            returnResource(pool, jedis);
        }
    }

    public static List<String> hmget(String key, String... strings) {
        Jedis jedis = null;
        String value = null;
        try {
            jedis = pool.getResource();
            return jedis.hmget(key, strings);
        }
        catch (Exception e) {

        }
        finally {
            returnResource(pool, jedis);
        }
        return null;
    }

    public static Map<String, String> hgetAll(String key) {
        Jedis jedis = null;
        String value = null;
        try {
            jedis = pool.getResource();
            return jedis.hgetAll(key);
        }
        catch (Exception e) {

        }
        finally {
            returnResource(pool, jedis);
        }
        return null;
    }

    /**
     * 原子递增
     * @autor lxf
     * @param key
     * @param value
     * @param expire
     * @return
     */
    public static long incrBy(String key, String value, int expire) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.incrBy(key, expire);
        }
        catch (Exception e) {
            return -1;
        }
        finally {
            returnResource(pool, jedis);
        }
    }

    /**
     * 获取管道
     * @return
     */
    public static Pipeline getPipeLined() {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.pipelined();
        }
        catch (Exception e) {
            return null;
        }
        finally {
            returnResource(pool, jedis);
        }
    }
}
