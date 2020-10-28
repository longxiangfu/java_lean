//package com.lxf.config.rabbitMq;
//
//import org.springframework.amqp.rabbit.connection.CorrelationData;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//
///**
// * 消息对Exchange的回调
// */
//public class RabbitMqConfirmCallback implements RabbitTemplate.ConfirmCallback {
//    @Override
//    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
//        System.out.println(String.format("消息是否到达Exchange。" +
//                "correlationId：%s；ack：%s；cause：%s", correlationData.toString(), ack, cause));
//        //TODO
//        //若ack=false，即消息没有到达Exchange,则重试，重试三次后，还没有到达的话，就将消息存入mongoDb中，并且邮件通知人工干预,
//        //待人工解决后，手动重新消费
//    }
//}
