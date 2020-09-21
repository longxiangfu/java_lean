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
 * 重写一遍
 */
public class NIOTest1 {
    public static void main(String[] args) {
        int port = 8080;
        //socket服务端
        new Thread(() ->{
            try (Selector selector = Selector.open();
                 ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()
            ){
                serverSocketChannel.bind(new InetSocketAddress(InetAddress.getLocalHost(), port));
                serverSocketChannel.configureBlocking(false);
                serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);//SelectionKey.OP_ACCEPT:服务器监控到客户端连接，就可以接收这个连接了
                while (true){
                    selector.select();
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()){
                        SelectionKey key = iterator.next();
                        try(SocketChannel socketChannel = ((ServerSocketChannel)key.channel()).accept()) {
                            socketChannel.write(Charset.defaultCharset().encode("hi,老王"));
                        }
                        iterator.remove();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        //socket客户端
        new Thread(() ->{
            try(Socket csocket = new Socket(InetAddress.getLocalHost(), port)){
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(csocket.getInputStream()));
                bufferedReader.lines().forEach(message -> System.out.println("收到服务端消息：" + message));
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();


    }

}
