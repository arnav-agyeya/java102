package com.myapp.java8;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.myapp.io.Orders;

public class TestTreeSer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//	Set<Orders> set=new TreeSet<>(new OrdersComparator());
		
//		Set<Orders> set=new TreeSet<>(
//		(Orders o1, Orders o2)->((Double)o1.getOrderprice()).compareTo(o2.getOrderprice()));
//	
		Comparator<Orders> c1= new Comparator<Orders>() {
		public int compare(Orders o1, Orders o2) {
			return	((Double)o1.getOrderprice()).compareTo(o2.getOrderprice());
		};
		};
		
	Comparator<Orders> c=	
	(o1, o2)->((Double)o1.getOrderprice()).compareTo(o2.getOrderprice());
		
		Set<Orders> set=new TreeSet<>(c);
			
		set.add(new Orders(1,"Order1",8999));
		set.add(new Orders(4,"Order4",3999));
		set.add(new Orders(3,"Order3",4999));
		set.add(new Orders(2,"Order2",5999));
		
		
//		set.stream().filter(o->o.getOrderprice()>5000.00)
//		.forEach(System.out::println);
		
		Optional<Orders> opt=set.stream().filter(o->o.getOrderprice()>5000.00)
		.min(Comparator.comparingDouble(Orders::getOrderprice));
		
		Optional<Orders> opt2=set.stream()
				.max(Comparator.comparing(Orders::getOrderprice));
		
		
		
		System.out.println(opt.get());
		System.out.println(opt2.get());
		
		
		Map<Double,String> map=
		set.stream().collect(Collectors.groupingBy
				((Orders o)->o.getOrderprice(),
	Collectors.mapping(Orders::getOrdername, Collectors.joining(", "))));
		System.out.println(map.getClass().getSimpleName());
		
		
		//System.out.println(set);
		
		
		

	}

}
