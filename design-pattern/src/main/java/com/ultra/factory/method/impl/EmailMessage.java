package com.ultra.factory.method.impl;

import com.ultra.factory.method.IMessage;

public class EmailMessage implements IMessage {

    @Override
    public void sendMessage() {
        System.out.println("EmailMessage sendMessage...");
    }

}
