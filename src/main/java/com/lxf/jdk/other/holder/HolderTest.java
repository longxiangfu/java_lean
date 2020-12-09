package com.lxf.jdk.other.holder;

/**
 * 有Holder时
 */
public class HolderTest {

    public static void main(String[] args) {
        String name = "aaaa";
        Holder<String> holder = new Holder();
        holder.set(name);
        changeName(holder);
        System.out.println(holder.get());
    }

    private static void changeName(Holder<String> holder) {//引用传递
        holder.set("bbbb");
        System.out.println(holder.get());
    }


//    bbbb
//    bbbb
}
