package com.lxf.redis.redisTemplate;

import com.lxf.utils.RedisTemplate.RedisTemplateUtil;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.Set;

public class Test {

    @Resource
    static RedisTemplateUtil redisTemplateUtil;


    public static void main(String[] args) {
        keys("lxf*");

    }


    //模糊查询keys
    private static Set<String> keys(String keys) {
        Set<String> set = redisTemplateUtil.keys("lxf*");
        if (!CollectionUtils.isEmpty(set)) {
            Iterator<String> iterator = set.iterator();
            if (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
        return set;
    }


}
