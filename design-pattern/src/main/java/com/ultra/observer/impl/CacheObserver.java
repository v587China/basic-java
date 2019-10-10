package com.ultra.observer.impl;

import com.ultra.observer.IObserver;

public class CacheObserver implements IObserver {

    @Override
    public void update(String message) {
        System.out.println("cache update:" + message);
    }

}
