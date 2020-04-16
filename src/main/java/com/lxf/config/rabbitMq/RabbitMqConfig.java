package com.lxf.config.rabbitMq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;


@Configuration
public class RabbitMqConfig {
    public static final String QUEUE_NAME = "myQueue";
    public static final String DIRECT_EXCHANGE_NAME = "myDirectExchange";
    public static final String BINDING_KEY = "key";
    public static final String ROUTING_KEY = "key";

    @Resource
    private RabbitTemplate template;


    /**
     * 根据@PostConstruct源码可知，被@PostConstruct修饰的方法，将在类属性设置（依赖注入）之后，初始化之前被调用
     */
    @PostConstruct
    public void initRabbitTemplate(){
        template.setConfirmCallback(new RabbitMqConfirmCallback());
        template.setReturnCallback(new RabbitMqReturnCallback());
    }


    /**
     * 申明队列
     * @return
     */
    @Bean
    public Queue getQueue(){
        return new Queue(QUEUE_NAME, true);//第二个参数：持久化队列
    }

    /**
     * 申明交换器
     * @return
     */
    @Bean
    public DirectExchange getDirectExchange(){
        return new DirectExchange(DIRECT_EXCHANGE_NAME, true, false);//第二个参数：持久化Exchange
    }

    /**
     * ?????
     * @param queue
     * @param directExchange
     * @return
     */
    @Bean
    public Binding bind(Queue queue, DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with(BINDING_KEY);
    }


}
