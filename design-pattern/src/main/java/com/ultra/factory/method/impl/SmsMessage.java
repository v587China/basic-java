package com.ultra.factory.method.impl;

import com.ultra.factory.method.IMessage;

public class SmsMessage implements IMessage {

    @Override
    public void sendMessage() {
        System.out.println("SmsMessage sendMessage...");
    }

}
