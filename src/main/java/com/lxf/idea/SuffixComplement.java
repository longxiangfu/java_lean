package com.lxf.idea;

import java.util.Arrays;
import java.util.List;

/**
 * @Description 后缀补全
 * 在一个表达式后按下点号 . ，然后输入一些提示或者在列表中选择一个候选项
 * @Author Administrator
 * @DATE 2019/3/22 9:05
 * @Version 1.0
 **/
public class SuffixComplement {
    public static void main(String[] args) {
        //var 声明
        String name = "jack";
        int age = 20;
        Client client = new Client();

        //for 遍历
        List<String> list = Arrays.asList("a", "b", "c");
        for (String str : list) {

        }

        //not 取反
        boolean isSuccess = true;
        isSuccess = !isSuccess;

        //if 条件判断
        if (args.length > 0) {

        }

        //cast 强转
        Object name1 = "jack";
        String realName = ((String) name1);


    }

    public String postix(Object user){
        //null 判空
        if (user == null) {

        }

        //nn 判非空
        if (user != null) {

        }

        //return 返回值
        return "abc";
    }
}
