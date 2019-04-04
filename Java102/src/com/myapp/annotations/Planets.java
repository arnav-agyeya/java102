package com.myapp.annotations;

public enum Planets {
	
	EARTH(6.2e92,3.2e2),
	MARS(4.3e12,1.2e2),
	JUPITER(3.2e92,1.0e2),
	VENUS(0.2e92,0.112e2);
	private final double mass,radius;
	private Planets(double mass,double radius){
		this.mass=mass;
		this.radius=radius;
	}
	public final double getMass(){
		return mass;
	}
	public final double getRadius(){
		return radius;
	}	
	public double density(){
		return Math.PI*mass/(radius*radius);
	}
}