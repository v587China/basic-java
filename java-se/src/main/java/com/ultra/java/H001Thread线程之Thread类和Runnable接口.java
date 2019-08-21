package com.ultra.java;

public class H001Thread线程之Thread类和Runnable接口 {
	int i=0;
	public static void main(String[] args) {
		/**实现多线程的两种方法
		 *1. 继承Thread类，
		 * 1.1 子类需要重写run方法
		 * 1.2 因为该方式创建多线程的方法是，创建多个子类的对象，分别开启线程，所以子类中的字段不能共享，除非是static类型
		 * 	      所以要想共享一个字段，只能是从外部传过去同一个字段对它的字段进行初始化
		 */
		H001Thread线程之Thread类和Runnable接口 h=new H001Thread线程之Thread类和Runnable接口();
		ExtendThread extendThread1=new ExtendThread("线程--壹",h);
		ExtendThread extendThread2=new ExtendThread("线程--贰",h);
		//start()：启动线程
		extendThread1.start();
		extendThread2.start();
		for(;h.i<100;h.i++){
			//currentThrad()：获取当前线程(Thread类的静态方法)
			//getName():获取线程的名字
			System.out.println(Thread.currentThread().getName()+":"+h.i);
		}
	
		//失败  ---->个人猜想：利用实现Runnable接口的方式实现继承Thread
		/*ExtendThread extendThread=new ExtendThread();
		Thread thread1=new Thread(extendThread);
		Thread thread2=new Thread(extendThread);
		//start()：启动线程
		thread1.start();
		thread2.start();*/
		
		
		/**
		 * 2. 实现Runnable接口(该接口只有一个run()方法，所以他不能自己开始线程即不能调用starts()方法)
		 *  2.1 实现run()方法
		 *  2.2 该方式创建多线程的方法是，创建一个该类的对象，当做创建Thread对象的参数，所以多个线程操作时同一个对象，它的字段是共享的。
		 */
		ImplementRunnable implementRunnable=new ImplementRunnable();
		Thread thread1=new Thread(implementRunnable,"线程--壹");
		Thread thread2=new Thread(implementRunnable,"线程--贰");
		thread1.start();
		thread2.start();
	}
}

class ExtendThread extends Thread{
	int i=0;
	H001Thread线程之Thread类和Runnable接口 h;
	public ExtendThread() {
	}
	public ExtendThread(String name,H001Thread线程之Thread类和Runnable接口 h) {
		super(name);
		this.h=h;
		//验证下面的 线程体在 run() 方法中
		//System.out.println(Thread.currentThread().getName());
	}
	//线程体在 run() 方法中
	public void run() {
		for(;h.i<100;h.i++){
			System.out.println(Thread.currentThread().getName()+":"+h.i);
		}
	}
}

class ImplementRunnable implements Runnable{
	int i=0;
	public void run() {
		for(;i<100;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}	
}