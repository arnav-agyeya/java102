package com.airline.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.airline.entity.Airlines;
import com.airline.entity.Flights;




public class CollectorsExample {

public List<Flights> search(String source,String destination) {
List<Flights> persons = new ArrayList<>();

try (Stream<String> stream = Files.lines(Paths.get("C:\\\\Users\\\\arnagyey\\\\eclipse-workspace\\\\AirLineBooking\\\\src\\\\SpiceJet_Flights.csv"))) {

stream.map(line -> {
String[] s = line.split(",");
Flights p = new Flights( Integer.parseInt(s[0]),s[1],s[2],
Integer.parseInt(s[3]),Integer.parseInt(s[4]),Airlines.SJ);
persons.add(p);
return p;
}).collect(Collectors.toList());




} catch (IOException ioe) {
System.out.println(ioe);
}
Comparator<Flights> compareByName = Comparator
.comparing(Flights::getTime)
.thenComparing(Flights::getFare);
return persons.stream().filter(f-> f.getSource().equalsIgnoreCase(source) && 
f.getDestination().equals(destination))
.sorted(compareByName).collect(Collectors.toList());



}

public static void main(String[] args) {

CollectorsExample inst1=new CollectorsExample();

Runnable r1=()->
System.out.println(inst1.search("Delhi", "Udaipur"));

Runnable r2=()->
System.out.println(inst1.search("Delhi", "Bangalore"));

List<Runnable> list=new ArrayList<>();
list.add(r1);
list.add(r2);

ExecutorService pool=Executors.newFixedThreadPool(2);
for(Runnable task:list)
pool.execute(task);

pool.shutdown();

//	Runnable r=()->
//	System.out.println(inst1.search("Delhi", "Udaipur"));


}



}