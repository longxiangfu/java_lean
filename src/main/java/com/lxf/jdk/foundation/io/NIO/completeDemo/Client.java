package com.lxf.jdk.foundation.io.NIO.completeDemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {


    public static void main(String[] args) {
        //创建连接的地址
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8765);
        //声明连接通道
        SocketChannel socketChannel;
        //建立缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        try {
            //打开通道
            socketChannel = SocketChannel.open();
            //设置通道道为阻塞模式,目的是必须连接上服务端之前一直阻塞
            socketChannel.configureBlocking(true);
            //进行连接
            socketChannel.connect(address);
            String request = "非阻塞模式下,read()方法在尚未读取到任何数据时可能就返回了。所以需要关注它的int返回值，它会告诉你读取了多少字节";
            byte[] bytes = request.getBytes();
            //把数据放到缓冲区中
            buf.put(bytes);
            //对缓冲区进行复位
            buf.flip();
            //写出数据
            socketChannel.configureBlocking(false);//写出时设置成非阻塞模式，目的是可以不用写完就可以返回
            socketChannel.write(buf);
            System.out.println("client write:" + request);
            //清空缓冲区数据
            buf.clear();
            //读
            read(socketChannel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void read(SocketChannel socketChannel) {
        ByteBuffer readBuf = ByteBuffer.allocate(1024);
        try {
            //1 清空缓冲区旧的数据
            readBuf.clear();
            //在非阻塞模式下，若socketChannel中没有数据，也可直接返回。可以将服务端写出的代码注释掉进行测试
            //在阻塞模式下，若socketChannel中没有数据，则阻塞
            int count = socketChannel.read(readBuf);//同步非阻塞，通道无数据或不可写时，立即返回
            //4 如果没有数据
            if (count <= 0) {
                System.out.println("无数据可读");
                return;
            }
            //5 有数据则进行读取 读取之前需要进行复位方法(把position 和limit进行复位)
            readBuf.flip();
            //6 根据缓冲区的数据长度创建相应大小的byte数组，接收缓冲区的数据
            byte[] bytes = new byte[readBuf.remaining()];
            //7 接收缓冲区数据
            readBuf.get(bytes);
            //8 打印结果
            String body = new String(bytes).trim();
            System.out.println("Client receive:" + body);
    } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
