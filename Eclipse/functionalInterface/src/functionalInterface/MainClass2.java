package functionalInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class MainClass2 {

	public static void main(String[] args) {
		ArrayList<Employee> empList= new ArrayList<>();
		empList.add(new Employee(101, 150000, "Rahul"));
		empList.add(new Employee(102, 250000, "Rohit"));
		empList.add(new Employee(103, 100000, "Raj"));
		empList.add(new Employee(104, 15000, "Suraj"));
		empList.add(new Employee(105, 1500, "Sonakshi"));
		empList.add(new Employee(106, 154000, "Abhi"));
		empList.add(new Employee(107, 123000, "Sahil"));
		/* Comparator<Employee> comparatorRef= (emp1,emp2)->emp1.getSalary()- */
		
		Collections.sort(empList,(emp1,emp2)->emp1.getSalary()-emp2.getSalary());
		/*
		Stream<Employee> stream1= empList.stream();
		Stream<Employee> stream2= stream1.distinct();
		Stream<Employee> stream3= stream2.filter((employee)->employee.getName().startsWith("N"));
		System.out.println(stream3.count());
		stream3.forEach(employee->System.out.println(employee));
		*/
		
		empList.stream()
		.distinct()
		.filter(e->e.getName().startsWith("R"))
		.forEach(employee->System.out.println(employee));
		
		long count= empList.stream()
				.distinct()
				.count();
		System.out.println(count +" "+empList.size());
		
	}

}
