//package com.lxf.web.action.starter;
//
//import com.tp.SpilitService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Arrays;
//
//
///**
// * 测试子定义的starter
// */
//@RestController
//@RequestMapping("/starter")
//public class SpilitController {
//
//    @Autowired
//    public SpilitService service;
//
//    @PostMapping("/spilit")
//    public void doSpilit(){
//        String[] strings = service.spilit(",");
//        System.out.println(Arrays.toString(strings));
//    }
//}
