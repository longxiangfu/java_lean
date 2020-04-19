package com.lxf.xxl;


import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.stereotype.Component;

import static com.xxl.job.core.biz.model.ReturnT.SUCCESS;


@Component
public class XxlJobHandler{

    @XxlJob(value = "testJob")
    public ReturnT<String> execute(String s) throws Exception {
        XxlJobLogger.log("test-xxl-job任务开始");
        Thread.sleep(3000);
        XxlJobLogger.log("test-xxl-job任务结束");
        return SUCCESS;
    }
}
