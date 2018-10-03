package com.cg.payroll.beans;

public class BankDetails {
	private double accountNumber;
	private String bankName, ifscCode;
	
	public BankDetails() {
		super();
	}
	
	public BankDetails(double accountNumber, String bankName, String ifscCode) {
		super();
		this.accountNumber = accountNumber;
		this.bankName = bankName;
		this.ifscCode = ifscCode;
	}
	
	public double getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(double accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public String getIfscCode() {
		return ifscCode;
	}
	
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
}
