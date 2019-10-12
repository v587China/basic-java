package com.ultra.factory.method.impl;

import com.ultra.factory.method.IMessage;

public class EmailAndroidMessage implements IMessage {

    @Override
    public void sendMessage(String message) {
        System.out.println("EmailAndroidMessage sendMessage:" + message);

    }

}
