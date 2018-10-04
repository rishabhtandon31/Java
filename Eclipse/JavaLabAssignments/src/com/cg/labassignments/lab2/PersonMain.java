package com.cg.labassignments.lab2;

public class PersonMain {

	public static void main(String[] args) {
		Person person= new Person("Rishabh", "Tandon", Gender.valueOf("M"));
		System.out.println("First Name: "+person.getFirstName()+"\nLast Name: "+person.getLastName()+"\nGender: "+person.getGender());
	
		Person person2= new Person("Rahul", "Walia", Gender.valueOf("M"),"7009200640");
		System.out.println("First Name: "+person2.getFirstName()+"\nLast Name: "+person2.getLastName()+"\nGender: "+person2.getGender()+"\nMobile: "+person2.getMobile());
		
	}

}
