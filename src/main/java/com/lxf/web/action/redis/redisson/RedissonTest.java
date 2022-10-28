package com.lxf.web.action.redis.redisson;

import com.lxf.utils.RedisTemplate.CacheUtil;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.redisson.Redisson;
import org.redisson.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 分布式锁Redisson测试
 * 1、分布式锁:指的是集群的形式
 * 2、Redisson练习
 */
@Controller
@RequestMapping("/redis")
public class RedissonTest {
    private static Logger logger = LoggerFactory.getLogger(RedissonTest.class);
    //分布式锁key
    private static String lockKey = "testRedisson";

    @Resource
    Redisson redisson;
    @Resource
    RedissonClient redissonClient;
    @Resource
    RedissonReactiveClient redissonReactiveClient;
    @Resource
    CacheUtil cacheUtil;

    @PostMapping("/test")
    public void test(){
        //1、
        RBucket<String> keyObject = redissonClient.getBucket("name");
        keyObject.set("longxiangfu");
        //2、异步调用程序接口
        RAtomicLongAsync rAtomicLongAsync = redissonClient.getAtomicLong("myLong");
        RFuture<Boolean> future = rAtomicLongAsync.compareAndSetAsync(1, 401);
        future.whenComplete((res, exception) ->{
//            System.out.println("res exceptionn:"+ res + " " + exception.getMessage());
            logger.info("res:" + res);
            logger.info("exception:" + exception.getMessage());
        });
        //3、异步流调用程序接口
        RAtomicLongReactive rAtomicLongReactive = redissonReactiveClient.getAtomicLong("myLong");
        Publisher<Boolean> publisher = rAtomicLongReactive.compareAndSet(10, 91);
        publisher.subscribe(new Subscriber<Boolean>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                subscription.request(100);
            }

            @Override
            public void onNext(Boolean aBoolean) {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        });



        //分布式锁
        RLock rLock = redisson.getLock(lockKey);
        rLock.lock(60, TimeUnit.SECONDS);
//        rLock.lockAsync(60, TimeUnit.SECONDS);
//        rLock.tryLockAsync(60, TimeUnit.SECONDS);
        try{
            Future<Boolean> res = rLock.tryLockAsync(60, 20,TimeUnit.SECONDS);//leaseTime超时时间
            boolean result = res.get();
            //加锁成功
            if (result) {
                Integer count = cacheUtil.getCache("stock", Integer.class);
                //减库存
                if ((count > 0)) {
                    cacheUtil.set("stock", count-1, 60*60*24);
                }else{
                    System.out.println("没有库存了");
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            rLock.unlock();
        }
    }


    public static void main(String[] args) {

    }
}
