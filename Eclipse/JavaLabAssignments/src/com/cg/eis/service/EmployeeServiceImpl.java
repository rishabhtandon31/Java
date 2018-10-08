package com.cg.eis.service;

import java.util.ArrayList;

import com.cg.eis.bean.Employee;

public class EmployeeServiceImpl implements EmployeeService{

	Employee employee;
	ArrayList<Employee> employees = new ArrayList<Employee>(); 
	@Override
	public void acceptEmployeeDetails(int id, String name, String designation,
			String insuranceScheme, int salary) {
		employee= new Employee(id, name, designation, insuranceScheme, salary);
		employees.add(employee);
	}

	@Override
	public String getInsuranceScheme(int salary, String designation) {
		for(int i=0;i<employees.size();i++){
			employee= employees.get(i);
			if(employee.getSalary() == salary)
				return employee.getInsuranceScheme();
		}
		return null;
	}

	@Override
	public ArrayList<Employee> getDetails() {
		ArrayList<Employee> emp= new ArrayList<Employee>();
		for(int i=0;i<employees.size();i++){
			employee=employees.get(i);
			emp.add(employee);
		}
		return emp;
	}

	
}
