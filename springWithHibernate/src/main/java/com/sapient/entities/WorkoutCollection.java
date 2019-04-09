package com.sapient.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@Table(name="WORKOUT_COLLECTION")
@NamedQueries({
	@NamedQuery(name="SelectAllWorkout",query="Select w from WorkoutCollection w"),
	@NamedQuery(name="FindWorkoutByTitle",query="Select w from WorkoutCollection w where w.workoutTitle=:wkTitle")
})
public class WorkoutCollection {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="WORKOUT_ID")
	private int workoutId;
	
	@Column(name="WORKOUT_TITLE")
	private String workoutTitle;
	
	@Column(name="CALORIES_BURN_PER_MIN")
	private double caloriesBurnPerMin;
	
	@Column(name="WORKOUT_NOTE")
	private String workoutNote;

	public WorkoutCollection(String workoutTitle, double caloriesBurnPerMin, String workoutNote) {
		super();
		this.workoutTitle = workoutTitle;
		this.caloriesBurnPerMin = caloriesBurnPerMin;
		this.workoutNote = workoutNote;
	}
	
	
	
}
