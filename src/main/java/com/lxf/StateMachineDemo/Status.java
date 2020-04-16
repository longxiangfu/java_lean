package com.lxf.StateMachineDemo;

/**
 * 定义状态
 */
public enum Status {
    unpaid,//待支付
    waiting_for_receive,//待收货
    done//结束
}
