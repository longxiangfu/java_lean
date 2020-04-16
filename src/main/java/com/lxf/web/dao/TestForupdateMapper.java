package com.lxf.web.dao;

import com.lxf.web.model.TestForupdate;
import com.lxf.web.model.TestForupdateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestForupdateMapper {
    long countByExample(TestForupdateExample example);

    int deleteByExample(TestForupdateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TestForupdate record);

    int insertSelective(TestForupdate record);

    List<TestForupdate> selectByExample(TestForupdateExample example);

    TestForupdate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TestForupdate record, @Param("example") TestForupdateExample example);

    int updateByExample(@Param("record") TestForupdate record, @Param("example") TestForupdateExample example);

    int updateByPrimaryKeySelective(TestForupdate record);

    int updateByPrimaryKey(TestForupdate record);

    TestForupdate selectByIdForUpdate(Long id);
}