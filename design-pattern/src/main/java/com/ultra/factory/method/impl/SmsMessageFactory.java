package com.ultra.factory.method.impl;

import com.ultra.factory.method.IMessage;
import com.ultra.factory.method.IMessageFactory;

public class SmsMessageFactory implements IMessageFactory {

    @Override
    public IMessage create() {
        return new SmsMessage();
    }

}
