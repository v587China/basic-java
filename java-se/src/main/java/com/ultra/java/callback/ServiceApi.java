package com.ultra.java.callback;

import javafx.util.Callback;

/**
 * @author fan
 * @date 2019/12/18 14:51
 */
public class ServiceApi {

//    private static final ThreadFactory NAMED_THREAD_FACTORY = new ThreadFactoryBuilder().setNameFormat("ServiceApiThread-%d").build();
//    private static final ExecutorService EXECUTOR = new ThreadPoolExecutor(10, 50, 20, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(), NAMED_THREAD_FACTORY);

    public static void service(String param, Callback<String, String> callback) {
        System.out.println("ServiceApi receive param is " + param);
        if (callback != null) {
//            EXECUTOR.execute(() -> {
            try {
                System.out.println("ServiceApi 执行耗时任务");
                Thread.sleep(11000);
                System.out.println("ServiceApi 执行耗时任务完成");
                System.out.println("ServiceApi 执行回调函数");
                String call = callback.call("success,param is " + param);
                System.out.println("ServiceApi 回调函数返回值:" + call);
            } catch (InterruptedException e) {
            }
//            });
        }
        System.out.println("ServiceApi 先返回,wait callback");
    }
}
