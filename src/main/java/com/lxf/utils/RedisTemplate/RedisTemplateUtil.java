package com.lxf.utils.RedisTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * RedisTemplateUtil工具类
 */
@Component
public class RedisTemplateUtil<T> {
    private static Logger logger = LoggerFactory.getLogger(RedisTemplateUtil.class);

    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    /**
     * 模糊查询keys
     * @param keys
     * @return
     */
    public Set<String> keys(String keys) {
        if (StringUtils.isEmpty(keys)) {
            throw new RuntimeException("模糊查询keys，keys不能为空");
        }
        try {
            return redisTemplate.keys(keys);
        } catch (Exception e) {
            logger.error(String.valueOf(e));
            throw new RuntimeException("模糊查询keys异常。" + e.toString());
        }
    }

    /**
     * 指定缓存失效时间
     *
     * @param key  键
     * @param time 时间(秒)
     * @return
     */
    public boolean expire(String key, long time) {
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("指定缓存失效时间时，key不能为空");
        }
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            logger.error(e.toString());
            throw new RuntimeException("指定缓存失效时间时异常。" + e.toString());
        }
    }

    /**
     * 根据key获取过期时间
     *
     * @param key 键 不能为null
     * @return 时间(秒) 返回0代表为永久有效
     */
    public long getExpire(String key) {
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("获取过期时间的key不能为空");
        }
        try{
            return redisTemplate.getExpire(key, TimeUnit.SECONDS);
        }catch (Exception e){
            logger.error(e.toString());
            throw new RuntimeException("根据key获取过期时间异常。" + e.toString());
        }

    }

    /**
     * 判断key是否存在
     *
     * @param key 键
     * @return true 存在 false不存在
     */
    public boolean hasKey(String key) {
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("判断key是否存在时，key不能为空");
        }
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            logger.error(e.toString());
            throw new RuntimeException("判断key是否存在时异常。" + e.toString());
        }
    }



    //-------------------------String------------------------------------//

    /**
     * 删除缓存
     *
     * @param key 可以传一个值 或多个
     */
    @SuppressWarnings("unchecked")
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    /**
     * 普通缓存获取
     *
     * @param key 键
     * @return 值
     */
    public Object get(String key) {
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("普通缓存获取时，key不能为空");
        }
        try{
            return redisTemplate.opsForValue().get(key);
        }catch (Exception e){
            logger.error(e.toString());
            throw new RuntimeException("普通缓存获取时异常。" + e.toString());
        }
    }

    /**
     * 普通缓存放入
     *
     * @param key   键
     * @param value 值
     * @return true成功 false失败
     */
    public boolean set(String key, Object value) {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value)) {
            throw new RuntimeException("普通缓存放入时，key或value不能为空");
        }
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            logger.error(e.toString());
            throw new RuntimeException("普通缓存放入时异常。" + e.toString());
        }
    }

    /**
     * 普通缓存放入并设置时间
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return true成功 false 失败
     */
    public boolean set(String key, Object value, long time) {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value)) {
            throw new RuntimeException("普通缓存放入并设置时间时，key或value不能为空");
        }
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            logger.error(e.toString());
            throw new RuntimeException("普通缓存放入并设置时间时异常。" + e.toString());
        }
    }

    /**
     * 递增
     *
     * @param key   键
     * @param delta 要增加几(大于0)
     * @return
     */
    public long incr(String key, long delta) {
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("递增操作的key不能为空");
        }
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        try {
            return redisTemplate.opsForValue().increment(key, delta);
        } catch (Exception e) {
            logger.error(e.toString());
            throw new RuntimeException("递增操作异常。" + e.toString());
        }
    }

    /**
     * 递减
     *
     * @param key   键
     * @param delta 要减少几(小于0)
     * @return
     */
    public long decr(String key, long delta) {
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("递增操作的key不能为空");
        }
        if (delta < 0) {
            throw new RuntimeException("递减因子必须大于0");
        }
        try {
            return redisTemplate.opsForValue().increment(key, -delta);
        } catch (Exception e) {
            logger.error(e.toString());
            throw new RuntimeException("递减操作异常。" + e.toString());
        }
    }


    //-------------------------Hash------------------------------------//
    /**
     * HashGet
     *
     * @param key  键 不能为null
     * @param item 项 不能为null
     * @return 值
     */
    public Object hget(String key, String item) {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(item)) {
            throw new RuntimeException("HashGet时，key不能为空");
        }
        try {
            return redisTemplate.opsForHash().get(key, item);
        }catch (Exception e){
            logger.error(e.toString());
            throw new RuntimeException("HashGet时异常。" + e.toString());
        }

    }

    /**
     * 获取hashKey对应的所有键值
     *
     * @param key 键
     * @return 对应的多个键值
     */
    public Map<Object, Object> hmget(String key) {
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("获取hashKey对应的所有键值，key不能为空");
        }
        try {
            return redisTemplate.opsForHash().entries(key);
        }catch (Exception e){
            logger.error(e.toString());
            throw new RuntimeException("获取hashKey对应的所有键值异常。" + e.toString());
        }

    }

    /**
     * HashSet
     *
     * @param key 键
     * @param map 对应多个键值
     * @return true 成功 false 失败
     */
    public boolean hmset(String key, Map<String, T> map) {
        if (StringUtils.isEmpty(key) || map == null) {
            throw new RuntimeException("HashSet时，key或map不能为空");
        }
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            logger.error(e.toString());
            throw new RuntimeException("HashSet时异常。" + e.toString());
        }
    }

    /**
     * HashSet 并设置时间
     *
     * @param key  键
     * @param map  对应多个键值
     * @param time 时间(秒)
     * @return true成功 false失败
     */
    public boolean hmset(String key, Map<String, Object> map, long time) {
        if (StringUtils.isEmpty(key) || map == null) {
            throw new RuntimeException("HashSet时，key或map不能为空");
        }
        try {
            redisTemplate.opsForHash().putAll(key, map);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            logger.error(e.toString());
            throw new RuntimeException("HashSet时异常。" + e.toString());
        }
    }

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     *
     * @param key   键
     * @param item  项
     * @param value 值
     * @return true 成功 false失败
     */
    public boolean hset(String key, String item, Object value) {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(item)) {
            throw new RuntimeException("向一张hash表中放入数据时，key或item不能为空");
        }
        try {
            redisTemplate.opsForHash().put(key, item, value);
            return true;
        } catch (Exception e) {
            logger.error(e.toString());
            throw new RuntimeException("向一张hash表中放入数据时异常。" + e.toString());
        }
    }

    /**
     * 向一张hash表中放入数据,如果不存在将创建,加超时时间
     *
     * @param key   键
     * @param item  项
     * @param value 值
     * @param time  时间(秒) 注意:如果已存在的hash表有时间,这里将会替换原有的时间
     * @return true 成功 false失败
     */
    public boolean hset(String key, String item, Object value, long time) {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(item)) {
            throw new RuntimeException("向一张hash表中放入数据时，key或item不能为空");
        }
        try {
            redisTemplate.opsForHash().put(key, item, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            logger.error(e.toString());
            throw new RuntimeException("向一张hash表中放入数据时。" + e.toString());
        }
    }

    /**
     * 删除hash表中的值
     *
     * @param key  键 不能为null
     * @param item 项 可以使多个 不能为null
     */
    public void hdel(String key, Object... item) {
        if (StringUtils.isEmpty(key) || item == null) {
            throw new RuntimeException("删除hash表中的值时，key或item不能为空");
        }
        try{
            redisTemplate.opsForHash().delete(key, item);
        }catch (Exception e){
            logger.error(e.toString());
            throw new RuntimeException("删除hash表中的值时异常：" + e.toString());
        }
    }

    /**
     * 判断hash表中是否有该项的值
     *
     * @param key  键 不能为null
     * @param item 项 不能为null
     * @return true 存在 false不存在
     */
    public boolean hHasKey(String key, String item) {
        if (StringUtils.isEmpty(key) || item == null) {
            throw new RuntimeException("判断hash表中是否有该项的值时，key或item不能为空");
        }
        try {
            return redisTemplate.opsForHash().hasKey(key, item);
        }catch (Exception e){
            logger.error(e.toString());
            throw new RuntimeException("判断hash表中是否有该项的值时异常。" + e.toString());
        }

    }

    /**
     * hash递增 如果不存在,就会创建一个 并把新增后的值返回
     *
     * @param key  键
     * @param item 项
     * @param by   要增加几(大于0)
     * @return
     */
    public double hincr(String key, String item, double by) {
        if (StringUtils.isEmpty(key) || item == null) {
            throw new RuntimeException("Hash递增时，key或item不能为空");
        }
        try{
            return redisTemplate.opsForHash().increment(key, item, by);
        }catch (Exception e){
            logger.error(e.toString());
            throw new RuntimeException("Hash递增异常。" + e.toString());
        }
    }

    /**
     * hash递减
     *
     * @param key  键
     * @param item 项
     * @param by   要减少记(小于0)
     * @return
     */
    public double hdecr(String key, String item, double by) {
        if (StringUtils.isEmpty(key) || item == null) {
            throw new RuntimeException("Hash递减时，key或item不能为空");
        }
        try{
            return redisTemplate.opsForHash().increment(key, item, -by);
        }catch (Exception e){
            logger.error(e.toString());
            throw new RuntimeException("Hash递减异常。" + e.toString());
        }

    }




    //-------------------------Set------------------------------------//
    /**
     * 根据key获取Set中的所有值
     *
     * @param key 键
     * @return
     */
    public Set<Object> sGet(String key) {
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("根据key获取Set中的所有值时，key不能为空");
        }
        try {
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            logger.error(e.toString());
            throw new RuntimeException("根据key获取Set中的所有值时异常。" + e.toString());
        }
    }

    /**
     * 根据value从一个set中查询,是否存在
     *
     * @param key   键
     * @param value 值
     * @return true 存在 false不存在
     */
    public boolean sHasKey(String key, Object value) {
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("根据value从一个set中查询时，key不能为空");
        }
        try {
            return redisTemplate.opsForSet().isMember(key, value);
        } catch (Exception e) {
            logger.error(e.toString());
            throw new RuntimeException("根据value从一个set中查询时异常。" + e.toString());
        }
    }

    /**
     * 将数据放入set缓存
     *
     * @param key    键
     * @param values 值 可以是多个
     * @return 成功个数
     */
    public long sSet(String key, Object... values) {
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("Set add时，key不能空");
        }
        try {
            return redisTemplate.opsForSet().add(key, values);
        } catch (Exception e) {
            logger.error(e.toString());
            throw new RuntimeException("Set add时异常。" + e.toString());
        }
    }

    /**
     * 将set数据放入缓存
     *
     * @param key    键
     * @param time   时间(秒)
     * @param values 值 可以是多个
     * @return 成功个数
     */
    public long sSetAndTime(String key, long time, Object... values) {
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("Set add时，key不能空");
        }
        try {
            Long count = redisTemplate.opsForSet().add(key, values);
            if (time > 0)
                expire(key, time);
            return count;
        } catch (Exception e) {
            logger.error(e.toString());
            throw new RuntimeException("Set add时异常。" + e.toString());
        }
    }

    /**
     * 获取set缓存的长度
     *
     * @param key 键
     * @return
     */
    public long sGetSetSize(String key) {
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("获取set缓存长度时，key不能为空");
        }
        try {
            return redisTemplate.opsForSet().size(key);
        } catch (Exception e) {
            logger.error(e.toString());
            throw new RuntimeException("获取set缓存长度时异常。" + e.toString());
        }
    }

    /**
     * 移除值为value的
     *
     * @param key    键
     * @param values 值 可以是多个
     * @return 移除的个数
     */
    public long setRemove(String key, Object... values) {
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("set移除值为value时，key不能为空");
        }
        try {
            return redisTemplate.opsForSet().remove(key, values);
        } catch (Exception e) {
            logger.error(e.toString());
            throw new RuntimeException("set移除值为value时异常。" + e.toString());
        }
    }




    //-------------------------List------------------------------------//
    /**
     * 获取list缓存的内容
     *
     * @param key   键
     * @param start 开始
     * @param end   结束 0 到 -1代表所有值
     * @return
     */
    public List<Object> lGet(String key, long start, long end) {
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("获取list缓存的内容时，key不能为空");
        }
        try {
            return redisTemplate.opsForList().range(key, start, end);
        } catch (Exception e) {
            logger.error(e.toString());
            throw new RuntimeException("获取list缓存的内容时异常。"  + e.toString());
        }
    }

    /**
     * 获取list缓存的长度
     *
     * @param key 键
     * @return
     */
    public long lGetListSize(String key) {
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("获取list缓存的长度时，key不能为空");
        }
        try {
            return redisTemplate.opsForList().size(key);
        } catch (Exception e) {
            logger.error(e.toString());
            throw new RuntimeException("获取list缓存的长度时异常。" + e.toString());
        }
    }

    /**
     * 通过索引 获取list中的值
     *
     * @param key   键
     * @param index 索引 index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
     * @return
     */
    public Object lGetIndex(String key, long index) {
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("通过索引获取list中的值，key不能为空");
        }
        try {
            return redisTemplate.opsForList().index(key, index);
        } catch (Exception e) {
            logger.error(e.toString());
            throw new RuntimeException("通过索引获取list中的值异常。" + e.toString());
        }
    }

    /**
     * 将缓存放入缓存
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public boolean lSet(String key, Object value) {
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("将list放入缓存，key不能为空");
        }
        try {
            redisTemplate.opsForList().rightPush(key, value);
            return true;
        } catch (Exception e) {
            logger.error(e.toString());
            throw new RuntimeException("将list放入缓存异常。" + e.toString());
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return
     */
    public boolean lSet(String key, Object value, long time) {
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("将list放入缓存，key不能为空");
        }
        try {
            redisTemplate.opsForList().rightPush(key, value);
            if (time > 0)
                expire(key, time);
            return true;
        } catch (Exception e) {
            logger.error(e.toString());
            throw new RuntimeException("将list放入缓存异常。" + e.toString());
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public boolean lSet(String key, List<Object> value) {
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("将list放入缓存，key不能为空");
        }
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            return true;
        } catch (Exception e) {
            logger.error(e.toString());
            throw new RuntimeException("将list放入缓存异常。" + e.toString());
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return
     */
    public boolean lSet(String key, List<Object> value, long time) {
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("将list放入缓存，key不能为空");
        }
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            if (time > 0)
                expire(key, time);
            return true;
        } catch (Exception e) {
            logger.error(e.toString());
            throw new RuntimeException("将list放入缓存异常。" + e.toString());
        }
    }

    /**
     * 根据索引修改list中的某条数据
     *
     * @param key   键
     * @param index 索引
     * @param value 值
     * @return
     */
    public boolean lUpdateIndex(String key, long index, Object value) {
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("根据索引修改list中的某条数据时，key不能为空");
        }
        try {
            redisTemplate.opsForList().set(key, index, value);
            return true;
        } catch (Exception e) {
            logger.error(e.toString());
            throw new RuntimeException("根据索引修改list中的某条数据时异常。" + e.toString());
        }
    }

    /**
     * 移除N个值为value
     *
     * @param key   键
     * @param count 移除多少个
     * @param value 值
     * @return 移除的个数
     */
    public long lRemove(String key, long count, Object value) {
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("移除N个值为value时，key不能为空");
        }
        try {
            Long remove = redisTemplate.opsForList().remove(key, count, value);
            return remove;
        } catch (Exception e) {
            logger.error(e.toString());
            throw new RuntimeException("移除N个值为value时异常。" + e.toString());
        }
    }

}
