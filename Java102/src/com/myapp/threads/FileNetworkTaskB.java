package com.myapp.threads;

public class FileNetworkTaskB implements Runnable {
	
	private final FileConnection fileConnection;
	private final NetworkConnection networkConnection;
	
	
public FileNetworkTaskB(FileConnection fileConnection,
		NetworkConnection networkConnection) {
		this.fileConnection = fileConnection;
		this.networkConnection = networkConnection;
	}
	@Override
	public void run() {
		
		synchronized (networkConnection) {
			
			synchronized (fileConnection) {
				fileConnection.access();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				networkConnection.access();
				
			}
			
		}
		
		
	}

}
