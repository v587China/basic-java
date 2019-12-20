package com.ultra.java.callback;

import javafx.util.Callback;

/**
 * @author fan
 * @date 2019/12/18 14:56
 */
public class Consumer implements Callback<String, String> {


    public void invokeApi(String param) {
        System.out.println("Consumer准备调用接口,param is " + param);
        ServiceApi.service(param, this);
        System.out.println("Consumer调用接口完成");
    }

    @Override
    public String call(String param) {
        System.out.println("Consumer回调函数执行,callback param is " + param);
        return "finish";
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Consumer consumer = new Consumer();
            consumer.invokeApi(String.valueOf(i));
        }
    }
}
