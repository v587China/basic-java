package com.ultra.factory.method.impl;

import com.ultra.factory.method.IMessage;

public class EmailMessage implements IMessage {

    @Override
    public void sendMesage() throws Exception {
        System.out.println("EmailMessage sendMesage...");
    }

}
