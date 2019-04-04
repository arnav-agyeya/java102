package com.myapp.threads.waitnotify.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Kitchen {
	
	private ScheduledExecutorService waiter;
	
	private final int delayMs = 15* ApnaRestaurant.TIME_SCALER;
	
	public void open() {
		waiter = Executors.newSingleThreadScheduledExecutor();
	}
	
	public void prepareMeal (Runnable mealNotifier) {
		System.out.println("Meal Request is sent to kitchen.");
		
		waiter.schedule(mealNotifier, delayMs, TimeUnit.MILLISECONDS);
	}
	
	public void close() {
		waiter.shutdown();
	}
	
}
