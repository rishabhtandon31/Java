package com.cg.project.enumdemo;

public enum Month {
	
	JAN(1,"Jan"),
	FEB(2,"Feb"),
	MARCH(3,"March"),
	APRIL(4,"April"),
	MAY(5,"May");
	
	private Month() {
	}

	private Month(int monthIndex, String monthName) {
		this.monthIndex = monthIndex;
		this.monthName = monthName;
	}
	
	public int getMonthIndex() {
		return monthIndex;
	}
	public String getMonthName() {
		return monthName;
	}

	private int monthIndex;
	private String monthName;
}
