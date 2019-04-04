package com.myapp.threads;

public class MyTask implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			try {
				Thread.sleep(100000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		System.out.println("Thread Iteration Count "+i+"  "
		+Thread.currentThread().getName());	
		}

	}

}
