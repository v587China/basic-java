package com.ultra.java;

import com.ultra.test.ThreadTest;

public class H004Thread线程之线程同步 implements Runnable {
    int i = 0;

    // String name="";
    public synchronized void printChar() {
        // name=Thread.currentThread().getName();
        System.out.println(i);
        i++;
        notify();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            if (i < 21)
                printChar();
            else
                break;
        }
    }

    public static void main(String[] args) {
        H004Thread线程之线程同步 tt = new H004Thread线程之线程同步();
        Thread th1 = new Thread(tt, "线程--1");
        Thread th2 = new Thread(tt, "线程--2");

        th1.start();
        th2.start();
    }

}

class H004Thread线程之线程同步2 implements Runnable {
    int i = 0;
    String name = "";

    public synchronized void printChar() {
        name = Thread.currentThread().getName();
        if ("线程--1".equals(name)) {
            if (i % 3 == 0) {
                System.out.println(name + ": " + i);
                i++;
                // notify():随机唤醒一个线程
                // notifyAll():唤醒所有线程
                notifyAll();
            } else {
                try {
                    // wait():进入阻塞状态，并释放当前线程锁，只到被notify()或者notifyAll()唤醒
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else if ("线程--2".equals(name)) {
            if (i % 3 == 1) {
                System.out.println(name + ": " + i);
                i++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else if ("线程--3".equals(name)) {
            if (i % 3 == 2) {
                System.out.println(name + ": " + i);
                i++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void run() {
        while (true) {
            if (i < 21)
                printChar();
            else
                break;
        }
    }

    public static void main(String[] args) {
        ThreadTest tt = new ThreadTest();
        Thread th1 = new Thread(tt);
        Thread th2 = new Thread(tt);
        Thread th3 = new Thread(tt);
        th1.setName("线程--1");
        th2.setName("线程--2");
        th3.setName("线程--3");

        th1.start();
        th2.start();
        th3.start();
    }

}
