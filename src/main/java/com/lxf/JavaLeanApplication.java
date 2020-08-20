package com.lxf;

import com.dtflys.forest.annotation.ForestScan;
import com.lxf.StateMachineDemo.Events;
import com.lxf.StateMachineDemo.Status;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;

@SpringBootApplication(scanBasePackages = "com.lxf")//exclude = SpilitAutoConfiguration.class 排除自动配置
@MapperScan(basePackages = "com.lxf.web.dao")
@EnableTransactionManagement
@ForestScan(basePackages = "com.lxf.interfaces")
public class JavaLeanApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JavaLeanApplication.class, args);
    }


    @Resource
    private StateMachine<Status, Events> stateMachine;

    @Override
    public void run(String... args) throws Exception {
        //dev test
        //pull request test
        //pull request test1
        stateMachine.start();
        stateMachine.sendEvent(Events.pay);
        stateMachine.sendEvent(Events.receive);
    }
}
