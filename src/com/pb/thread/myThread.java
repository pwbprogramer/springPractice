package com.pb.thread;

public class myThread extends Thread {
    
	private boolean flag;
	
	public myThread() {
		
	}
	
	public myThread(boolean flag) {
		this.flag = flag;
	}
	
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		int j = 0;
		while(this.flag) {
			System.out.println("myThred:"+j);
		}
	}

}
