package com.myapp.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class TestCharacterStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try (Reader in=new BufferedReader
				(new FileReader(new File("./src/com/myapp/ooad/MarkerImpl.java")));
			Writer os= new BufferedWriter(
					new FileWriter(new File("tmp2.txt")))	){
			char buffer[]= new char[1024];
			int length=0;
			
			while((length=in.read(buffer))>0) {
				os.write(buffer,0,length);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
