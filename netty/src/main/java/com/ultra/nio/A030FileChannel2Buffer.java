package com.ultra.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 将文件中中数据读取到Buffer
 * output/input是相对于stream/channel而言，write/read是相对于文件而言
 * 把流写入到文件中即是流出，所以需要写入到文件
 * 把文件写入到流中即是流入，所以需要读取文件
 */
public class A030FileChannel2Buffer {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream("/Users/admin/Documents/test.txt");
        FileChannel fileChannel = inputStream.getChannel();


        ByteBuffer byteBuffer = ByteBuffer.allocate(1);
        while (true) {
            byteBuffer.clear();
            int read = fileChannel.read(byteBuffer);
            if (read == -1) {
                break;
            }
            byteBuffer.flip();
            System.out.println(new String(byteBuffer.array()));
        }
        fileChannel.close();
        inputStream.close();
    }
}
