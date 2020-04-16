package com.lxf.config.rabbitMq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * 消息对Queue不可达时回调
 */
public class RabbitMqReturnCallback implements RabbitTemplate.ReturnCallback {
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        String correlationId = message.getMessageProperties().getCorrelationId();
        System.out.println(String.format("消息对Queue不可达时通知。" +
        "message：%s；replyCode：%s；replyText：%s；exchange：%s；routingKey：%s；correlationId：%s", message, replyCode, replyText,
                exchange, routingKey, correlationId));
        //TODO
        //重试三次后，还没有到达的话，就将消息存入mongoDb中，并且邮件通知人工干预,待人工解决后，手动重新消费
    }
}
