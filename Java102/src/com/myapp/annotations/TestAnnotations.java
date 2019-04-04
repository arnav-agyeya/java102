package com.myapp.annotations;

public class TestAnnotations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ServiceLayer serviceLayer=new ServiceLayer();
		AnnotationInterpreter.inject(ServiceLayer.class, serviceLayer);
		
		//serviceLayer.doSomething();
		
	}

}
