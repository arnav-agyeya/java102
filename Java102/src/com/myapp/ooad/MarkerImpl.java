package com.myapp.ooad;

public class MarkerImpl /*implements Marker*/ {
	
	
	public void checkInterface() {
		
		Class<?> clazz=getClass();
		
		Class<?> [] interfaces=clazz.getInterfaces();
		
		boolean flag=false;
		
		for(Class<?> intf:interfaces) {
			if(intf.getSimpleName().equals("Marker"))
				flag=true;
			break;
		}	
		
		if(flag)
			System.out.println("Interface Implemented");
		else
			System.out.println("Interface Not Implemented");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarkerImpl marker= new MarkerImpl();
		marker.checkInterface();

	}

}
