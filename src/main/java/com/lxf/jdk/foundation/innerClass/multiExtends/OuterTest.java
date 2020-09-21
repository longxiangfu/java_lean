package com.lxf.jdk.foundation.innerClass.multiExtends;

public class OuterTest {
    private String name;
    public void dance(){
        System.out.println("OuterTest dance()");
    }

    class InnerTest implements InnerInterface{
        @Override
        public void dance() {
            System.out.println("InnerTest dance()");
            System.out.println(OuterTest.this.name);
        }
    }

    class InnerTest1 extends InnerAbstract{
        @Override
        void dance() {
            System.out.println("InnerTest1 dance()");
            OuterTest.this.dance();
        }
    }

    //内部类既拥有继承类或接口的属性和方法，也拥有了外部类的属性和方法，是一种都继承的实现
    public void test(){
        InnerTest innerTest = new InnerTest();
        innerTest.dance();
        InnerTest1 innerTest1 = new InnerTest1();
        innerTest1.dance();
    }


    public static void main(String[] args) {
        OuterTest outerTest = new OuterTest();
        outerTest.test();
    }
}
