package com.lxf.jdk8.foundation.io.AIO;

import lombok.SneakyThrows;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 重写一遍
 */
public class AIOTest1 {
    public static void main(String[] args) {
        int port = 9090;
        //socket服务端
        new Thread(() -> {
            AsynchronousChannelGroup group = null;
            try{
                group = AsynchronousChannelGroup.withThreadPool(Executors.newWorkStealingPool());
                AsynchronousServerSocketChannel channel = AsynchronousServerSocketChannel.open(group)
                        .bind(new InetSocketAddress(InetAddress.getLocalHost(), port));
                channel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
                    @SneakyThrows
                    @Override
                    public void completed(AsynchronousSocketChannel result, Object attachment) {
                        channel.accept(null, this);
                        Future<Integer> future = result.write(Charset.defaultCharset().encode("hi,老王先生！"));
                        future.get();
                        System.out.println("发送时间：" + DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS").format(LocalDateTime.now()));
                        result.close();
                    }

                    @Override
                    public void failed(Throwable exc, Object attachment) {

                    }
                });
                group.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        //socket客户端
        new Thread(() -> {
            try {
                AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
                client.connect(new InetSocketAddress(InetAddress.getLocalHost(), port));
                ByteBuffer byteBuffer = ByteBuffer.allocate(1000);
                client.read(byteBuffer, null, new CompletionHandler<Integer, Object>() {
                    @SneakyThrows
                    @Override
                    public void completed(Integer result, Object attachment) {
                        System.out.println("收到信息：" + new String(byteBuffer.array(), "utf-8"));
                    }

                    @Override
                    public void failed(Throwable exc, Object attachment) {
                        exc.printStackTrace();
                        try {
                            client.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();
    }
}
