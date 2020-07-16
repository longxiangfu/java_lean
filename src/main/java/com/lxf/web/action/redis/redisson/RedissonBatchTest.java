//package com.lxf.web.action.redis;
//
//import org.redisson.Redisson;
//import org.redisson.api.RBatch;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.concurrent.TimeUnit;
//
///**
// *命令批量执行：即管道
// */
//public class RedissonBatchTest {
//    @Autowired
//    static Redisson redisson;
//
//    public static void main(String[] args) throws InterruptedException {
//        RBatch batch = redisson.createBatch();
//        batch.getMap("test").fastPutAsync("1", "2");
//        batch.getMap("test").putAsync("2", "3");
//        batch.getAtomicLong("counter").incrementAndGetAsync();
//        batch.atomic();//原子化（事务）批量执行所有命令
//        batch.skipResult();//告知redis不用返回结果
//        //将写入操作同步到2个从节点，等待时间为2秒
//        batch.syncSlaves(2, 1, TimeUnit.SECONDS);
//        //超时
//        batch.timeout(2, TimeUnit.SECONDS);
//        //重试间隔时间
//        batch.retryInterval(2, TimeUnit.SECONDS);
//        //重试次数
//        batch.retryAttempts(4);
//        //执行批量操作
//        batch.execute();// RFuture<BatchResult<?>> future = batch.executeAsync();
//
//
//    }
//}