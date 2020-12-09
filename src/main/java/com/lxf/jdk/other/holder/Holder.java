package com.lxf.jdk.other.holder;

/**
 * Holder帮助类的作用：
 * 1、将不可变对象的值传递，变为引用传递。参见测试类。
 * 应用:dubbo中类ExtensionLoader#getExtension中的Holder持有name
 * 2、Holder类中可以持有多个对象，方便外部类对这多个对象进行统一操作。
 * 例如：在销毁一个Activity类之前，想要保存TextView和SlidingDrawer类型的两个数据，
 * 在重启这个Activity后，再去获取这两个类型的数据
 * 例如：web返回
 * @param <T>
 */
public final class Holder<T> {

    private volatile T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }


}
