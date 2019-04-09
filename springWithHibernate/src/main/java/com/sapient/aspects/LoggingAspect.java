package com.sapient.aspects;

import java.util.ArrayList;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.sapient.entities.WorkoutCollection;

@Component
@Aspect
public class LoggingAspect {
	
	@Before("execution(* com.sapient.*.Payment*.*(..))")
	public void doLogging(JoinPoint joinPoint){
		System.out.println(joinPoint.getTarget());
		Object params[] = joinPoint.getArgs();
		for(Object param: params){
			System.out.println(param);
		}
		
		System.out.println("Before execution of target");
	}
	
	@Before("execution(* com.sapient.*.WorkoutRepo.*(..))")
	public void doLoggingWorkout(JoinPoint joinPoint) {
		System.out.println(joinPoint.getTarget());
		Object params[] = joinPoint.getArgs();
		for(Object param: params){
			System.out.println(param);
		}
		
		System.out.println("Before execution of target");
	}
	
	@AfterReturning(pointcut="execution(* com.sapient.*.WorkoutRepo.*(..))",returning="retVal")
	public void afterLoggingWorkout(Object retVal) {
		System.out.println("After Execution");
		
		ArrayList<WorkoutCollection> res= (ArrayList<WorkoutCollection>) retVal; 
		
		for(WorkoutCollection wo : res) {
			System.out.println(wo);
		}
	}

}
