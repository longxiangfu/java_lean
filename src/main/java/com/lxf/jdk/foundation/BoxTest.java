package com.lxf.jdk.foundation;

/**
 * 基本数据类型和包装类
 */
public class BoxTest {
    public static void main(String[] args) {
//        //查看包装类的取值范围
//        System.out.println(String.format("Byte取值范围：%d ~ %d", Byte.MIN_VALUE, Byte.MAX_VALUE));//-128 ~ 127
//        System.out.println(String.format("Character取值范围：%s ~ %s", Character.MIN_VALUE, Character.MAX_VALUE));//'\u0000'(空) ~ '\uFFFF'
//        System.out.println(String.format("Integer取值范围：%d ~ %d", Integer.MIN_VALUE, Integer.MAX_VALUE));//-2^31 ~ 2^31 -1

//        //Boolean
//        Boolean booleanA = true;
//        Boolean booleanB = true;
//        System.out.println("booleanA == booleanB:" + (booleanA == booleanB));//true
//        System.out.println("booleanA.equals(booleanB):" + (booleanA.equals(booleanB)));//true

//        //在高频区内，复用已有对象，区外，创建新的对象
//        Integer num1 = 127;
//        Integer num2 = 127;
//        System.out.println("127:" + (num1 == num2));//true
//        Integer num3 = 128;
//        Integer num4 = 128;
//        System.out.println("128:" + (num3 == num4));//false

//        //Integer和int比较，Integer会自动拆箱为int,相当于两个int比较
//        int i = 100;
//        Integer j = new Integer(100);
//        System.out.println(i == j);//true
//        System.out.println(j.equals(i));//true

//        //i-1后，值类型升级为int,然后从集合中找不到int类型的数，所以长度不变
//        Set<Short> set = new HashSet<>();
//        for (short i = 0; i < 5; i++) {
//            set.add(i);
//            set.remove(i-1);
//        }
//        System.out.println(set.size());

//        //short-1,值类型升级成int
//        short shortNum = 10;
//        int i = shortNum - 1;

//        //
//        short s = 2;
//        s = s + 1;//s+1导致s升级为int
//        s +=1;//s+=还是原来的short

//        //
//        float f = 3.4;//3.4默认是double,修改为3.4f或3.4F

//        //(1)new创建了一个新对象(2)Integer.valueOf会使用缓存池中对象(3)直接会使用缓存池中对象
//        Integer i1 = new Integer(10);
//        Integer i2 = new Integer(10);
//        Integer i3 = Integer.valueOf(10);
//        Integer i4 = Integer.valueOf(10);
//        Integer i5 = 10;
//        Integer i6 = 10;
//        System.out.println(i1 == i2);//false
//        System.out.println(i2 == i3);//false
//        System.out.println(i3 == i4);//true
//        System.out.println(i4 == i5);//true
//        System.out.println(i5 == i6);//true

//        //有些浮点数不能完全表示出来，例如0.3
//        System.out.println(3*0.1 == 0.3);//false
//        System.out.println(3*0.1);//0.30000000000000004

        //
        Integer a = 10;
        a.max(1, 3);//返回两数中较大的



    }



}
