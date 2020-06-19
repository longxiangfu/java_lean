//package com.lxf.redis;
//
//import com.lxf.utils.JedisUtil;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import redis.clients.jedis.Pipeline;
//
///**
// * redis管道PipeLine
// */
//public class Test {
//    private static Logger logger = LoggerFactory.getLogger(Test.class);
//
//    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
//        for(int i = 0; i < 10000; i++){
//            JedisUtil.set("key_" +i, "value_" + i + 1);
//        }
//        long end = System.currentTimeMillis();
//        logger.info("普通耗时：" + (end - start)/1000 + "s");
//
//        Pipeline pipeline = JedisUtil.getPipeLined();
//        long start1 = System.currentTimeMillis();
//        for(int i = 0; i < 10000; i++){
//            pipeline.set("key_" +i, "value_" + i + 1);
//        }
//        long end1 = System.currentTimeMillis();
//        logger.info("pipeLine耗时：" + (end1 - start1)/1000 + "s");
//    }
//}
