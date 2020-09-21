package com.lxf.jdk.foundation.io.NIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * NIO示例：同步非阻塞
 * 客户端、ServerSocketChannel、SelectionKey、Selector、服务端
 */
public class NIOTest {
    public static void main(String[] args) {
        int port = 8080;
        //socket服务端
        new Thread(() ->{
            try(Selector selector = Selector.open();//打开Selector
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()//打开Server-socket channel
                    ){
                //Channel绑定ip和端口
                serverSocketChannel.bind(new InetSocketAddress(InetAddress.getLocalHost(), port));
                //设置Channel为非阻塞
                serverSocketChannel.configureBlocking(false);
                //将Channel通过SelectionKey注册到Selector上
                serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
                while (true){
                    //选择Selectinkey的集合，这些key对应的Channel已经做好了进行I/O操作的准备
                    selector.select();
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()){
                        SelectionKey key = iterator.next();
                        try(SocketChannel channel = ((ServerSocketChannel)key.channel()).accept()){
                            //写出数据
                            channel.write(Charset.defaultCharset().encode("老王，你好！"));
                        }
                        iterator.remove();//删除key
                    }
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }).start();

        //socket客户端1
        new Thread(() ->{
            try(Socket csocket = new Socket(InetAddress.getLocalHost(), port)){//客户端创建Socket,连接Channel
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(csocket.getInputStream()));
                bufferedReader.lines().forEach(message -> System.out.println("客户1端打印：" + message));
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        //socket客户端2
        new Thread(() ->{
            try(Socket csocket = new Socket(InetAddress.getLocalHost(), port)){
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(csocket.getInputStream()));
                bufferedReader.lines().forEach(message -> System.out.println("客户端2打印：" + message));
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();



    }
}
