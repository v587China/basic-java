package com.ultra.java;

public class H002Thread线程之yield和sleep和join和interrupt和isLive方法  extends Thread{
	public static void main(String[] args) {
		H002Thread线程之yield和sleep和join和interrupt和isLive方法 t=new H002Thread线程之yield和sleep和join和interrupt和isLive方法();
		//isAlive():判断该线程是否是死亡状态，死亡状态的线程不能再次调用start()方法
		System.out.println(t.isAlive());
		t.start();
		System.out.println(t.isAlive());
		//如果线程在调用 Object 类的 wait()方法，
		//或者该类的 join()、sleep(long)方法过程中受阻，则其中断状态将被清除，它还将收到一个 InterruptedException。
		t.interrupt();
		for(int i=0;i<100;i++){
			if(i==50){
				try {
					//调用其他线程的join方法，等待该线程终止
					//本线程会进入阻塞状态
					t.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+": "+i);
		}
		System.out.println(t.isAlive());
		//死亡状态的线程不能再次调用start()方法
		//t.start();

	}
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println(getName()+": "+i);
			//暂停当前线程(进入可执行状态)，并执行其他线程
			//yield();
			if(i==50)
			try {
				//在指定的毫秒数内让当前正在执行的线程休眠(暂停执行)(进入可执行状态),该线程不丢失任何监视器的所属权。
				sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
