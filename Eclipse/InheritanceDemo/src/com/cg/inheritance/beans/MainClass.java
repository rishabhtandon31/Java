package com.cg.inheritance.beans;

public class MainClass {

	public static void main(String[] args) {
		Employee emp;
		//Employee employee= new Employee(101, "Rishabh", "Tandon", 15000);
		//employee.calculateTotalSalary();
		//String empData=employee.toString();
		//System.out.println(empData);


		emp=new PEmployee(101, "Rishabh", "Tandon", 20000);
		emp.calculateTotalSalary();
		System.out.println(emp);

		emp= new CEmployee(1001, "Sahil", "Verma", 7, 1400);
		//System.out.println(emp.getFirstname());
		CEmployee cemp= (CEmployee)emp;
		cemp.calculateTotalSalary();
		System.out.println(cemp);
	}

}
