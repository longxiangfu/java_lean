package com.lxf.jdk.foundation.file.read.nioZeroCopy;

import java.nio.charset.StandardCharsets;

/**
 * 零拷贝
 * 示例只演示了读，未演示写
 * java支持操作系统零拷贝MappedByteBuffer
 */
public class TestBigFileRead {
    public static void main(String[] args) {
        String bigFilePath = "D:\\test.txt";
        BigFileReader.Builder builder = new BigFileReader.Builder(bigFilePath);
        BigFileReader bigFileReader = builder
                .threadPoolSize(10)
                .charset(StandardCharsets.UTF_8)
                .build();
        bigFileReader.start();

//        fileLenth:1069540290
//        everySize;106954029
//        分配分片：star=641724174;end=748678202
//        分配分片：star=0;end=106954028
//        分配分片：star=213908058;end=320862086
//        分配分片：star=106954029;end=213908057
//        分配分片：star=320862087;end=427816115
//        分配分片：star=534770145;end=641724173
//        分配分片：star=748678203;end=855632231
//        分配分片：star=855632232;end=962586260
//        分配分片：star=427816116;end=534770144
//        分配分片：star=962586261;end=1069540289
//        任务执行。start:641724174
//        任务执行。start:427816116
//        任务执行。start:855632232
//        任务执行。start:534770145
//        任务执行。start:748678203
//        任务执行。start:320862087
//        任务执行。start:962586261
//        任务执行。start:0
//        任务执行。start:213908058
//        任务执行。start:106954029
//        use time: 2764ms
    }

}
