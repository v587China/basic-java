package com.ultra.factory.method.impl;

import com.ultra.factory.method.IMessage;

public class SmsIosMessage implements IMessage {

    @Override
    public void sendMessage(String message) {
        System.out.println("SmsIosMessage sendMessage:" + message);
    }

}
