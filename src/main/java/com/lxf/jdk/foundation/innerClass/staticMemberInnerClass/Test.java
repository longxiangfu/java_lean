package com.lxf.jdk.foundation.innerClass.staticMemberInnerClass;

public class Test {
    public static void main(String[] args) {
        Outer.Inner2 inner2 = new Outer.Inner2();
        inner2.sayHi();

        Outer.Inner2.hug();
    }
}
