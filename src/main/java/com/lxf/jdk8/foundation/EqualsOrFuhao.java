package com.lxf.jdk8.foundation;

/**
 * 描述
 * 1、==：若是基本类型，判断的是值相等；若是引用类型，判断的是对应是否相等
 * 2、equals:默认判断的是对象相等，但是String和Integer(Long)重写了equals方法，判断的是值相等
 */
public class EqualsOrFuhao {

    public static void main(String[] args) {
        //==：若是基本类型，判断的是值相等
        //==：若是引用类型，判断的是对应是否相等
        Cat cat = new Cat("花猫");
        Cat cat1 = new Cat("白猫");
        System.out.println(cat.equals(cat1));//false
        //equals:默认判断的是对象相等
        System.out.println(cat.equals(cat1));//false
        //equals:但是String和Integer重写了equals方法，判断的是值相等
        String str = new String("张三");
        String str1 = new String("张三");
        System.out.println(str.equals(str1));//true
        Integer integer= new Integer("1");
        Integer integer1= new Integer("1");
        System.out.println(integer.equals(integer1));//true

    }





    static class Cat{
        private String name;

        public Cat(String name){
            this.name = name;
        }

        public String getName(){
            return this.name;
        }

        public void setName(String name){
            this.name = name;
        }

    }



}
