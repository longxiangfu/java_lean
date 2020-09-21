package com.lxf.jdk.stringDemo;

public class StringTest {
    public static void main(String[] args) {
        /*
        String.formart()示例
         */
//        String str=null;
//        str=String.format("Hi,%s", "王力");
//        System.out.println(str);
//        str=String.format("Hi,%s:%s.%s", "王南","王力","王张");
//        System.out.println(str);
//        System.out.printf("字母a的大写是：%c %n", 'A');
//        System.out.printf("3>7的结果是：%b %n", 3>7);
//        System.out.printf("100的一半是：%d %n", 100/2);
//        System.out.printf("100的16进制数是：%x %n", 100);
//        System.out.printf("100的8进制数是：%o %n", 100);
//        System.out.printf("50元的书打8.5折扣是：%f 元%n", 50*0.85);
//        System.out.printf("上面价格的16进制数是：%a %n", 50*0.85);
//        System.out.printf("上面价格的指数表示：%e %n", 50*0.85);
//        System.out.printf("上面价格的指数和浮点数结果的长度较短的是：%g %n", 50*0.85);
//        System.out.printf("上面的折扣是%d%% %n", 85);
//        System.out.printf("字母A的散列码是：%h %n", 'A');

        /*
        String两种创建方式
        1、char[]  hash               byte[]   coder   hash
        2、String对象不可变性：安全；hash不频繁变更，使得类似HashMap实现key-value的缓存功能；实现字符串常量池
         */
//        String str1 = "abc";
//        String str2 = new String("abc");
//        String str3 = str2.intern();
//        System.out.println(str1 == str2);//false
//        System.out.println(str2 == str3);//false
//        System.out.println(str1 == str3);//true


        String str = "ab" + "cd" + "ef";//编译器自动优化为String str = "abcdef"
        String str1 = "abcdef";//字符串常量在编译时就会在常量池中创建对象
        System.out.println(str == str1);//true
        for (int i = 0; i < 100; i++) {
            str1 = str1 + 1;//经验证，+这种情况下编译器没有优化     //字符串变量在运行时才会创建,而字面量在编译时就在常量池中生成了对象
        }


        /*
        1、String str1 = "abcdef"：若常量池中没有该对象，则在常量池中创建对象，并返回该对象的引用；若有，则直接返回引用
        2、intern():若常量池中没有该对象，则在常量池中创建对象，并返回该对象的引用；若有，则直接返回引用
        2、new String("abc")：先在常量池中创建对象，然后在堆中创建对象（引用常量池中char[]），并返回堆中对象的引用
        3、String a = new String("abc").intern()：先在常量池中创建对象，然后在堆中创建对象（引用常量池中char[]），
            并返回常量池中对象的引用
         */
//        //验证3
//        String abc = "abc";//常量池中对象引用
//        String abcNew = new String(abc);//堆中对象引用
//        System.out.println(abc == abcNew);//flase
//        System.out.println(abc.equals(abcNew));//true
//        //验证4
//        String abcd = "abcd";//常量池中对象引用
//        String intern = new String(abcd).intern();//常量池中对象引用
//        System.out.println(abcd == intern);//true
//        System.out.println(abcd.equals(intern));//true


    }



}
