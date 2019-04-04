package com.myapp.annotations;

public enum Season {
	
	WINTER("OCTOBER","FEBRUARY"),
	SPRING("MARCH","APRIL"),
	SUMMER("MAY","SEPTEMBER");
	
	private String startMonth,endMonth;
	
	private Season(String startMonth,String endMonth) {
		this.startMonth=startMonth;
		this.endMonth=endMonth;
		
	}

	public String getStartMonth() {
		return startMonth;
	}

	public String getEndMonth() {
		return endMonth;
	}
	
	

}
