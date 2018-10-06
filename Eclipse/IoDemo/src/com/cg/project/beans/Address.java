package com.cg.project.beans;

import java.io.Serializable;

public class Address implements Serializable{
	private String city;
	private String country;
	private int pincode;
	public Address() {
		super();
	}
	public Address(String city, String country, int pincode) {
		super();
		this.city = city;
		this.country = country;
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", country=" + country + ", pincode="
				+ pincode + "]";
	}
	
}
