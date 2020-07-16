//package com.lxf.web.action.redis;
//
//import org.redisson.Redisson;
//import org.redisson.api.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.TimeUnit;
//
///**
// * 分布式锁Redisson集合对象MultiMap测试
// * 多值映射
// */
//@Controller
//@RequestMapping("/redis/multiMap")
//public class RedissonMultiMapTest {
//    private static Logger logger = LoggerFactory.getLogger(RedissonMultiMapTest.class);
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
//        //基于Set的(也有基于List)
////        RSetMultimap<String, String> map = redisson.getSetMultimap("setMultiMap");
////        map.put("1", "1");
////        map.put("1", "21");
////        map.put("2", "2");
////        RSet<String> set = map.get("1");
////        set.stream().forEach(e ->{
////            System.out.println(e);
////        });
//
//        //多值映射淘汰
//        RSetMultimapCache<String, String > multiMap = redisson.getSetMultimapCache("setMultiMap1");
//        multiMap.put("1", "1");
//        multiMap.expireKey("1", 10, TimeUnit.SECONDS);
//
//
//
//    }
//}
