package com.lxf.jdk.stringDemo;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * 字符串转换编码
 */
public class StringTest5 {

    public static void main(String[] args) {
        String str = "我是中国人";
        try {
            String str1 = new String(str.getBytes(StandardCharsets.UTF_8), "US-ASCII");
            System.out.println(str1); // ���������������
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
