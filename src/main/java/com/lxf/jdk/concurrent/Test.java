package com.lxf.jdk.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 高并发问题解决：
 * 1：spring事务@Transactional加载方法上，导致线程执行该方法之前，先要拿数据库连接，而方法内可能有调用远程耗时的接口，导致数据库连接不够
 * 解决：使用事务模板TransactionalTemplate
 * 2:幂等性：同一订单多次调用发货接口，只能有一次发货成功
 * 解决：乐观锁version
 */
public class Test {
    private static Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        //1

    }

//    @Transactional
    public static void sendOrder(Integer orderId){
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        Boolean lockStatus = transactionTemplate.execute(new TransactionCallback<Boolean>() {
            @Override
            public Boolean doInTransaction(TransactionStatus transactionStatus) {
                //将订单状态更新到数据库：正在发送中
                //return 1 == 更新影响的条数
                return null;
            }
        });

        if (lockStatus) {
            //获取到锁后，调用远程下单接口，
            // 并将相应订单状态更新数据库
        }else {
            logger.info("lockSuccess:" + orderId);
        }




    }
}
