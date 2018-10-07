package com.cg.labassignments.lab4;
public class SavingsAccount extends Account{
	private final double minimumBalance=500;
	
	public SavingsAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SavingsAccount(double balance, Person accHolder) {
		super(balance, accHolder);
		// TODO Auto-generated constructor stub
	}

	public SavingsAccount(long accNum, double balance, Person accHolder) {
		super(accNum, balance, accHolder);
		// TODO Auto-generated constructor stub
	}

	public void withdraw(double amount){
		if((getBalance()-amount)<this.minimumBalance)
			System.out.println("Error!! The total amount is less than the minimum balance.");
		else
			setBalance(getBalance()-amount);
	}

	
	
}
