package com.lxf.jdk.foundation.abstractAndInterfaceTest.mianShi2;

/**
 * 方法重写
 */
public class B extends A {
    @Override
    public void m(A a) {
        System.out.println("BA");
    }
    public void m(B b) {
        System.out.println("BD");
    }

    public static void main(String[] args) {
        A a = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        a.m(a);//BA  A.m(A a) -> 发现子类B重写 -> B.m(A a)
        a.m(b);//BA  A.m(B b) -> A没有该方法 -> B继承A（向上强制转型） -> A.m(A a) -> 发现子类B被重写 ->B.m(A a)
        a.m(c);//BA  A.m(C c) -> A没有该方法 -> C继承B -> A没有该方法m(B b) -> B继承A -> A.m(A a) -> 发现子类B被重写 ->B.m(A a)
        a.m(d);//AD  A.m(D d) -> 子类B未重写
    }
}
