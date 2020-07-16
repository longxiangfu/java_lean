package com.lxf.web.action.redis.redisTemplate;

import com.lxf.utils.RedisTemplate.RedisTemplateUtil;
import com.lxf.utils.SpringContextUtil;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/redis")
public class Test {

    @Resource
    RedisTemplateUtil redisTemplateUtil;


    /**
     * 模糊查询keys
     * @param keys
     * @return
     */
    @GetMapping("/keys")
    public Set<String> keys(String keys) {
        RedisTemplateUtil redisTemplateUtil = SpringContextUtil.getBean(RedisTemplateUtil.class);
        Set<String> set = redisTemplateUtil.keys(keys);
        if (!CollectionUtils.isEmpty(set)) {
            Iterator<String> iterator = set.iterator();
            if (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
        return set;
    }


    /**
     * 指定缓存失效时间
     * @param key
     * @param time
     * @return
     */
    @PostMapping("/expire")
    public boolean expire(String key, long time){
        return redisTemplateUtil.expire(key, time);
    }

    /**
     * 根据key获取过期时间
     * @param key
     * @return
     */
    @PostMapping("/getExpire")
    public long getExpire(String key){
        return redisTemplateUtil.getExpire(key);
    }

    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    @PostMapping("/hasKey")
    public boolean hasKey(String key) {
        return redisTemplateUtil.hasKey(key);
    }


    //-------------------------String------------------------------------//

    /**
     * 删除缓存
     *
     * @param key 可以传一个值 或多个
     */
    @PostMapping("/delString")
    public void del(String... key) {
        redisTemplateUtil.del(key);
    }

    /**
     * 普通缓存获取
     *
     * @param key 键
     * @return 值
     */
    @PostMapping("/getString")
    public Object get(String key) {
        Object o = redisTemplateUtil.get(key);
        return o;
    }

    /**
     * 普通缓存放入
     *
     * @param key   键
     * @param value 值
     * @return true成功 false失败
     */
    @PostMapping("/setString")
    public boolean set(String key, String value) {
        boolean set = redisTemplateUtil.set(key, value);
        return set;
    }

    /**
     * 普通缓存放入并设置时间
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return true成功 false 失败
     */
    @PostMapping("/setStringExpire")
    public boolean set(String key, String value, long time) {
        boolean set = redisTemplateUtil.set(key, value, time);
        return set;

    }

    /**
     * 递增
     *
     * @param key   键
     * @param delta 要增加几(大于0)
     * @return
     */
    @PostMapping("incrString")
    public long incr(String key, long delta) {
        long incr = redisTemplateUtil.incr(key, delta);
        return incr;
    }

    /**
     * 递减
     *
     * @param key   键
     * @param delta 要减少几(小于0)
     * @return
     */
    @PostMapping("/decrString")
    public long decr(String key, long delta) {
        long decr = redisTemplateUtil.decr(key, delta);
        return decr;
    }


    //-------------------------Hash------------------------------------//
    /**
     * HashGet
     *
     * @param key  键 不能为null
     * @param item 项 不能为null
     * @return 值
     */
    @PostMapping("/hgetHash")
    public Object hget(String key, String item) {
        Object hget = redisTemplateUtil.hget(key, item);
        return hget;
    }

    /**
     * 获取hashKey对应的所有键值
     *
     * @param key 键
     * @return 对应的多个键值
     */
    @PostMapping("/hmgetHash")
    public Map<Object, Object> hmget(String key) {
        Map<Object, Object> hmget = redisTemplateUtil.hmget(key);
        return hmget;
    }

    /**
     * HashSet
     *
     * @param key 键
     * @param map 对应多个键值
     * @return true 成功 false 失败
     */
    @PostMapping("/hmsetHash")
    public boolean hmset(String key, Map<String, String> map) {
        boolean hmset = redisTemplateUtil.hmset(key, map);
        return hmset;
    }

    /**
     * HashSet 并设置时间
     *
     * @param key  键
     * @param map  对应多个键值
     * @param time 时间(秒)
     * @return true成功 false失败
     */
    @PostMapping("/hmsetHashExpire")
    public boolean hmset(String key, Map<String, String> map, long time) {
        boolean hmset = redisTemplateUtil.hmset(key, map, time);
        return hmset;
    }

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     *
     * @param key   键
     * @param item  项
     * @param value 值
     * @return true 成功 false失败
     */
    @PostMapping("/hsetHashItemValue")
    public boolean hset(String key, String item, String value) {
        boolean hset = redisTemplateUtil.hset(key, item, value);
        return hset;
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
    @PostMapping("/hsetHashItemValueExpire")
    public boolean hset(String key, String item, String value, long time) {
        boolean hset = redisTemplateUtil.hset(key, item, value, time);
        return hset;
    }

    /**
     * 删除hash表中的值
     *
     * @param key  键 不能为null
     * @param item 项 可以使多个 不能为null
     */
    @PostMapping("/hdelHash")
    public void hdel(String key, String... item) {
        redisTemplateUtil.hdel(key, item);
    }

    /**
     * 判断hash表中是否有该项的值
     *
     * @param key  键 不能为null
     * @param item 项 不能为null
     * @return true 存在 false不存在
     */
    @PostMapping("/hHashKeyHash")
    public boolean hHasKey(String key, String item) {
        boolean b = redisTemplateUtil.hHasKey(key, item);
        return b;
    }

    /**
     * hash递增 如果不存在,就会创建一个 并把新增后的值返回
     *
     * @param key  键
     * @param item 项
     * @param by   要增加几(大于0)
     * @return
     */
    @PostMapping("/hinctHash")
    public double hincr(String key, String item, double by) {
        double hincr = redisTemplateUtil.hincr(key, item, by);
        return hincr;
    }

    /**
     * hash递减
     *
     * @param key  键
     * @param item 项
     * @param by   要减少记(小于0)
     * @return
     */
    @PostMapping("/hdecrHash")
    public double hdecr(String key, String item, double by) {
        double hdecr = redisTemplateUtil.hdecr(key, item, by);
        return hdecr;
    }




    //-------------------------Set------------------------------------//
    /**
     * 根据key获取Set中的所有值
     *
     * @param key 键
     * @return
     */
    @PostMapping("/sGetSet")
    public Set<Object> sGet(String key) {
        Set<Object> objects = redisTemplateUtil.sGet(key);
        return objects;
    }

    /**
     * 根据value从一个set中查询,是否存在
     *
     * @param key   键
     * @param value 值
     * @return true 存在 false不存在
     */
    @PostMapping("/sHasKeySet")
    public boolean sHasKey(String key, String value) {
        boolean b = redisTemplateUtil.sHasKey(key, value);
        return b;
    }

    /**
     * 将数据放入set缓存
     *
     * @param key    键
     * @param values 值 可以是多个
     * @return 成功个数
     */
    @PostMapping("/sSetSet")
    public long sSet(String key, String... values) {
        long l = redisTemplateUtil.sSet(key, values);
        return l;
    }

    /**
     * 将set数据放入缓存
     *
     * @param key    键
     * @param time   时间(秒)
     * @param values 值 可以是多个
     * @return 成功个数
     */
    @PostMapping("/sSetSetExpire")
    public long sSetAndTime(String key, long time, String... values) {
        long l = redisTemplateUtil.sSetAndTime(key, time, values);
        return l;
    }

    /**
     * 获取set缓存的长度
     *
     * @param key 键
     * @return
     */
    @PostMapping("sGetSetSizeSet")
    public long sGetSetSize(String key) {
        long l = redisTemplateUtil.sGetSetSize(key);
        return l;
    }

    /**
     * 移除值为value的
     *
     * @param key    键
     * @param values 值 可以是多个
     * @return 移除的个数
     */
    @PostMapping("/setRemoveSet")
    public long setRemove(String key, String... values) {
        long l = redisTemplateUtil.setRemove(key, values);
        return l;
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
    @PostMapping("/lGetList")
    public List<Object> lGet(String key, long start, long end) {
        List<Object> objects = redisTemplateUtil.lGet(key, start, end);
        return objects;
    }

    /**
     * 获取list缓存的长度
     *
     * @param key 键
     * @return
     */
    @PostMapping("/lGetListSizeList")
    public long lGetListSize(String key) {
        long l = redisTemplateUtil.lGetListSize(key);
        return l;
    }

    /**
     * 通过索引 获取list中的值
     *
     * @param key   键
     * @param index 索引 index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
     * @return
     */
    @PostMapping("/LGetIndexList")
    public Object lGetIndex(String key, long index) {
        Object o = redisTemplateUtil.lGetIndex(key, index);
        return o;
    }

    /**
     * 将缓存放入缓存
     *
     * @param key   键
     * @param value 值
     * @return
     */
    @PostMapping("/lSetHash")
    public boolean lSet(String key, String value) {
        boolean b = redisTemplateUtil.lSet(key, value);
        return b;
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return
     */
    @PostMapping("/lSetListExpire")
    public boolean lSet(String key, String value, long time) {
        boolean b = redisTemplateUtil.lSet(key, value, time);
        return b;
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @return
     */
    @PostMapping("/lSetListList")
    public boolean lSet(String key, List<String> value) {
        boolean b = redisTemplateUtil.lSet(key, value);
        return b;
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return
     */
    @PostMapping("/lSetListListExpire")
    public boolean lSet(String key, List<String> value, long time) {
        boolean b = redisTemplateUtil.lSet(key, value, time);
        return b;
    }

    /**
     * 根据索引修改list中的某条数据
     *
     * @param key   键
     * @param index 索引
     * @param value 值
     * @return
     */
    @PostMapping("/lUpdateIndexList")
    public boolean lUpdateIndex(String key, long index, String value) {
        boolean b = redisTemplateUtil.lUpdateIndex(key, index, value);
        return b;
    }

    /**
     * 移除N个值为value
     *
     * @param key   键
     * @param count 移除多少个
     * @param value 值
     * @return 移除的个数
     */
    @PostMapping("/lRemoveList")
    public long lRemove(String key, long count, String value) {
        long l = redisTemplateUtil.lRemove(key, count, value);
        return l;
    }


}
