package com.lxf.annotation.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class ConditionalAutoConfig {

    @Bean
    @Conditional(RandomIntegerCondition.class)
    public RandDataComponent<Integer> randIntComponent(){
        RandDataComponent component = new RandDataComponent();
        component.setRand(new Random().nextInt(100));
       return component;
    }

    @Bean
    @Conditional(RandomBooleanCondition.class)
    public RandDataComponent<Boolean> randBooleanComponent(){
        RandDataComponent component = new RandDataComponent();
        component.setRand(new Random().nextBoolean());
        return component;
    }
}
