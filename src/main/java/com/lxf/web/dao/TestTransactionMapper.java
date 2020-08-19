package com.lxf.web.dao;

import com.lxf.web.model.TestTransaction;
import com.lxf.web.model.TestTransactionExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestTransactionMapper {
    long countByExample(TestTransactionExample example);

    int deleteByExample(TestTransactionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TestTransaction record);

    int insertSelective(TestTransaction record);

    List<TestTransaction> selectByExample(TestTransactionExample example);

    TestTransaction selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TestTransaction record, @Param("example") TestTransactionExample example);

    int updateByExample(@Param("record") TestTransaction record, @Param("example") TestTransactionExample example);

    int updateByPrimaryKeySelective(TestTransaction record);

    int updateByPrimaryKey(TestTransaction record);
}