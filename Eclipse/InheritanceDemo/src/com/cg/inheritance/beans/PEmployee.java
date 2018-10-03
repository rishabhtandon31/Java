package com.cg.inheritance.beans;

public class PEmployee extends Employee {
	private int hra;
	private int ta;
	private int da;
	public PEmployee() {
		super();
	}
	
	
	public PEmployee(int employeeId, String firstname, String lastName,
			int basicSalary) {
		super(employeeId, firstname, lastName, basicSalary);
		
	}


	public int getHra() {
		return hra;
	}
	public void setHra(int hra) {
		this.hra = hra;
	}
	public int getTa() {
		return ta;
	}
	public void setTa(int ta) {
		this.ta = ta;
	}
	public int getDa() {
		return da;
	}
	public void setDa(int da) {
		this.da = da;
	}
	@Override
	public void calculateTotalSalary() {
		hra=(this.getBasicSalary()*10)/100;
		da=(this.getBasicSalary()*10)/100;
		ta=(this.getBasicSalary()*10)/100;
		this.setTotalSalary(this.getBasicSalary()+hra+ta+da);
		
	}


	@Override
	public String toString() {
		return super.toString()+"hra=" + hra + ", ta=" + ta + ", da=" + da;
	}
	
}
