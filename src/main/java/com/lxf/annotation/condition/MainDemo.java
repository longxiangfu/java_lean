package com.lxf.annotation.condition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 演示条件注解（项目启动时Configuration或扫描（同Configuration））
 * 作用：1.同名bean（randDataComponent）,选择创建哪一个   2.某些bean的创建需要依赖某些先决条件
 * spring为我们提供了一些条件，如@ConditionalOnClass等，我们按扫描的方式直接用即可
 */
@RestController
@RequestMapping("/condition")
public class MainDemo {
    @Autowired
    RandDataComponent randDataComponent;

    @GetMapping
    public void test(){
        System.out.println(randDataComponent.getRand());
    }


}
