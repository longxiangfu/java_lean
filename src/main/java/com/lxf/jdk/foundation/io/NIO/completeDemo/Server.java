package com.lxf.jdk.foundation.io.NIO.completeDemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

public class Server implements Runnable {
    //1 多路复用器（管理所有的通道）
    private Selector seletor;
    //2 建立读缓冲区
    private ByteBuffer readBuf = ByteBuffer.allocate(1024);


    public Server(int port){
        try {
            //1 打开路复用器
            this.seletor = Selector.open();
            //2 打开服务器通道
            ServerSocketChannel socketChannel = ServerSocketChannel.open();
            //3 设置服务器通道为非阻塞模式
            socketChannel.configureBlocking(false);//通道无数据或不可写时，立即返回  //设置成true会报错
            //4 绑定Channel和地址
            socketChannel.bind(new InetSocketAddress(port));
            //5 把服务器通道注册到多路复用器上，并且监听阻塞事件
            socketChannel.register(this.seletor, SelectionKey.OP_ACCEPT);
            System.out.println("Server start, port :" + port);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    @Override
    public void run() {
        System.out.println("run...");
        while(true){
            System.out.println("while ture...");
            try {
                //1 必须要让多路复用器开始监听。
                //根据注释说明，Selector监听通道事件，当有事件发生时，调用Selector的wakeup方法
                this.seletor.select();
                //2 返回多路复用器已经选择的结果集
                Iterator<SelectionKey> keys=this.seletor.selectedKeys().iterator();
                //3 进行遍历
                while(keys.hasNext()){
                    //4 获取一个选择的元素
                    SelectionKey key = keys.next();
                    //5 直接从容器中移除就可以了
                    keys.remove();
                    //6 如果是有效的
                    if(key.isValid()){
                        this.read(key);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



    private void read(SelectionKey key) {
        try {
            //1 清空缓冲区旧的数据
            this.readBuf.clear();
            //2 获取之前注册的socket通道对象
            SocketChannel socketChannel = ((ServerSocketChannel)key.channel()).accept();
            //3 将数据读取到缓冲区
            int count = socketChannel.read(this.readBuf);//同步非阻塞，通道无数据或不可写时，立即返回
            //4 如果没有数据
            if(count <= 0){
                System.out.println("无数据可读");
                key.channel().close();
                key.cancel();
                return;
            }
            //5 有数据则进行读取 读取之前需要进行复位方法(把position 和limit进行复位)
            this.readBuf.flip();//将指针恢复到缓冲区的开始位置
            //6 根据缓冲区的数据长度创建相应大小的byte数组，接收缓冲区的数据
            byte[] bytes = new byte[this.readBuf.remaining()];
            //7 接收缓冲区数据
            this.readBuf.get(bytes);
            //8 打印结果
            String body = new String(bytes).trim();
            System.out.println("Server receive: " + body);
//            // 9 写回给客户端数据
            String response = "老王，您好！";
            socketChannel.write(Charset.defaultCharset().encode(response));
            System.out.println("Server write:" + response);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public static void main(String[] args) {
        new Thread(new Server(8765)).start();
    }


}
