package com.myapp.threads.threadpool;

public class NetworkConnection {
	
	public void access() {
		System.out.println("Network is being accessed by "
				+Thread.currentThread().getName());
	}

}
