package com.myapp.threads.waitnotify;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public final class ApnaRestaurant
{
	static final int TIME_SCALER = 10;

	private static final int numWaiters = 5;
	private static final int numCustomers = 50;

	static final int restaurantOpeningTime = 360;
	
	static volatile boolean closed = true;

	static final AtomicInteger numCustomersInRestaurant = new AtomicInteger();

	static final Queue<Request> requests = new LinkedList<>();
	
	public static void main(String[] args)
	{
		Thread[] waiters = new Thread[numWaiters];
		Thread[] customers = new Thread[numCustomers];

		for (int i = 0; i < numWaiters; i++)
		{
			String name = "Waiter " + (i + 1);
			waiters[i] = new Thread(new Waiter(name), name);
		}

		for (int i = 0; i < numCustomers; i++)
		{
			String name = "Customer " + (i + 1);
			customers[i] = new Thread(new Customer(name), name);
		}

		System.out.println("Restaurant is opening");

		closed = false;

		for (int i = 0; i < numWaiters; i++)
		{
			waiters[i].start();
		}

		System.out.println("Restaurant is letting in customers");

		for (int i = 0; i < numCustomers; i++)
		{
			customers[i].start();
		}

		try
		{
			Thread.sleep(restaurantOpeningTime * TIME_SCALER);
		}
		catch (InterruptedException e)
		{
			// Shouldn't happen, ignore
		}

		System.out.println("Restaurant is closing to new customers");

		// No more customers please
		closed = true;

		// Any customers that aren't waiting for seating are too late
		for (int i = 0; i < numCustomers; i++)
		{
			customers[i].interrupt();
		}

		// Allow customers to finish their meal
		while (numCustomersInRestaurant.get() > 0)
		{
			// Sleep for '20 minutes'
			try
			{
				Thread.sleep(20 * TIME_SCALER);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
//		// Send any waiting waiters home
//		for (int i = 0; i < numWaiters; i++)
//		{
//			waiters[i].interrupt();
//		}

		// Finally done for the day
		System.out.println("Restaurant is closed");
	}
}