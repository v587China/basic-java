package com.ultra.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 从文件中读取写入到Buffer，并从该Buffer中写入到另一个文件中
 */
public class A040BufferTwoWayFileChannel {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream("/Users/admin/Documents/test.txt");
        FileChannel inputStreamChannel = inputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        inputStreamChannel.read(byteBuffer);
        byteBuffer.flip();

        FileOutputStream outputStream = new FileOutputStream("/Users/admin/Documents/test2.txt");
        FileChannel outputStreamChannel = outputStream.getChannel();
        outputStreamChannel.write(byteBuffer);
    }
}
