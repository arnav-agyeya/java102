package com.myapp.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class OrdersDeSerialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		try (ObjectInputStream os=new ObjectInputStream(
				new FileInputStream("tmp2.obj"))){
			
			List<Orders2> orders1= new ArrayList<>();
			
		
			while(os.available()>0) {
			Orders2 orders=new Orders2();
			orders.readExternal(os);
			orders1.add(orders);
			}
			System.out.println(orders1);
		
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
