package com.lxf.config;

import org.redisson.Redisson;
import org.redisson.RedissonReactive;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {
    @Bean
    public Redisson redisson(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://172.17.99.98:6379");
        config.useSingleServer().setPassword("123456");
        return (Redisson) Redisson.create(config);
    }

    @Bean
    public RedissonReactive redissonReactive(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://172.17.99.98:6379");
        config.useSingleServer().setPassword("123456");
        return (RedissonReactive) Redisson.createReactive(config);
    }
}
