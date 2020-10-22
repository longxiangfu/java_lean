package com.lxf.jdk.foundation.file.read.bufferReader;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.*;

/**
 * 测试BufferedReader读取超大文件
 */
@Slf4j
public class BufferedReadTest {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
//        //文件写入
//        String writeFile = "D:\\test.txt";
//        BufferedWriter bufferedWriter =
//                new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(writeFile)), "utf-8"), 10*1024*1024);
//        while (true){
//            try {
//                bufferedWriter.write("我是中国人");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }


        String readFile = "D:\\test.txt"; //大约1GB
        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(new FileInputStream(new File(readFile)), "utf-8"), 10*1024*1024);
            long startTime = System.currentTimeMillis();
            while (!StringUtils.isEmpty(bufferedReader.readLine())){

            }
            log.info("use time:" + (System.currentTimeMillis() - startTime));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        use time:6480ms

    }

}
