package com.lxf.jdk.foundation.file.read.bio;

import java.io.*;

/**
 * 字节流  OutputStream  InputStream
 * 同步阻塞
 * 磁盘io
 */
public class ZiJieStream {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\feilong\\Desktop\\1.txt");
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("创建成功");
        }

        //写出
        OutputStream outputStream = new FileOutputStream(file, true);
        outputStream.write("张三".getBytes());
        outputStream.flush();
        outputStream.close();

        //读入
        InputStream inputStream = new FileInputStream(file);
        byte[] byteContent = new byte[inputStream.available()];//inputStream.available()返回能被读取的字节数组的容量
        int i;
        //读取到字节数组中
        while (-1 != (i = inputStream.read(byteContent))){
            //内容转换为字符串
            String content = new String(byteContent, "utf-8");
            System.out.println(content);
        }
        inputStream.close();
    }
}
