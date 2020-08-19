//package com.lxf.web.service.transaction;
//
//import com.lxf.web.dao.TestTransactionMapper;
//import com.lxf.web.model.TestTransaction;
//import com.lxf.web.model.TestTransactionExample;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.Resource;
//import java.sql.SQLException;
//import java.util.Random;
//
//@Slf4j
//@Service
//public class TransactionService {
//
//    @Resource
//    TestTransactionMapper mapper;
//
//
//    public void deleteAllAndAddOne() throws SQLException {
//      log.info("go into deleteAllAndAddOne()");
//      deleteAllAndAddOneTransactional();
//    }
//
//    @Transactional
//    public void deleteAllAndAddOneTransactional() throws SQLException {
//        System.out.println("go into deleteAllAndAddOneTransactional() " + Thread.currentThread().getName());
//        Random random = new Random(1000);
////        mapper.deleteByPrimaryKey(7L);
//        String flag = "long";
////        if (!"chen".equalsIgnoreCase(flag)) {
////            throw new RuntimeException();
////            throw new OutOfMemoryError();
////            throw new SQLException();
////        }
//        TestTransaction model = new TestTransaction();
//        model.setName("我是事务五");
//        mapper.insert(model);
//    }
//
//    public void selectAll() {
//        TestTransactionExample example = new TestTransactionExample();
//        TestTransactionExample.Criteria criteria = example.createCriteria();
//        criteria.andNameNotEqualTo("hehehe");
//        mapper.selectByExample(example);
//    }
//}
