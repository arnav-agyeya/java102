package com.myapp.prototype;

public class Movie extends Item {
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Movie(double price) {
		super(price);
		// TODO Auto-generated constructor stub
	}



	private String runtime;

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Movie [runtime=");
		builder.append(runtime);
		builder.append(", getTitle()=");
		builder.append(getTitle());
		builder.append(", getName()=");
		builder.append(getName());
		builder.append(", getPrice()=");
		builder.append(getPrice());
		builder.append("]");
		return builder.toString();
	}
	
	
	@Override
	protected Movie clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (Movie)super.clone();
	}
	
	
	

}
