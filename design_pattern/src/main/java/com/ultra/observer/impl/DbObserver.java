package com.ultra.observer.impl;

import com.ultra.observer.IObserver;

public class DbObserver implements IObserver {

    @Override
    public void update(String message) {
        System.out.println("db update:" + message);
    }

}
