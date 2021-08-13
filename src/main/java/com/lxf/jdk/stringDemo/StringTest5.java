package com.lxf.jdk.stringDemo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * 字符串转换编码解码
 */
public class StringTest5 {

    public static void main(String[] args) {
        String str = "我是中国人";
        try {
            String str1 = new String(str.getBytes(StandardCharsets.UTF_8), "US-ASCII");
            System.out.println("str1:" + str1); // ���������������

            String str2 = URLEncoder.encode(str, "UTF-8");
            System.out.println("str2:" + str2); // str2:%E6%88%91%E6%98%AF%E4%B8%AD%E5%9B%BD%E4%BA%BA
            String str22 = URLDecoder.decode(str2, "UTF-8");
            System.out.println("str22:" + str22); // str22:我是中国人
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
