package com.myapp.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TestByteStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try (InputStream in=new BufferedInputStream
				(new FileInputStream(new File("./src/com/myapp/ooad/MarkerImpl.java")));
			OutputStream os= new BufferedOutputStream(
					new FileOutputStream(new File("tmp.txt")))	){
			byte buffer[]= new byte[1024];
			int length=0;
			
			while((length=in.read(buffer))>0) {
				os.write(buffer,0,length);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
