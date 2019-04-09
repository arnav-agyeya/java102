package com.sapient;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sapient.entities.WorkoutCollection;
import com.sapient.repos.WorkoutRepo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestWorkout {
	
	@Autowired
	private WorkoutRepo repo;
	
	@Test
	public void addWorkoutTest() {
		WorkoutCollection coll = new WorkoutCollection("Cardio", 1000.32, "needs to be done in the morning");
		
			try {
				repo.addWorkout(coll);
			} catch (RuntimeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
	
	@Test
	public void findWorkoutTest() {
		
		WorkoutCollection coll = repo.findWorkout(8);
		assertEquals("Successful","Aerobics" , coll.getWorkoutTitle());
	}
	
	@Test
	public void showAllWorkoutTest() {
		System.out.println(repo.showAllWorkouts());;
	}
	
	@Test
	public void findWorkoutWithTitle() {
		repo.findWorkoutByTitle("Cardio");
	}
	
	@Test
	public void deleteWorkoutTest() {
		repo.deleteWorkout(1);
	}

}
