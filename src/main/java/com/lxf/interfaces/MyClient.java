package com.lxf.interfaces;

import com.dtflys.forest.annotation.DataParam;
import com.dtflys.forest.annotation.Request;

import java.util.Map;

/**
 * forest调用第三方http或https接口
 */
public interface MyClient {

    @Request(url = "http://baidu.com")
    String simpleRequest();


    @Request(
            url = "http://ditu.amap.com/service/regeo",
            dataType = "json"
    )
    Map getLocation(@DataParam("longitude") String longitude,
                    @DataParam("latitude") String  latitude);

}
