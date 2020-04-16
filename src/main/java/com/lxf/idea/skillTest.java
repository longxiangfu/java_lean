package com.lxf.idea;

import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author Administrator
 * @DATE 2019/3/25 20:57
 * @Version 1.0
 **/
public class skillTest {
    public static void main(String[] args) {
        testList();//4.模拟异常  在'Frames'中该方法上右键，选择Throw Exception
    }

    private static void testList(){
        Client client = new Client();
        client.setAge("20");
        byte[] cByte = client.toString().getBytes();//3."下面计算机图标":new String(cByte),可以查看byte[]原始数据

        int count = 1;
        if(count == 1){//3."下面计算机图标":给变量赋值，可改变代码的分支走向
            System.out.println(count);
        }

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        for (Integer integer : list) {
            System.out.println(integer);//1.设置条件断断点  2.强制返回值 在'Frames'中该方法上右键，选择Force Return,可以跳出debug,方便我们调试源码中的多种分支流程
        }
    }
}
