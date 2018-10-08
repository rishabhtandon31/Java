package com.cg.eis.pl;

import java.util.ArrayList;

import com.cg.eis.bean.Employee;
import com.cg.eis.service.EmployeeService;
import com.cg.eis.service.EmployeeServiceImpl;

public class MainClass {

	public static void main(String[] args) {
		EmployeeService employee= new EmployeeServiceImpl();
		employee.acceptEmployeeDetails(101, "Rishabh", "Senior Analyst", "Life Insurance", 1001001);
		employee.acceptEmployeeDetails(102, "Rahul", "Senior Executive", "Medical Insurance", 2001001);
		ArrayList<Employee> employees= new ArrayList<Employee>();
		employees= employee.getDetails();
		for(Employee x: employees)
			System.out.println(x.toString());
	}

}
