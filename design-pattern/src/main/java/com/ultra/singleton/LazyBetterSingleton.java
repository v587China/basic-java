package com.ultra.singleton;

/**
 * 场景:最好的方式
 */
public class LazyBetterSingleton {
    private static LazyBetterSingleton singleton;

    private LazyBetterSingleton() {
    }

    public static final LazyBetterSingleton getInstance() {
        if (singleton == null) {
            synchronized (LazyBetterSingleton.class) {
                if (singleton == null)
                    singleton = new LazyBetterSingleton();
            }
        }
        return singleton;
    }
}
