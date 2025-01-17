package com.lxf.jdk.foundation.file.read.bio;

import java.io.*;

/**
 * 字符流  Writer  Reader
 * 同步阻塞
 * 磁盘io
 */
public class ZiFuSteam {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\feilong\\Desktop\\1.txt");
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("创建成功");
        }

        //写出
        Writer writer = new FileWriter(file, true);
        writer.write("老王1");
        writer.flush();
        writer.close();
        //读入
        Reader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String content = null;
        while (null != (content = bufferedReader.readLine())){
            System.out.println(content);
        }
        bufferedReader.close();
        reader.close();
    }
}
