package com.lxf.jdk.foundation.io.BIO;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * BIO
 * 同步阻塞，基层基于阻塞IO模型
 */
public class Server {

    final static int PORT = 8765;


    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(PORT);
            System.out.println("server start");
            Socket socket;
            HandlerExecutorPool executorPool = new HandlerExecutorPool(50, 1000);
            while(true){
                socket = server.accept();
                executorPool.execute(new ServerHandler(socket));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(server != null){
                try {
                    server.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }


}
