//package com.lxf.jdk8.foundation.serializable;
//
//import com.alibaba.fastjson.JSON;
//import com.baidu.bjf.remoting.protobuf.Codec;
//import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
//import com.caucho.hessian.io.HessianInput;
//import com.caucho.hessian.io.HessianOutput;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//
///**
// * 其他序列化和反序列化
// */
//public class OtherSerializable {
//    public static void main(String[] args) throws IOException {
//        User user = new User();
//        user.setAge(10);
//        user.setName("longxiangfu");
//
//        //Jackson序列化与反序列化
////        jacksonTest(user);
//
//        //FastJson序列化和反序列化
//        fastJsonTest(user);
//
//        //hessian序列化
//        hessianTest(user);
//
//        //protobuf序列化
//        UserProtobuf userProtobuf = new UserProtobuf();
//        userProtobuf.setAge(20);
//        userProtobuf.setName("chenting");
//        protobufTest(userProtobuf);
//
//    }
//
//
//    private static void protobufTest(UserProtobuf user) throws IOException {
//        Codec<UserProtobuf> userCodec = ProtobufProxy.create(UserProtobuf.class, false);
//        long serializableStart = System.currentTimeMillis();
//        System.out.println("原对象：" + user);
//        //序列化
//        byte[] bytes = userCodec.encode(user);
//        long serializableEnd = System.currentTimeMillis();
//        System.out.println("序列化时间：" + (serializableEnd - serializableStart));//31ms
//        System.out.println("序列化后大小：" + bytes.length);//12
//        //反序列化
//        long fanSerializableStart = System.currentTimeMillis();
//        UserProtobuf user2 = userCodec.decode(bytes);
//        long fanSerializableEnd = System.currentTimeMillis();
//        System.out.println("反序列化时间：" + (fanSerializableEnd - fanSerializableStart));//0ms
//        System.out.println("反序列化后对象：" + user2);
//    }
//
//
//    private static void hessianTest(User user) throws IOException {
//        long serializableStart = System.currentTimeMillis();
//        System.out.println("原对象：" + user);
//        //序列化
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        HessianOutput hessianOutput = new HessianOutput(byteArrayOutputStream);
//        hessianOutput.writeObject(user);
//        long serializableEnd = System.currentTimeMillis();
//        System.out.println("序列化时间：" + (serializableEnd - serializableStart));//125ms
//        System.out.println("序列化后大小：" + byteArrayOutputStream.toByteArray().length);//81
//        //反序列化
//        long fanSerializableStart = System.currentTimeMillis();
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
//        HessianInput hessianInput = new HessianInput(byteArrayInputStream);
//        User user2 = (User)hessianInput.readObject();
//        long fanSerializableEnd = System.currentTimeMillis();
//        System.out.println("反序列化时间：" + (fanSerializableEnd - fanSerializableStart));//0ms
//        System.out.println("反序列化后对象：" + user2);
//    }
//
//
//    private static void fastJsonTest(User user) {
//        long serializableStart = System.currentTimeMillis();
//        System.out.println("原对象：" + user);
//        //序列化
//        byte[] bytes = JSON.toJSONBytes(user);
//        long serializableEnd = System.currentTimeMillis();
//        System.out.println("序列化时间：" + (serializableEnd - serializableStart));//375ms
//        System.out.println("序列化后大小：" + bytes.length);//31
//        //反序列化
//        long fanSerializableStart = System.currentTimeMillis();
//        User user2 = JSON.parseObject(bytes, User.class);
//        long fanSerializableEnd = System.currentTimeMillis();
//        System.out.println("反序列化时间：" + (fanSerializableEnd - fanSerializableStart));//31ms
//        System.out.println("反序列化后对象：" + user2);
//
//
//    }
//
//
//    private static void jacksonTest(User user) throws IOException {
//        long serializableStart = System.currentTimeMillis();
//        System.out.println("原对象：" + user);
//        ObjectMapper mapper = new ObjectMapper();
//        byte[] bytes = mapper.writeValueAsBytes(user);
//        long serializableEnd = System.currentTimeMillis();
//        System.out.println("序列化时间：" + (serializableEnd - serializableStart));//738ms
//        System.out.println("序列化后大小：" + bytes.length);//31
//        //Json反序列化
//        long fanSerializableStart = System.currentTimeMillis();
//        User user2 = mapper.readValue(bytes, User.class);
//        long fanSerializableEnd = System.currentTimeMillis();
//        System.out.println("反序列化时间：" + (fanSerializableEnd - fanSerializableStart));//81ms
//        System.out.println("反序列化后对象：" + user2);
//    }
//
//
//
//}
