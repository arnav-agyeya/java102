package com.myapp.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

public class OrdersSerialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		List<Orders> list=Arrays.asList(new Orders(1,"Order1",8999.4),
				new Orders(4,"Order2",5999.4),
				new Orders(2,"Order4",2999.4));
		
		Orders2 orders[]= {new Orders2(1,"Order1",8999.4),
				new Orders2(4,"Order2",5999.4),
				new Orders2(2,"Order4",2999.4)};
		try (ObjectOutputStream os=new ObjectOutputStream(
				new FileOutputStream("tmp2.obj"))){
			
			for(Orders2 o:orders) {
				o.writeExternal(os);
			}
			//os.writeObject(list);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
