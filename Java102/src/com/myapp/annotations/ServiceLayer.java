package com.myapp.annotations;

public class ServiceLayer {
	
	
	
	//private String data;
	
	
	@Autowired("Some New Value")
	public void doSomething() {
		
		System.out.println("Injected Data ");
	}

}
