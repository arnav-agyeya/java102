package com.myapp.io;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.List;

public class Client {
	
	private static SocketChannel createChannel() throws IOException {
		SocketChannel socketChannel=SocketChannel.open();
		SocketAddress socket=new InetSocketAddress("localhost",8888);
		socketChannel.connect(socket);
		return socketChannel;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Orders> list=Arrays.asList(new Orders(1,"Order1",8999.4),
				new Orders(4,"Order2",5999.4),
				new Orders(2,"Order4",2999.4));

		
		try (ObjectOutputStream os=new ObjectOutputStream
				(createChannel().socket().getOutputStream())) {
			
			os.writeObject(list);
			
			System.out.println("Server Started");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
