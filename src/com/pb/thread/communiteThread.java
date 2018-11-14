package com.pb.thread;

/**
 * 两个线程交替打印
 * @author pwb
 *
 */
class printNum implements Runnable{
	
	private int i;
	
	public void setI(int i) {
		this.i=i;
	}
	
	public int getI() {
		return this.i;
	}
	
	@Override
	public void run() {
		while(true) {
			synchronized (this) {
				notify();
				if(i<=100) {
					System.out.println(Thread.currentThread().getName()+":"+i);
				}else {
					break;
				}
				i++;
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}


public class communiteThread {

	public static void main(String[] args) {
		printNum printnum = new printNum();
		printnum.setI(1);
		Thread th1 = new Thread(printnum, "甲");
		Thread th2 = new Thread(printnum, "乙");
		th1.start();
		th2.start();
	}

}
