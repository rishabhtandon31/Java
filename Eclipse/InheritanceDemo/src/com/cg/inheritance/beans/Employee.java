package com.cg.inheritance.beans;

public abstract class Employee {
	private int employeeId;
	private String firstname;
	private String lastName;
	private int basicSalary;
	private int totalSalary;

	public Employee() {
		super();
	}
	public Employee(int employeeId, String firstname, String lastName,
			int basicSalary) {
		super();
		this.employeeId = employeeId;
		this.firstname = firstname;
		this.lastName = lastName;
		this.basicSalary = basicSalary;
	}


	public Employee(int employeeId, String firstname, String lastName) {
		super();
		this.employeeId = employeeId;
		this.firstname = firstname;
		this.lastName = lastName;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(int basicSalary) {
		this.basicSalary = basicSalary;
	}
	public int getTotalSalary() {
		return totalSalary;
	}
	public void setTotalSalary(int totalSalary) {
		this.totalSalary = totalSalary;
	}
	public  void calculateTotalSalary(){
		this.totalSalary=this.basicSalary;
	}
	@Override
	public String toString() {
		return  employeeId + ", firstname="
				+ firstname + ", lastName=" + lastName + ", basicSalary="
				+ basicSalary + ", totalSalary=" + totalSalary ;
	}


}
