package com.lxf.jdk.toolClass;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * commons-io类库
 */
public class CommonsIO {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Administrator\\Desktop\\demo1.txt");

        // 读取
        List<String> fileStr = FileUtils.readLines(file, Charset.defaultCharset());

        // 写入
        FileUtils.writeLines(new File("C:\\Users\\Administrator\\Desktop\\demo2.txt"), fileStr);

        // 复制文件
        FileUtils.copyFile(file, new File("C:\\Users\\Administrator\\Desktop\\demo3.txt"));
    }
}
