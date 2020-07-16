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
// * 分布式锁Redisson集合对象
// * Set  集
// * SortedSet  有序集
// * ScoredSoredSet  计分排序集
// * LexSortedSet  字典排序集
// *
// * List  集合
// * Queue  队列
// * Deque  双端队列
// * Blocking Queue  阻塞队列
// * 等等
// */
//@Controller
//@RequestMapping("/redis/set")
//public class RedissonSetTest {
//    private static Logger logger = LoggerFactory.getLogger(RedissonSetTest.class);
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
////        //Set
////        RSet<String> set = redisson.getSet("anySet");
////        set.add("1");
////        set.add("2");
////
////        RSetCache<String> set1 = redisson.getSetCache("anySet1");
////        set1.add("1", 10, TimeUnit.SECONDS);
////
////
////        //SortedSet
////        RSortedSet<Integer> set2 = redisson.getSortedSet("anySortedSet");
////        set2.trySetComparator(new Comparator<Integer>() {
////            @Override
////            public int compare(Integer o1, Integer o2) {
////                return o2 - o1;
////            }
////        });
////        set2.add(3);
////        set2.add(2);
////        set2.add(1);
////        set2.stream().forEach(e ->{
////            System.out.println(e);
////        });
//
//
//        //ScoredSoredSet
//        RScoredSortedSet<Integer> rss = redisson.getScoredSortedSet("scoreSortedSet");
//        rss.add(0.13, 1);
//        rss.add(0.302, 2);
//        rss.add(0.251, 3);
//        int index = rss.rank(2);
//        System.out.println("2在集合中的位置:" + index);
//        double score = rss.getScore(3);
//        System.out.println("3的分数:" + score);
//
//        //队列:阻塞队列、延迟队列
//        RBlockingQueue<Object> blockingQueue = redisson.getBlockingQueue("blockingQueue");
//        blockingQueue.add("a");
//        blockingQueue.add("b");
//        blockingQueue.add("c");
//        blockingQueue.take();
//        RDelayedQueue<Object> delayedQueue = redisson.getDelayedQueue(blockingQueue);
//        delayedQueue.offer("d", 1, TimeUnit.SECONDS);
//    }
//}
