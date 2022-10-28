package com.lxf.web.action.redis.jedis;

import com.lxf.config.JedisConfig;
import com.lxf.utils.JedisUtil;
import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.Pipeline;

import java.util.List;

/**
 * redis管道PipeLine
 * PipeLine不是原子性的，客户端通过管道将多条命令批量发送给Server端，Server端依次执行命令，不管执行过程中是否报错
 */
public class Test {
    private static Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JedisConfig.class);
//        /*
//        测试管道
//         */
//        long start = System.currentTimeMillis();
//        for(int i = 0; i < 10000; i++){
//            JedisUtil.set("key_" +i, "value_" + i + 1);
//        }
//        long end = System.currentTimeMillis();
//        logger.info("普通耗时：" + (end - start)/1000 + "s");

//        Pipeline pipeline = JedisUtil.getPipeLined();
//        long start1 = System.currentTimeMillis();
//        for(int i = 0; i < 10; i++){
//            pipeline.set("key_" +i, "value_" + i);
//            // 模拟redis报错 // [OK, redis.clients.jedis.exceptions.JedisDataException: ERR bit offset is not an integer or out of range, OK,...
//            pipeline.setbit("zhuge", -1, true);
//        }
//        List<Object> result = pipeline.syncAndReturnAll();
//        long end1 = System.currentTimeMillis();
//        logger.info("pipeLine耗时：" + (end1 - start1)/1000 + "s");
//        System.out.println(result); //正常结果 [OK, OK, OK, OK, OK, OK, OK, OK, OK, OK


        /*
        测试主从架构
        主节点宕机后，先打印出错误，停一会，又会继续设置key(因为哨兵机制重新选择出了主节点)
         */
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JedisConfig.class);
//        JedisSentinelPool pool = (JedisSentinelPool)context.getBean("jedisSentinelPool");
//        Jedis resource = pool.getResource();
//        int i = 0;
//        while (true) {
//            try {
//                String key = "zhuge"+i;
//                resource.set(key, i+"");
//                i++;
//                System.out.println("设置key:" + key);
//                Thread.sleep(2000);
//            }catch (Exception e) {
//                logger.error("错误：" + e);
//            }
//        }



        /*
        测试集群架构
         */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JedisConfig.class);
        JedisCluster jedisCluster = (JedisCluster)context.getBean("jedisCluster");
        jedisCluster.set("cluster", "zhuge");
    }



}
