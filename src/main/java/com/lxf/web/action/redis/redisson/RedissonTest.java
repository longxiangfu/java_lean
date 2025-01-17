package com.lxf.web.action.redis.redisson;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.redisson.Redisson;
import org.redisson.RedissonReactive;
import org.redisson.api.RAtomicLongAsync;
import org.redisson.api.RAtomicLongReactive;
import org.redisson.api.RFuture;
import org.redisson.api.RLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 分布式锁Redisson测试
 * Redisson练习
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
    RedissonReactive redissonReactive;

    @GetMapping("/async")
    public void async(){
        // 异步调用程序接口
        RAtomicLongAsync rAtomicLongAsync = redisson.getAtomicLong("myLong");
        RFuture<Boolean> future = rAtomicLongAsync.compareAndSetAsync(1, 401);
        future.whenComplete((res, exception) ->{
            logger.info("res:" + res);
            logger.info("exception:" + exception.getMessage());
        });

        // 异步流调用程序接口
        RAtomicLongReactive rAtomicLongReactive = redissonReactive.getAtomicLong("myLong");
        Publisher<Boolean> publisher = rAtomicLongReactive.compareAndSet(10, 91);
        publisher.subscribe(new Subscriber<Boolean>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                subscription.request(100);
            }

            @Override
            public void onNext(Boolean aBoolean) {
                System.out.print("onNext");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.print("onError");
            }

            @Override
            public void onComplete() {
                System.out.print("onComplete");

            }
        });


    }


    @GetMapping("/lock")
    public void testLock() {
        RLock rLock = redisson.getLock(lockKey);
        // 有看门狗的逻辑和where true的逻辑
        rLock.lock();
        // 没有where true的逻辑（自旋）和看门狗的逻辑（锁续期）
        // 第一个参数：在指定时间内没有获取到锁直接返回  第二个参数：获取到锁后的锁超时时间
//        try {
//            rLock.tryLock(10, 10,  TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        try{
            Future<Boolean> res = rLock.tryLockAsync(60, 20,TimeUnit.SECONDS);//leaseTime超时时间
            boolean result = res.get();
            //加锁成功
            if (result) {
                int count = 10; // 模拟从缓存中获取库存
                //减库存
                if (count > 0) {
                    count -= 1;
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
