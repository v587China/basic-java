package com.ultra.singleton;

/**
 * 场景:①对象必会使用,②对象创建不消耗资源
 */
public class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton() {
    }

    public synchronized static final Singleton getInstance() {
        return singleton;
    }
}
