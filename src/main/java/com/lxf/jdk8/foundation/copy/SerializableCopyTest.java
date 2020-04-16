package com.lxf.jdk8.foundation.copy;


import com.lxf.jdk8.Person;
import com.lxf.jdk8.WangWu;

import java.io.*;

/**
 * 深拷贝
 * 利用序列化和反序列化
 * 对象实现Serializable接口
 */
public class SerializableCopyTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //测试String类型属性是否拷贝  true
        //测试对象属性是否拷贝  true
        Person p = new Person();
        p.setName("陈婷");
        WangWu wangWu = new WangWu();
        wangWu.setSex(1);
        p.setWangWu(wangWu);

        Person pCopy = clone(p);
        pCopy.setName("龙相甫");
        pCopy.getWangWu().setSex(2);

        //origin name|wangwu.sex:陈婷|1。 new name|wangwu.sex:龙相甫|2  ---  1  2
        System.out.println("origin name|wangwu.sex:" + p.getName() + "|" + p.getWangWu().getSex()
                + "。 new name|wangwu.sex:" + pCopy.getName() + "|" + pCopy.getWangWu().getSex()) ;


    }


    /**
     * 深拷贝
     * @param obj
     * @param <T>
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static <T extends Serializable>T clone(T obj) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(obj);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream obis = new ObjectInputStream(bais);
        return (T) obis.readObject();
    }


}
