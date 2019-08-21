package com.ultra.test;

public class ThreadTest implements Runnable {
	int i=0;
	String name="";
	public synchronized void printChar(){
		name=Thread.currentThread().getName();
		if("线程--1".equals(name)){
			if(i%3==0){
				System.out.println(name+": "+i);
				i++;
				notifyAll();
			}else{
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}else if("线程--2".equals(name)){
			if(i%3==1){
				System.out.println(name+": "+i);
				i++;
				notifyAll();
			}else{
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}else if("线程--3".equals(name)){
			if(i%3==2){
				System.out.println(name+": "+i);
				i++;
				notifyAll();
			}else{
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void run() {
		while(true){
			if(i<21)
				printChar();
			else
				break;
		}
	}
	
	public static void main(String[] args) {
		ThreadTest tt=new ThreadTest();
		Thread th1=new Thread(tt);
		Thread th2=new Thread(tt);
		Thread th3=new Thread(tt);
		th1.setName("线程--1");
		th2.setName("线程--2");
		th3.setName("线程--3");
		
		th1.start();
		th2.start();
		th3.start();
	}

}
