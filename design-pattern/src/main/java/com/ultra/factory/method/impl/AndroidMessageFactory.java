package com.ultra.factory.method.impl;

import com.ultra.factory.method.IMessage;
import com.ultra.factory.method.IMessageFactory;
import com.ultra.factory.method.MessageConstant;

public class AndroidMessageFactory implements IMessageFactory {

    @Override
    public IMessage create(int messageType) {
        if (messageType == MessageConstant.EMAIL) {
            return new EmailAndroidMessage();
        } else {
            return new SmsAndroidMessage();
        }
    }

}
