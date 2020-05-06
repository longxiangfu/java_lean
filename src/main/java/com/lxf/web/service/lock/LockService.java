package com.lxf.web.service.lock;

import com.lxf.web.model.TestLock;

public class LockService extends BaseService<TestLock> {

    public void add(){
        TestLock testLock = new TestLock();
        testLock.setName("我是新插入的");
        LockService.super.insertSelective(testLock);
    }
}
