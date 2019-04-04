package com.myapp.threads;

public class TestWithoutSynchronization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileConnection fileConnection=new FileConnection();
		NetworkConnection networkConnection=new NetworkConnection();
		
		FileNetworkTaskA task=new FileNetworkTaskA(fileConnection, networkConnection);
		FileNetworkTaskB taskB=new FileNetworkTaskB(fileConnection, networkConnection);
		
		Thread thread1=new Thread(task,"ONE");
		Thread thread2=new Thread(taskB,"TWO");
		thread1.start();
		thread2.start();
		

	}

}
