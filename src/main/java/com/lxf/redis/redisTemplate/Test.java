package com.lxf.redis.redisTemplate;

import com.lxf.utils.RedisTemplate.RedisTemplateUtil;
import com.lxf.utils.SpringContextUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Iterator;
import java.util.Set;

@Controller
@RequestMapping("/redis")
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
    @GetMapping("/keys")
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
