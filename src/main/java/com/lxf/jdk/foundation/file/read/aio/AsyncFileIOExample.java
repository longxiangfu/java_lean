package com.lxf.jdk.foundation.file.read.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 异步非阻塞文件读写示例
 */
public class AsyncFileIOExample {
    public static void main(String[] args) {
        Path path = Paths.get("example.txt");

        // 异步写入文件
        asyncWriteToFile(path, "Hello, Asynchronous I/O!");

        // 异步读取文件
        asyncReadFromFile(path);
    }

    private static void asyncWriteToFile(Path path, String content) {
        try (AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            ByteBuffer buffer = ByteBuffer.allocate(content.getBytes().length);
            buffer.put(content.getBytes());
            buffer.flip();

            fileChannel.write(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    System.out.println("Write operation completed. Bytes written: " + result);
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    System.err.println("Write operation failed: " + exc.getMessage());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void asyncReadFromFile(Path path) {
        try (AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            fileChannel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    attachment.flip();
                    byte[] data = new byte[attachment.remaining()];
                    attachment.get(data);
                    System.out.println("Read operation completed. Content: " + new String(data));
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    System.err.println("Read operation failed: " + exc.getMessage());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
