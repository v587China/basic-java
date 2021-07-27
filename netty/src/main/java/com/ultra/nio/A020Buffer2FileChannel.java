package com.ultra.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * 将Buffer中数据写入到文件中
 * output/input是相对于stream/channel而言，write/read是相对于文件而言
 * 把流写入到文件中即是流出，所以需要写入到文件
 * 把文件写入到流中即是流入，所以需要读取文件
 */
public class A020Buffer2FileChannel {
    public static void main(String[] args) throws Exception {

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        byteBuffer.put("hello,world".getBytes(StandardCharsets.UTF_8));
        byteBuffer.flip();
        FileOutputStream inputStream = new FileOutputStream("/Users/admin/Documents/test.txt");
        FileChannel fileChannel = inputStream.getChannel();
        fileChannel.write(byteBuffer);
        fileChannel.close();
        inputStream.close();
    }
}
