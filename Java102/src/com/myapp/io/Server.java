package com.myapp.io;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server {
	
	private static SocketChannel createChannel() throws IOException {
		ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
		serverSocketChannel.bind(new InetSocketAddress("localhost",8888));
		return serverSocketChannel.accept();
	}

	public static void main(String[] args) {
			try (ObjectInputStream os=new ObjectInputStream
				(createChannel().socket().getInputStream())) {
				System.out.println(os.readObject());
			}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}

// public class MyComparable implements Comparable<Order>{

//public int compareTo(Order o){

//return 
//}

//}

// Comparable c=( Order o1)->{
//}


// Comparable<Order> c=new Comparable<>{
//public int compareTo(Order o){

//return 
//}

//}












