package com.lxf.jdk.foundation.file.read.nioZeroCopy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigFileReader {
    private int threadPoolSize;//线程池大小
    private Charset charset;//编码
    private ExecutorService executorService;
    private long fileLength;//文件大小
    private RandomAccessFile rAccessFile;
    private Set<StartEndPair> startEndPairs;//开始位置和结束位置Set
    private CyclicBarrier cyclicBarrier;//栅栏

    public BigFileReader(File file, Charset charset, int threadPoolSize){
        this.fileLength = file.length();
        this.charset = charset;
        this.threadPoolSize = threadPoolSize;
        try {
            this.rAccessFile = new RandomAccessFile(file,"r");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.executorService = Executors.newFixedThreadPool(threadPoolSize);
        this.startEndPairs = new HashSet<>();
    }

    public void start(){
        System.out.println("fileLenth:" + fileLength);
        long everySize = this.fileLength/this.threadPoolSize;
        System.out.println("everySize;" + everySize);
        try {
            calculateStartEnd(0, everySize);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        final long startTime = System.currentTimeMillis();
        cyclicBarrier = new CyclicBarrier(startEndPairs.size(), () -> {//等待所有线程都完成任务之后，执行输出
            System.out.println("use time: "+(System.currentTimeMillis()-startTime));
            shutdown();
        });
        for(StartEndPair pair:startEndPairs){
            System.out.println("分配分片："+pair);
            this.executorService.execute(new SliceReaderTask(pair));//多线程执行读取任务，一个读取一个配对中间的内容
        }
    }

    /**
     * 按照找给定的开始位置和分片的大小，计算所有的开始位置和结束位置
     * @param start 开始位置
     * @param size 分片大小
     * @throws IOException
     */
    private void calculateStartEnd(long start,long size) throws IOException{
        if(start>fileLength-1){
            return;
        }
        StartEndPair pair = new StartEndPair();
        pair.start=start;
        long endPosition = start+size-1;
        if(endPosition>=fileLength-1){
            pair.end=fileLength-1;
            startEndPairs.add(pair);
            return;
        }

        pair.end=endPosition;
        startEndPairs.add(pair);

        calculateStartEnd(endPosition+1, size);

    }

    public void shutdown() {
        try {
            this.rAccessFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.executorService.shutdown();
    }


    /**
     * 片类
     */
    private static class StartEndPair {
        public long start;
        public long end;

        @Override
        public String toString() {
            return "star="+start+";end="+end;
        }
    }


    /**
     * 片读取任务类：读取每片的内容
     */
    private class SliceReaderTask implements Runnable {
        private long start;
        private long sliceSize;

        public SliceReaderTask(StartEndPair pair) {
            this.start = pair.start;
            this.sliceSize = pair.end - pair.start + 1;
        }


        @Override
        public void run() {
            System.out.println("任务执行。start:" + start);
            try {
                MappedByteBuffer mappedByteBuffer = rAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, start, this.sliceSize);
                CharBuffer charBuffer = null;
                if (mappedByteBuffer != null){
                    charBuffer = Charset.forName("UTF-8").decode(mappedByteBuffer);
//                    System.out.println(charBuffer.toString());
                }
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * BigFileReader的建造器
     */
    public static class Builder{
        private int threadSize=1;
        private Charset charset;
        private int bufferSize=1024*1024;
        private File file;
        public Builder(String file){
            this.file = new File(file);
            if(!this.file.exists())
                throw new IllegalArgumentException("文件不存在！");
        }

        public Builder threadPoolSize(int size){
            if (size <= 0) {
                throw new IllegalArgumentException("线程池参数必须为大于0的整数");
            }
            this.threadSize = size;
            return this;
        }

        public Builder charset(Charset charset){
            this.charset= charset;
            return this;
        }

        public Builder bufferSize(int bufferSize){
            this.bufferSize = bufferSize;
            return this;
        }

        public BigFileReader build(){
            return new BigFileReader(this.file, this.charset,this.threadSize);
        }
    }
}
