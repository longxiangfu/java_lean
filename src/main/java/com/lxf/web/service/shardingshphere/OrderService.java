//package com.lxf.web.service.shardingshphere;
//
//import com.lxf.web.dao.OrderMapper;
//import com.lxf.web.model.Order;
//import com.lxf.web.model.OrderExample;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//
//@Service
//public class OrderService {
//
//    @Resource
//    OrderMapper mapper;
//
//    public void insert() {
//        List<Order> orderList = new ArrayList<>();
//        orderList.add(Order.builder().orderSn("111111").memberId("100").createTime(new Date()).status(1).build());
//        orderList.add(Order.builder().orderSn("222222").memberId("101").createTime(new Date()).status(1).build());
//        orderList.add(Order.builder().orderSn("333333").memberId("102").createTime(new Date()).status(1).build());
//        orderList.add(Order.builder().orderSn("444444").memberId("103").createTime(new Date()).status(1).build());
//        for (Order order : orderList) {
//            mapper.insert(order);
//        }
//
//    }
//
//    public void select() {
//        OrderExample example = new OrderExample();
//        OrderExample.Criteria criteria = example.createCriteria();
//        criteria.andMemberIdEqualTo("100");
////        criteria.andMemberIdEqualTo("101");
////        criteria.andMemberIdEqualTo("102");
////        criteria.andMemberIdEqualTo("103");
//        List<Order> orders = mapper.selectByExample(example);
//        System.out.println(Arrays.toString(orders.toArray()));
//    }
//}
