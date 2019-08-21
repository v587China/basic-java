package com.ultra.java;

public class H003Thread线程之线程同步 implements Runnable {

	int count=50;
	public static void main(String[] args) {
		H003Thread线程之线程同步 t=new H003Thread线程之线程同步();
		Thread t1=new Thread(t,"小明");
		Thread t2=new Thread(t,"小强");
		t1.start();
		t2.start();

	}

	@Override
	public void run() {
		boolean flag=getCount();
		while(flag){
			flag = getCount();
		}
		System.out.println(Thread.currentThread().getName()+"结束了。");
	}
	public boolean getCount(){
		synchronized (this) {
			if(count>0){
				count--;
//				try {
//					Thread.sleep(10);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				System.out.println(Thread.currentThread().getName()+"拿走了一个，还剩下"+count+"个");
				return true;
			}
		}
		return false;
	}
}
