package com.lxf.controllerAdvice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import org.bson.types.ObjectId;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Collection;
import java.util.Date;

@ControllerAdvice
public class MyResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    private static Class<?>[] responseType = { Collection.class, String.class, Integer.class, Date.class , Object.class};

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        if (!methodParameter.getContainingClass().getPackage().getName().startsWith("com.lxf")){
            return false;
        }
        for (int i = 0; i < responseType.length; i++) {
                if (responseType[i].isAssignableFrom(methodParameter.getMethod().getReturnType())
                        || methodParameter.getMethod().getReturnType().isArray()) {
                    return true;
                }
        }
        return false;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        SerializeConfig config = new SerializeConfig();
        config.put(ObjectId.class, new ObjectIdJsonSerializer());
        return (Object) JSONObject.parseObject(JSON.toJSONString(o, config));
//        return JSONObject.parseArray(JSON.toJSONString(o, config));
//        String a = JSON.toJSONString(o, config);
//        return new Gson().fromJson(a, o.getClass());
    }
}
