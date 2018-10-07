package com.cg.eis.service;

import com.cg.eis.bean.Employee;

public class EmployeeServiceImpl implements EmployeeService{

	Employee employee;
	@Override
	public int acceptEmployeeDetails(int id, String name, String designation,
			String insuranceScheme, int salary) {
		employee= new Employee(id, name, designation, insuranceScheme, salary);
		return employee.getId();
	}

	@Override
	public String getInsuranceScheme(int salary, String designation) {
		return employee.getInsuranceScheme();	
	}

	@Override
	public String toString() {
		return "EmployeeServiceImpl [employee=" + employee + "]";
	}

}
