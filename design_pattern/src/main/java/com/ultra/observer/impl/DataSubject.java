package com.ultra.observer.impl;

import com.ultra.observer.IObserver;
import com.ultra.observer.ISubject;

import java.util.ArrayList;
import java.util.List;

public class DataSubject implements ISubject {

    private static final List<IObserver> list = new ArrayList<>();

    private String message;

    @Override
    public void registerObserver(IObserver observer) {
        if (!list.contains(observer)) {
            list.add(observer);
        }
    }

    @Override
    public void removeObserver(IObserver observer) {
        if (!list.contains(observer)) {
            list.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : list) {
            observer.update(message);
        }
    }

    private void dataChange() {
        //do somethings
        notifyObservers();
    }

    public void setMessage(String message) {
        this.message = message;
        dataChange();
    }
}
