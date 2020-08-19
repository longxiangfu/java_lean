package com.lxf.web.action.shardingshphere;

import com.lxf.web.dao.OrderMapper;
import com.lxf.web.model.Order;
import com.lxf.web.model.OrderExample;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order/test")
public class OrderController {

    @Resource
    OrderMapper mapper;


    @GetMapping("/insert")
    public void insert(){
        List<Order> orderList = new ArrayList<>();
        orderList.add(Order.builder().orderSn("111111").memberId("100").createTime(new Date()).status(1).build());
        orderList.add(Order.builder().orderSn("222222").memberId("101").createTime(new Date()).status(1).build());
        orderList.add(Order.builder().orderSn("333333").memberId("102").createTime(new Date()).status(1).build());
        orderList.add(Order.builder().orderSn("444444").memberId("103").createTime(new Date()).status(1).build());
        for (Order order : orderList) {
            mapper.insert(order);
        }
    }


    @GetMapping("/select")
    public void select(){
        OrderExample example = new OrderExample();
        List<Order> orders = mapper.selectByExample(example);
        System.out.println(Arrays.toString(orders.toArray()));
    }

}
