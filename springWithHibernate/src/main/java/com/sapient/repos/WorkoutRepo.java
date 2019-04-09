package com.sapient.repos;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sapient.entities.WorkoutCollection;

@Repository
public class WorkoutRepo {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public WorkoutCollection findWorkout(int id) {
		return entityManager.find(WorkoutCollection.class, id);
	}
	
	@Transactional
	public void addWorkout(WorkoutCollection workout) throws RuntimeException {
		entityManager.persist(workout);
		if(workout.getWorkoutTitle().equals("Cardio")) {
			throw new RuntimeException("Cardio is not for you");
		}
		
	}
	
	public ArrayList<WorkoutCollection> showAllWorkouts(){
		
		TypedQuery<WorkoutCollection> query = entityManager.createNamedQuery("SelectAllWorkout",WorkoutCollection.class);
		ArrayList<WorkoutCollection> result = (ArrayList<WorkoutCollection>) query.getResultList();
		
		return result;
	}
	
	public ArrayList<WorkoutCollection> findWorkoutByTitle(String title){
		TypedQuery<WorkoutCollection> query = entityManager.createNamedQuery("FindWorkoutByTitle",WorkoutCollection.class);
		query.setParameter("wkTitle", title);
		ArrayList<WorkoutCollection> result = (ArrayList<WorkoutCollection>) query.getResultList();
		
		return result;
	}
	
	@Transactional
	public void deleteWorkout(int id) {
		
		WorkoutCollection collection=entityManager.find(WorkoutCollection.class, id);
		entityManager.persist(collection);
		entityManager.remove(collection);
		
	}
}
