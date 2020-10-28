//package com.lxf.mq.rabbitMq;
//
//import com.rabbitmq.client.Channel;
//import com.lxf.config.rabbitMq.RabbitMqConfig;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
///**
// * rabbitmq消费者
// */
//@Component
//@Slf4j
//public class Receiver {
//
//    @RabbitListener(queues = RabbitMqConfig.QUEUE_NAME)
//    public void receive(Message message, Channel channel) throws IOException {
//        //Message投递标识
//        long deliveryTag = message.getMessageProperties().getDeliveryTag();
//        try {
//            System.out.println("收到消息：" + new String(message.getBody()));
//            channel.basicAck(deliveryTag, false);
//        } catch (IOException e) {
//            log.error("消费失败{}", e);
//            //大多数情况下，消费失败后，再重新消费，还会失败，所以重试一次，根据Message是否重试的标识
//            Boolean redelivered = message.getMessageProperties().getRedelivered();
//            if (!redelivered) {
//                //没有重试过，则重试一次
//                channel.basicNack(deliveryTag, false, true);
//                return;
//            }
//            //重复过，直接丢弃消息
//            channel.basicNack(deliveryTag, false, false);
//
//        }
//    }
//
//
//}
