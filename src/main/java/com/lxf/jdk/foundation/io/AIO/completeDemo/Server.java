package com.lxf.jdk.foundation.io.AIO.completeDemo;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    //线程池
    private ExecutorService executorService;
    //服务器通道组
    private AsynchronousChannelGroup channelGroup;
    //服务器通道
    public AsynchronousServerSocketChannel asynchronousServerSocketChannel;

    public Server(int port){
        try {
            //创建一个缓存池
            executorService = Executors.newCachedThreadPool();
            //创建服务器通道组
            channelGroup = AsynchronousChannelGroup.withCachedThreadPool(executorService, 1);
            //创建服务器通道
            asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open(channelGroup);
            //进行绑定
            asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
            System.out.println("server start , port : " + port);
            //进行阻塞,接收连接。接收到连接后，调用CompletionHandler的completed方法
            asynchronousServerSocketChannel.accept(this, new CompletionHandler<AsynchronousSocketChannel, Server>() {
                @Override
                public void completed(AsynchronousSocketChannel socketChannel, Server attachment) {
                    System.out.println("接收到连接");
                    //当有下一个客户端接入的时候 直接调用Server的accept方法，这样反复执行下去，保证多个客户端都可以阻塞（没有递归上限），1.7以后AIO才实现了异步非阻塞
                    asynchronousServerSocketChannel.accept(attachment, this);
                    read(socketChannel);
                }

                private void read(final AsynchronousSocketChannel socketChannel) {
                    //读取数据
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    //将Channel中的数据读入到ByteBuffer中，当读取完成之后调用CompletionHandler的completed方法
                    socketChannel.read(buf, buf, new CompletionHandler<Integer, ByteBuffer>() {
                        @Override
                        public void completed(Integer resultSize, ByteBuffer byteBuffer) {
                            //进行读取之后,重置标识位
                            byteBuffer.flip();
                            //获得读取的字节数
                            System.out.println("Server -> " + "收到客户端的数据长度为:" + resultSize);
                            //获取读取的数据
                            String resultData = new String(byteBuffer.array()).trim();
                            System.out.println("Server -> " + "收到客户端的数据信息为:" + resultData);
                            String response = "服务器响应, 收到了客户端发来的数据: " + resultData;
                            write(socketChannel, response);
                        }

                        @Override
                        public void failed(Throwable exc, ByteBuffer attachment) {
                            exc.printStackTrace();
                        }
                    });
                }

                private void write(AsynchronousSocketChannel socketChannel, String response) {
                    try {
                        ByteBuffer buf = ByteBuffer.allocate(1024);
                        buf.put(response.getBytes());
                        buf.flip();
                        socketChannel.write(buf).get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void failed(Throwable exc, Server attachment) {

                }
            });
            //一直阻塞 不让服务器停止
            Thread.sleep(Integer.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Server server = new Server(8765);
    }
}
