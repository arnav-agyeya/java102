package com.myapp.threads.threadpool;

public class FileConnection {
	
	public void access() {
		System.out.println("File is being accessed by "
				+Thread.currentThread().getName());
	}

}
