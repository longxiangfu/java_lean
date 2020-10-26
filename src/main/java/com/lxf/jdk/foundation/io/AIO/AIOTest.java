package com.lxf.jdk.foundation.io.AIO;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 异步非阻塞：java程序只发起读写操作，正真的读写依靠操作系统来进行，并且读写操作也是异步的
 * 基于事件通知
 * 网络io
 */
public class AIOTest {
        private static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");

    public static void main(String[] args){
        int port = 8080;
        //Socket服务端
        new Thread(() ->{
            //Channel组
            AsynchronousChannelGroup group = null;
            try{
                group = AsynchronousChannelGroup.withThreadPool(Executors.newWorkStealingPool());
                AsynchronousServerSocketChannel channel = AsynchronousServerSocketChannel.open(group)
                        .bind(new InetSocketAddress(InetAddress.getLocalHost(), port));
                channel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
                    @Override
                    public void completed(AsynchronousSocketChannel result, Object attachment) {
                        channel.accept(null, this);//接收连接
                        try{
                            Future<Integer> future = result.write(Charset.defaultCharset().encode("Hi,老王！"));
                            future.get();//返回操作结果
                            System.out.println("服务端发送时间：" + FORMATTER.format(LocalDateTime.now()));
                            result.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void failed(Throwable exc, Object attachment) {

                    }
                });
                group.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
            }catch (IOException | InterruptedException e){
                e.printStackTrace();
            }
        }).start();

        //Socket客户端
        new Thread(() ->{
            try{
                AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
                Future<Void> future = client.connect(new InetSocketAddress(InetAddress.getLocalHost(), port));
                future.get();
                ByteBuffer byteBuffer = ByteBuffer.allocate(100);
                client.read(byteBuffer, null, new CompletionHandler<Integer, Object>() {
                    @Override
                    public void completed(Integer result, Object attachment) {
                        System.out.println("客户端接收时间：" + FORMATTER.format(LocalDateTime.now()));
                        System.out.println("客户端打印：" + new String(byteBuffer.array(), Charset.forName("utf-8")));
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
                Thread.sleep(10*1000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();


    }
}