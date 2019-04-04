package com.myapp.threads;

public class NetworkConnection {
	
	public void access() {
		System.out.println("Network is being accessed by "
				+Thread.currentThread().getName());
	}

}
