package com.lxf.aop;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)//指定原型模式
//@Scope("prototype")
@RestController
@RequestMapping("/aop")
public class AopController {

//    @Autowired
//    JdbcTemplate jdbcTemplate;//Spring中使用JdbcTemplate来操作数据库

    @GetMapping("/test")
    public void testAop(){
        System.out.println("我是test aop");
    }

}
