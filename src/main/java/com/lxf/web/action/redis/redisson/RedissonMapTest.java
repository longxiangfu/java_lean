//package com.lxf.web.action.redis;
//
//import org.redisson.Redisson;
//import org.redisson.api.RMap;
//import org.redisson.api.RMapCache;
//import org.redisson.api.RedissonClient;
//import org.redisson.api.RedissonReactiveClient;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.concurrent.ExecutionException;
//
///**
// * 分布式锁Redisson集合对象Map测试
// */
//@Controller
//@RequestMapping("/redis/map")
//public class RedissonMapTest {
//    private static Logger logger = LoggerFactory.getLogger(RedissonMapTest.class);
//
//    @Autowired
//    Redisson redisson;
//    @Autowired
//    RedissonClient redissonClient;
//    @Autowired
//    RedissonReactiveClient redissonReactiveClient;
//
//    @PostMapping("/test")
//    public void test() throws ExecutionException, InterruptedException {
//        RMap<String, String> map = redisson.getMap("anyMap");
//        /*
//        1.简单操作
//         */
////        map.put("1", "1");//不管redis中是否已经有key，都进行重新赋值
////        map.put("1", "11");
////
////        map.putIfAbsent("2", "2");
////        map.putIfAbsent("2", "22");//如果redis中已经有key，则不进行重新赋值
////        map.remove("1");
////
////        map.fastPut("3", "3");
////        map.fastRemove("3");
////
////        RFuture<String> putAsync = map.putAsync("4", "4");
////        System.out.println(putAsync.get());
////        RFuture<Boolean> fastPutAsync = map.fastPutAsync("5", "5");
////        System.out.println(fastPutAsync.get());
//
//        /*
//        2.映射的字段锁
//         */
////        RLock keyLock = map.getLock("2");
////        keyLock.lock();
////        try{
////            String value = map.get("2");
////            Thread.sleep(2000);
////            System.out.println("我获取的锁" + Thread.currentThread().getName());
////        }finally {
////            keyLock.unlock();
////        }
//
////        RReadWriteLock rwLock = map.getReadWriteLock("2");
////        rwLock.readLock().lock();
////        try {
////            String value = map.get("2");
////            System.out.println("我获取的锁" + Thread.currentThread().getName());
////        }finally {
////            rwLock.readLock().unlock();
////        }
//
//        //元素淘汰RMapCache  ttl：有效时间    maxIdleTime：最大空闲时间
////        RMapCache<String, String> map1 = redisson.getMapCache("anyMap");
////        map1.put("key1", "value1", 30, TimeUnit.SECONDS);
////        map1.put("key2", "value2", 30, TimeUnit.SECONDS, 10, TimeUnit.SECONDS);
//
//        //本地缓存  LocalCachedMap
////        LocalCachedMapOptions options = LocalCachedMapOptions.defaults()
////                .evictionPolicy(LocalCachedMapOptions.EvictionPolicy.NONE)
////                .cacheSize(1000)
////                .reconnectionStrategy(LocalCachedMapOptions.ReconnectionStrategy.NONE)
////                .syncStrategy(LocalCachedMapOptions.SyncStrategy.INVALIDATE)
////                .timeToLive(30, TimeUnit.SECONDS)
////                .maxIdle(10, TimeUnit.SECONDS);
////        RLocalCachedMap<String, Integer> map2 = redisson.getLocalCachedMap("anyMap", options);
////        map2.put("123", 1);
//
//        //数据分片功能
//
//        //数据持久化
////        MapOptions<String, String> options1 = MapOptions.<String, String>defaults()
////        .writer(new MapWriter<String, String>() {
////            @Override
////            public void write(String key, String value) {
////
////            }
////
////            @Override
////            public void writeAll(Map<String, String> map) {
////
////            }
////
////            @Override
////            public void delete(String key) {
////
////            }
////
////            @Override
////            public void deleteAll(Collection<String> keys) {
////
////            }
////        })
////        .loader(new MapLoader<String, String>() {
////            @Override
////            public String load(String key) {
////                return null;
////            }
////
////            @Override
////            public Iterable<String> loadAllKeys() {
////                return null;
////            }
////        });
////        Map<String, String> map1 = redisson.getMap("test", options1);
////        //或
////        RMapCache<String, String> map3 = redisson.getMapCache("test", options1);
//
//
//        //映射监听器  EntryCreatedListener   EntryExpiredListener  EntryRemovedListener  EntryUpdateListener
////        RMapCache<String, String> map1 = redisson.getMapCache("myMap");
////        int createListener = map1.addListener(new EntryCreatedListener<Integer, Integer>() {
////            @Override
////            public void onCreated(EntryEvent event) {
////                event.getKey();
////                event.getValue();
////                event.getOldValue();
////            }
////        });
//
//
//        //有界映射：限制映射的最大容量限制
//        RMapCache<String, String> map1 = redisson.getMapCache("myMap");
//        map1.trySetMaxSize(100);
//
//
//    }
//
//
//
//
//
//
//
//    public static void main(String[] args) {
//
//    }
//}
