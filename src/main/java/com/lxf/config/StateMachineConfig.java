package com.lxf.config;

import com.lxf.StateMachineDemo.Events;
import com.lxf.StateMachineDemo.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

/**
 * @Description 状态机配置类
 * @Author Administrator
 * @DATE 2019/4/1 17:25
 * @Version 1.0
 **/
@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<Status, Events> {
    private static Logger logger = LoggerFactory.getLogger(StateMachineConfig.class);
    /**
     * 定义初始状态和所有状态
     * @param states
     * @throws Exception
     */
    @Override
    public void configure(StateMachineStateConfigurer<Status, Events> states) throws Exception {
        states
            .withStates()
                .initial(Status.unpaid)
                .states(EnumSet.allOf(Status.class));
    }

    /**
     * 定义状态迁移
     * @param transitions
     * @throws Exception
     */
    @Override
    public void configure(StateMachineTransitionConfigurer<Status, Events> transitions) throws Exception {
        transitions
             .withExternal()
                .source(Status.unpaid).target(Status.waiting_for_receive).event(Events.pay)
                .and()
             .withExternal()
                .source(Status.waiting_for_receive).target(Status.done).event(Events.receive);
    }



}
