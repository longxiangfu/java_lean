package com.lxf.jdk.foundation.generic.application;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 对实体类集合，按照某字段进行排序
 */
@Slf4j
public class GenericUtils {

    public static class Movie{
        private String name;
        private Date time;

        public Movie(String name, Date time){
            this.name = name;
            this.time = time;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getTime() {
            return time;
        }

        public void setTime(Date time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Movie{" +
                    "name='" + name + '\'' +
                    ", time=" + time +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Movie> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new Movie("Movie"+i, new Date()));
        }
        System.out.println("原始顺序：" + list.toString());
        GenericUtils.sortAnyModleList(list, "name", true);
        System.out.println("正序：" + list.toString());
        GenericUtils.sortAnyModleList(list, "name", false);
        System.out.println("倒序：" + list.toString());


    }

    private static <T> void sortAnyModleList(List<T> modelList, String fieldName, Boolean sortModel){
        //获取属性的get方法
        String getMethodName = new StringBuilder("get")
                .append(fieldName.substring(0,1).toUpperCase())
                .append(fieldName.substring(1))
                .toString();
        Collections.sort(modelList, ((o1, o2) -> {
            int sortResult = 0;
            try {
                //根据方法名获取Method
                Method method1 = o1.getClass().getMethod(getMethodName, null);
                Method method2 = o2.getClass().getMethod(getMethodName, null);
                //反射调用方法，返回字段值
                //排序
                if (sortModel) {
                    //正序
                    return method1.invoke(o1, null).toString().compareTo(method2.invoke(o2, null).toString());
                }else {
                    //倒序
                    return method1.invoke(o2, null).toString().compareTo(method2.invoke(o1, null).toString());
                }
            } catch (NoSuchMethodException e) {
                //此处直接抛业务异常
            } catch (IllegalAccessException e) {
                //此处直接抛业务异常
            } catch (InvocationTargetException e) {
                //此处直接抛业务异常
            }
            return sortResult;
        }));

    }
}
