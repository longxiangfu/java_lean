package com.lxf.jdk.foundation.io;

import java.io.IOException;
import java.nio.file.*;

/**
 * jdk7加入的Files，简单操作写入读出
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        //写入
        Files.write(Paths.get("C:\\Users\\Administrator\\Desktop\\1.txt"), "追加内容".getBytes(), StandardOpenOption.APPEND);
        //读出
        byte[] bytes = Files.readAllBytes(Paths.get("C:\\Users\\Administrator\\Desktop\\1.txt"));
        System.out.println(new String(bytes, "utf-8"));
    }
}
