package com.lxf.jdk8.foundation.io.BIO;

import java.io.*;

/**
 * 字符流
 */
public class ZiFuSteam {
    public static void main(String[] args) throws IOException {
        //写出
        Writer writer = new FileWriter("C:\\Users\\Administrator\\Desktop\\1.txt", true);
        writer.write("老王1");
        writer.flush();
        writer.close();
        //读入
        Reader reader = new FileReader("C:\\Users\\Administrator\\Desktop\\1.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String content = null;
        while (null != (content = bufferedReader.readLine())){
            System.out.println(content);
        }
        bufferedReader.close();
        reader.close();
    }
}
