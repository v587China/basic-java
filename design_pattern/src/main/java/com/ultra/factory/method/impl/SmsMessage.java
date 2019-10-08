package com.ultra.factory.method.impl;

import com.ultra.factory.method.IMessage;

public class SmsMessage implements IMessage {

    @Override
    public void sendMesage() throws Exception {
        System.out.println("SmsMessage sendMesage...");
    }

}
