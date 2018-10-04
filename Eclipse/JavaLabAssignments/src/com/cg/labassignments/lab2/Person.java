package com.cg.labassignments.lab2;

public class Person {

	private String firstName;
	private String lastName;
	private Gender gender;
	private String mobile;
	
	public Person() {
		super();
	}

	public Person(String firstName, String lastName, Gender gender,
			String mobile) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.setMobile(mobile);
	}

	public Person(String firstName, String lastName, Gender gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile2) {
		this.mobile = mobile2;
	}
	
	
}
