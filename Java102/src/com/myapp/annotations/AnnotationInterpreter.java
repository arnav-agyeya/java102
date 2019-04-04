package com.myapp.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationInterpreter {
	
	public  static <T>  void inject(Class<T> resolveClass, T target) {
		//resolveClass.getFields();
		
		Method methods[]=resolveClass.getMethods();
		
		for(Method method:methods) {
			if(method.getName().equals("doSomething")) {
			try {
				method.invoke(target);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			Annotation[] annotations = method.getAnnotations();
	         for (Annotation annotation : annotations)
	         {
	            if (annotation instanceof Autowired)
	            {
	               Autowired autowired = (Autowired) annotation;
	               System.out.println("Value :" +autowired.value());
	              
	            }
	         }	
			}
		}
		
		
		
//		Field [] fields=resolveClass.getDeclaredFields();
//		
//		for(Field field:fields) {
//			field.setAccessible(true);
//			Autowired autowired=field.getAnnotation(Autowired.class);
//			if(autowired!=null) {
//				try {
//					field.set(target, autowired.value());
//				} catch (IllegalArgumentException | IllegalAccessException e) {
//					e.printStackTrace();
//				}
//			}
//		}
		
		
		
	}

}
