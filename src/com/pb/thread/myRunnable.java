package com.pb.thread;

public class myRunnable implements Runnable {
    
	private boolean flag;
	
	public myRunnable() {
		
	}
	
    public myRunnable(boolean flag) {
		this.flag=flag;
	}
    
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		int i=0;
         while(this.flag) {
        	 System.out.println("myRunnable:"+i);
         }
	}

}
