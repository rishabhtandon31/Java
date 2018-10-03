package com.cg.inheritance.beans;

public final class CEmployee extends Employee {
	private int totalHrs;
	private int variablePay;

	public CEmployee() {
		super();
	}
	
	
	
	public CEmployee(int employeeId, String firstname, String lastName,int totalHrs, int variablePay) {
		super(employeeId, firstname, lastName);
		this.totalHrs=totalHrs;
		this.variablePay=variablePay;
	}



	public int getTotalHrs() {
		return totalHrs;
	}

	public void setTotalHrs(int totalHrs) {
		this.totalHrs = totalHrs;
	}

	public int getVariablePay() {
		return variablePay;
	}

	public void setVariablePay(int variablePay) {
		this.variablePay = variablePay;
	}

	@Override
	public void calculateTotalSalary() {
		this.totalHrs=this.getTotalHrs();
		this.variablePay=this.getVariablePay();
		this.setTotalSalary(this.totalHrs*this.variablePay);
	}


}
