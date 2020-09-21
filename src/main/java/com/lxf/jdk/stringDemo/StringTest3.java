package com.lxf.jdk.stringDemo;

import org.springframework.util.StringUtils;

public class StringTest3 {
    public static void main(String[] args) {
        mutiString("aaa", "ccc");
    }


    private static void mutiString(String ... messages){
        StringBuilder stringBuilder = new StringBuilder();
        for (String message : messages) {
            if (!StringUtils.isEmpty(stringBuilder.toString())) {
                stringBuilder.append("|");
            }
            stringBuilder.append(message);
        }
        System.out.println(stringBuilder.toString());
    }
}
