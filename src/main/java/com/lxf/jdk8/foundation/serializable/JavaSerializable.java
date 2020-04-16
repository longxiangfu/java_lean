package com.lxf.jdk8.foundation.serializable;

import java.io.*;

/**
 * java原生序列化和反序列化
 */
public class JavaSerializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User();
        user.setAge(10);
        user.setName("longxiangfu");

        //序列化
        long serializableStart = System.currentTimeMillis();
        System.out.println("原对象：" + user);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);
        outputStream.writeObject(user);
        outputStream.flush();
        long serializableEnd = System.currentTimeMillis();
        System.out.println("序列化时间：" + (serializableEnd - serializableStart));//31ms
        System.out.println("序列化后大小：" + byteArrayOutputStream.toByteArray().length);//117
        outputStream.close();
        //反序列化
        long fanSerializableStart = System.currentTimeMillis();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream inputStream = new ObjectInputStream(byteArrayInputStream);
        User user2 = (User)inputStream.readObject();
        inputStream.close();
        long fanSerializableEnd = System.currentTimeMillis();
        System.out.println("反序列化时间：" + (fanSerializableEnd - fanSerializableStart));//123ms
        System.out.println("反序列化后对象：" + user2);
    }
}
