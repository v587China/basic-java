package com.ultra.factory.method.impl;

import com.ultra.factory.method.IMessage;

public class SmsAndroidMessage implements IMessage {

    @Override
    public void sendMessage(String message) {
        System.out.println("SmsAndroidMessage sendMessage:" + message);

    }

}
