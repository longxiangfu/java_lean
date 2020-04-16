package com.lxf.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * @Description
 * @Author Administrator
 * @DATE 2019/4/1 20:11
 * @Version 1.0
 **/
@WithStateMachine
public class EvenConfig {
    private static Logger logger = LoggerFactory.getLogger(EvenConfig.class);

    @OnTransition(target = "unpaid")
    public void create(){
        logger.info("订单创建，待支付");
    }

    @OnTransition(source = "unpaid", target = "waiting_for_receive")
    public void pay(){
        logger.info("用户完成支付，待收货");
    }

    @OnTransition(source = "waiting_for_receive", target = "done")
    public void receive(){
        logger.info("用户已收货，订单完成");
    }
}
