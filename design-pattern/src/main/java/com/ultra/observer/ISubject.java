package com.ultra.observer;

public interface ISubject {

    /**
     * 订阅
     *
     * @param observer 观察者对象
     */
    void registerObserver(IObserver observer);

    /**
     * 取消
     *
     * @param observer 观察者对象
     */
    void removeObserver(IObserver observer);

    /**
     * 通知观察者
     */
    void notifyObservers(String message);


}
