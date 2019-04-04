package com.myapp.threads;

public class FileNetworkTaskA implements Runnable {
	
	private final FileConnection fileConnection;
	private final NetworkConnection networkConnection;
	
	
public FileNetworkTaskA(FileConnection fileConnection,
		NetworkConnection networkConnection) {
		this.fileConnection = fileConnection;
		this.networkConnection = networkConnection;
	}
	@Override
	public void run() {
		
		synchronized (fileConnection) {
			
			synchronized (networkConnection) {
				networkConnection.access();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				fileConnection.access();
				
			}
			
		}
		
		
	}

}
