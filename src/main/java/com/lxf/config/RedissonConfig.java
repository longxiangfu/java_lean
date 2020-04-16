//package com.lxf.config;
//
//import org.redisson.Redisson;
//import org.redisson.api.RedissonClient;
//import org.redisson.api.RedissonReactiveClient;
//import org.redisson.config.Config;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RedissonConfig {
//    @Bean
//    public Redisson redisson(){
//        Config config = new Config();
//        config.useSingleServer().setAddress("redis://localhost:6379");
//        return (Redisson) Redisson.create(config);
//    }
//
//    @Bean
//    public RedissonClient redissonClient(){
//        Config config = new Config();
//        config.useSingleServer().setAddress("redis://localhost:6379");
//        return Redisson.create(config);
//    }
//
//    @Bean
//    public RedissonReactiveClient redissonReactiveClient(){
//        Config config = new Config();
//        config.useSingleServer().setAddress("redis://localhost:6379");
//        return Redisson.createReactive(config);
//    }
//}
