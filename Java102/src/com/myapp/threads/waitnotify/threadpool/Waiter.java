package com.myapp.threads.waitnotify.threadpool;

public class Waiter implements Runnable
{
	private final String name;
	private Request currentRequest;
	
	private Kitchen kitchen;

	public Waiter(String name, Kitchen kitchen)
	{
		this.name = name;
		this.kitchen = kitchen;
	}

	private void waitForCustomerRequest()
	{
		synchronized (ApnaRestaurant.requests)
		{
			while (true)
			{
				try {
					currentRequest = ApnaRestaurant.requests.take();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}

				// If we have a request we need not wait
				if (currentRequest != null)
				{
					break;
				}

				// If there are no customers in the bar
				if (ApnaRestaurant.numCustomersInRestaurant.get() == 0)
				{
					// If we're closed we can exit.
					if (ApnaRestaurant.closed)
					{
						break;
					}
				}

				try
				{
					ApnaRestaurant.requests.wait();
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}

		if (currentRequest != null)
		{
			System.out.println(name + " has a request from "
					+ currentRequest.getCustomer().getName() + ": "
					+ currentRequest.getRequestType());
		}
	}

	private void seatCustomer()
	{
		System.out.println(name + " is seating a customer.");
	}

	private void takeOrder()
	{
		System.out.println(name + " is taking an order.");
	}

	private void serveCustomer()
	{
		
		System.out.println(name + " is waiting for order to be prepared");
		Request request = currentRequest;
		
		kitchen.prepareMeal(()->{
			System.out.println(name + " is bringing the meal");
			request.setRequestBeingHandled();
			synchronized (request) {
				request.notify();
			}
		});
		
		System.out.println(name + " will serve customer as soon as meal is prepared.");
	}

	private void getCheque()
	{
		System.out.println(name + " is getting the cheque.");
	}

	public void run()
	{
		System.out.println(name + " has shown up for work.");

		while (!ApnaRestaurant.closed
				|| ApnaRestaurant.numCustomersInRestaurant.get() > 0)
		{
			waitForCustomerRequest();

			if (currentRequest != null)
			{
				switch (currentRequest.getRequestType())
				{
					case Request.SEATING_REQUEST:
						seatCustomer();
						break;
					case Request.ORDER_REQUEST:
						takeOrder();
						break;
					case Request.SERVE_REQUEST:
						serveCustomer();
						break;
					case Request.CHEQUE_REQUEST:
						getCheque();
						break;
				}

				synchronized (currentRequest)
				{
					currentRequest.setRequestBeingHandled();
					currentRequest.notify();
				}
			}
		}

		System.out.println(name + " is going home.");
	}
}
