package com.cg.project.beans;

import java.io.Serializable;

public class Associate implements Serializable {
	private int associateId;
	private String name;
	private int salary;
	private Address address;
	public Associate() {
		super();
	}
	
	public Associate(int associateId, String name, int salary, Address address) {
		super();
		this.associateId = associateId;
		this.name = name;
		this.salary = salary;
		this.address = address;
	}

	public Associate(int associateId, String name, int salary) {
		super();
		this.associateId = associateId;
		this.name = name;
		this.salary = salary;
	}
	public int getAssociateId() {
		return associateId;
	}
	public void setAssociateId(int associateId) {
		this.associateId = associateId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Associate [associateId=" + associateId + ", name=" + name
				+ ", salary=" + salary + "]"+ address.toString();
	}
	
}
