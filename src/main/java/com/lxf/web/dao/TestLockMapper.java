package com.lxf.web.dao;

import com.lxf.web.model.TestLock;
import com.lxf.web.model.TestLockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestLockMapper {
    long countByExample(TestLockExample example);

    int deleteByExample(TestLockExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TestLock record);

    int insertSelective(TestLock record);

    List<TestLock> selectByExample(TestLockExample example);

    TestLock selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TestLock record, @Param("example") TestLockExample example);

    int updateByExample(@Param("record") TestLock record, @Param("example") TestLockExample example);

    int updateByPrimaryKeySelective(TestLock record);

    int updateByPrimaryKey(TestLock record);
}