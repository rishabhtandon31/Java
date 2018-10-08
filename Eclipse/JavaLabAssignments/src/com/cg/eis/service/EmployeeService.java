package com.cg.eis.service;

import java.util.ArrayList;

import com.cg.eis.bean.Employee;

public interface EmployeeService {
	void acceptEmployeeDetails(int id, String name, String designation, String insuranceScheme,
			int salary);
	String getInsuranceScheme(int salary, String designation);
	ArrayList<Employee> getDetails();
}
