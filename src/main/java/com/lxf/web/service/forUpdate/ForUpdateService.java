package com.lxf.web.service.forUpdate;

import com.lxf.web.dao.TestForupdateMapper;
import com.lxf.web.model.TestForupdate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class ForUpdateService {

    @Resource
    TestForupdateMapper mapper;

    public void test() {
        //查询
        TestForupdate model = mapper.selectByIdForUpdate(1L);
        System.out.println("开始");
        if (model == null) {
            throw new RuntimeException("结果不能为空");

        }

        //做业务
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //修改状态
        if (model.getStatus() == false) {
            TestForupdate record = new TestForupdate();
            record.setId(1L);
            record.setStatus(true);
            mapper.updateByPrimaryKeySelective(record);
        }
    }

    public void test1() throws Exception {
        TestForupdate result = mapper.selectByPrimaryKey(1L);
        if (result == null) {
            System.out.println("未查询到结果");
            throw new Exception("结果为null");
        }
        System.out.println("查询到结果");
    }

    public void test2() {
        TestForupdate record = new TestForupdate();
        record.setId(1L);
        record.setStatus(false);
        int count = mapper.updateByPrimaryKey(record);
        if (count == 1) {
            System.out.println("修改成功");
            return;
        }
        System.out.println("修改失败");
    }
}
