package com.cg.labassignments.lab4;

public class Account {
	private long accNum=11223344;
	private int count=1;
	private double balance;
	private Person accHolder;
	public Account() {
		super();
	}
	public Account(long accNum, double balance, Person accHolder) {
		super();
		this.accNum = accNum;
		this.balance = balance;
		this.accHolder = accHolder;
	}
	
	public Account(double balance, Person accHolder) {
		super();
		this.accNum = accNum+(this.count++);
		this.balance = balance;
		this.accHolder = accHolder;
	}
	public long getAccNum() {
		return accNum;
	}
	public void setAccNum(long accNum) {
		this.accNum = accNum;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Person getAccHolder() {
		return accHolder;
	}
	public void setAccHolder(Person accHolder) {
		this.accHolder = accHolder;
	}
	public void deposit(double amount){
		setBalance(this.balance + amount);
	}
	public void withdraw(double amount){
		setBalance(this.balance - amount);
	}
	@Override
	public String toString() {
		return "Account [accNum=" + accNum + ", count=" + count + ", balance="
				+ balance + ", accHolder=" + accHolder + "]";
	}
	
}
