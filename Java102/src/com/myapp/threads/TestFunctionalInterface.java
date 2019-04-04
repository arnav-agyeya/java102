package com.myapp.threads;

import java.util.Comparator;

public class TestFunctionalInterface {
	
	public static void doSomething() {
		
		Runnable r1=()->{
			
		};
		
Runnable r=new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		};
		
//	Comparator<String> c=new Comparator<String>() {
//
//		@Override
//		public int compare(String o1, String o2) {
//			// TODO Auto-generated method stub
//			return 0;
//		}
//		
//		
//	};
		
		Comparator<String> c= ( o1, o2) ->{return 0;};
			
			
		
		
		System.out.println(c.getClass().getSimpleName());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		doSomething();
	}

}
