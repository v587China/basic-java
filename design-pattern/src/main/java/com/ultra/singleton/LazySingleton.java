package com.ultra.singleton;

/**
 * 场景:性能要求不高
 */
public class LazySingleton {
    private static LazySingleton singleton;

    private LazySingleton() {
    }

    public synchronized static final LazySingleton getInstance() {
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }
}
