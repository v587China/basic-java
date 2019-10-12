package com.ultra.factory.method;

public interface IMessageFactory {

    /**
     * @param messageType : @see com.ultra.factory.method.MessageConstant
     */
    IMessage create(int messageType);
}
