package com.lxf.redis.redisTemplate;

import com.lxf.utils.RedisTemplate.RedisTemplateUtil;
import com.lxf.utils.SpringContextUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.Set;

@Service
public class Test {

    public static void main(String[] args) {
        Test test = new Test();
//        set("lxf", "123456");
        test.keys("lxf*");

    }

    private void set(String key, String value) {
        RedisTemplateUtil redisTemplateUtil = SpringContextUtil.getBean(RedisTemplateUtil.class);
        redisTemplateUtil.set(key, value);
    }


    //模糊查询keys
    private Set<String> keys(String keys) {
        RedisTemplateUtil redisTemplateUtil = SpringContextUtil.getBean(RedisTemplateUtil.class);
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
