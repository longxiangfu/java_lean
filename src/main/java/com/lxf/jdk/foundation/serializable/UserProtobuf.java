//package com.lxf.jdk8.foundation.serializable;
//
//import com.baidu.bjf.remoting.protobuf.FieldType;
//import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
//
//import java.io.Serializable;
//
///**
// * protobuf实体
// */
//public class UserProtobuf implements Serializable {
//    private static final long serialVersionUID = 5513116649979631828L;
//    @Protobuf(fieldType = FieldType.STRING, required = true, order = 1)
//    private String name;
//    @Protobuf(fieldType = FieldType.INT32, required = true, order = 2)
//    private int age;
//    @Override
//    public String toString() {
//        return "{name:" + name + ",age:" + age + "}";
//    }
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public int getAge() {
//        return age;
//    }
//    public void setAge(int age) {
//        this.age = age;
//    }
//}
