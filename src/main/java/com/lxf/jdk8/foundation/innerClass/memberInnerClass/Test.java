package com.lxf.jdk8.foundation.innerClass.memberInnerClass;

public class Test {
    public static void main(String[] args) {
        //内部类创建
        Outer.Inner inner = new Outer().new Inner();
        inner.sayHi();
    }
}
