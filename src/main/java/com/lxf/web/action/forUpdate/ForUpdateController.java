//package com.lxf.web.action.forUpdate;
//
//import com.lxf.web.service.forUpdate.ForUpdateService;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//
///**
// * mysql innnodb行锁
// */
//@RestController
//@RequestMapping("/test/forupdate")
//public class ForUpdateController {
//
//    @Resource
//    ForUpdateService service;
//
//    /**
//     * 测试for update
//     * 必须配合事务
//     * 一个事务A中，select ... for update先将该条数据加行级锁，在本事务中，可以修改该条数据；
//     * 另一个事务B走到select ... for update将会阻塞，直到事务A完成
//     * 注意：若字段值的重复率较高的话，mysql优化器可能将行级锁优化成表锁，所以select ... for update慎用，用乐观锁代替
//     */
//    @GetMapping
//    public void test(){
//        service.test();
//    }
//
//    /**
//     * 测试for update阻塞的同时，普通的select是否可用
//     * 结果：立刻“查询到结果”，说明for update阻塞的同时，普通的select是可用的
//     */
//    @GetMapping("/test1")
//    public void test1() throws Exception {
//        service.test1();
//    }
//
//
//    /**
//     * 测试for update阻塞的同时，是否可以修改该条数据
//     * 结果：大约5s之后才打印“修改成功”，说明for update阻塞的同时，不可以修改该条数据
//     */
//    @GetMapping("/test2")
//    public void test2(){
//        service.test2();
//    }
//
//
//}
