package com.lxf.jdk.toolClass;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * commons-beanUtils类库
 */
public class CommonsBeanUtils {

    public static void main(String[] args) {
        // 对象转map
        User user = new User();
        user.setId(1);
        user.setName("longxiangfu");
        try {
            Map<String, String> map = BeanUtils.describe(user);
            System.out.println("对象转map:" + map); // 对象转map:{name=longxiangfu, id=1}

            // map转对象
            User newUser = new User();
            BeanUtils.populate(newUser, map);
            System.out.println("map转对象:" + newUser); // map转对象:User(id=1, name=longxiangfu)
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


        // 属性复制
//        BeanUtils.copyProperties();


    }
}
