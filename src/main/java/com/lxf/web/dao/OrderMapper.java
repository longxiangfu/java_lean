//package com.lxf.web.dao;
//
//import com.lxf.web.model.Order;
//import com.lxf.web.model.OrderExample;
//import java.util.List;
//
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Param;
//import org.springframework.stereotype.Component;
//
//@Mapper
//@Component
//public interface OrderMapper {
//    long countByExample(OrderExample example);
//
//    int deleteByExample(OrderExample example);
//
//    int deleteByPrimaryKey(Long id);
//
//    int insert(Order record);
//
//    int insertSelective(Order record);
//
//    List<Order> selectByExample(OrderExample example);
//
//    Order selectByPrimaryKey(Long id);
//
//    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);
//
//    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);
//
//    int updateByPrimaryKeySelective(Order record);
//
//    int updateByPrimaryKey(Order record);
//}