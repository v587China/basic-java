package com.ultra.bio;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BioServer {
    private static final Logger logger = LoggerFactory.getLogger(BioServer.class);
    private static final int PORT = 6666;

    public static void main(String[] args) throws IOException {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(PORT);
        logger.info("监听端口：{} 服务启动成功", PORT);
        while (true) {
            logger.info("本次执行线程的id：{}，name：{}，等待客户端连接。。。", Thread.currentThread().getId(), Thread.currentThread().getName());
            Socket clientSocket = serverSocket.accept();
            logger.info("接收到客户端连接，为其创建线程");
            threadPool.execute(() -> {
                extracted(clientSocket);
            });

        }
    }

    private static void extracted(Socket clientSocket) {
        try {
            byte[] readCache = new byte[1024];
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();
            while (true) {
                logger.info("本次执行线程的id：{}，name：{}，等待客户端消息。。。", Thread.currentThread().getId(), Thread.currentThread().getName());
                int read = inputStream.read(readCache);
                logger.info("接收到客户端消息");
                if (read == -1) {
                    logger.info("交互完成，客户端断开连接");
                    break;
                } else {
                    logger.info("本次读取数据：{}", new String(readCache));
                    outputStream.write("success".getBytes(StandardCharsets.UTF_8));
                }
            }
        } catch (IOException e) {
            logger.error("读取信息出错", e);
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                logger.error("关闭客户端socket", e);
            }
        }
    }
}
