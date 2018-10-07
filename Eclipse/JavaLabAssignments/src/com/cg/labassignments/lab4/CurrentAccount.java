package com.cg.labassignments.lab4;

public class CurrentAccount extends Account{

	private final double overDraftLimit= 5000;
	
	public CurrentAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CurrentAccount(double balance, Person accHolder) {
		super(balance, accHolder);
		// TODO Auto-generated constructor stub
	}

	public CurrentAccount(long accNum, double balance, Person accHolder) {
		super(accNum, balance, accHolder);
		// TODO Auto-generated constructor stub
	}

	public void withdraw(double amount){
		if((getBalance()- amount) <0 && Math.abs((getBalance()- amount)) > this.overDraftLimit )
			System.out.println("Over Draft Limit crossed");
		else
			setBalance(getBalance()-amount);
	}
}
