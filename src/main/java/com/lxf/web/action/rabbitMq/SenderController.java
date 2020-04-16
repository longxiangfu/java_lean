package com.lxf.web.action.rabbitMq;

import com.lxf.config.rabbitMq.RabbitMqConfig;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/rabbitMq")
public class SenderController {

    @Resource
    RabbitTemplate template;


    @PostMapping("/send")
    public void send(){
        String directExchangeName = RabbitMqConfig.DIRECT_EXCHANGE_NAME;
        String routingKey = RabbitMqConfig.ROUTING_KEY;
        String message = "我是一条消息";
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        template.convertAndSend(directExchangeName, routingKey, message, correlationData);
    }




}
