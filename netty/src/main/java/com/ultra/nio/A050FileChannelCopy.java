package com.ultra.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class A050FileChannelCopy {

    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream("/Users/admin/Documents/test.txt");
        FileChannel inputStreamChannel = inputStream.getChannel();


        FileOutputStream outputStream = new FileOutputStream("/Users/admin/Documents/test3.txt");
        FileChannel outputStreamChannel = outputStream.getChannel();
        outputStreamChannel.transferFrom(inputStreamChannel, 0, inputStreamChannel.size());

        FileOutputStream outputStream2 = new FileOutputStream("/Users/admin/Documents/test4.txt");
        FileChannel outputStreamChannel2 = outputStream2.getChannel();
        inputStreamChannel.transferTo(0, inputStreamChannel.size(), outputStreamChannel2);

    }
}
