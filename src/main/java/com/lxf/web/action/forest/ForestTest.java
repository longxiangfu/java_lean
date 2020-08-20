package com.lxf.web.action.forest;

import com.lxf.interfaces.MyClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;

/**
 * 测试http客户端工具forest
 */
@RestController
@RequestMapping("/forest")
public class ForestTest {

    @Resource
    private MyClient myClient;


    @GetMapping("/getBaiDu")
    public void getBaiDu(){
        String s = myClient.simpleRequest();
        System.out.println(s);
    }

    @GetMapping("/location")
    public void getLocation(){
        Map location = myClient.getLocation("124.730329", "31.463683");
        Set set = location.entrySet();
        for (Object o : set) {
            System.out.println(o.toString());
        }
    }
}
