package com.myapp.threads;

public class RunnableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//MyTask task=new MyTask();
		
		Runnable task=()->{
			for(int i=0;i<5;i++) {
				try {
					Thread.sleep(100000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			System.out.println("Thread Iteration Count "+i+"  "
			+Thread.currentThread().getName());	
			}
			
		};
		
		Thread one=new Thread(task,"ONE");
		Thread two=new Thread(task,"TWO");
		Thread three=new Thread(task,"THREE");
		
		one.start();
		two.start();
		
		try {
			two.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		three.start();
		
	}

}
