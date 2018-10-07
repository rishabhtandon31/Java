package com.cg.labassignments.lab4;

public class MainPerson {

	public static void main(String[] args) {
		/*Account person1= new Account(2000, new Person("Smith", 22));
		Account person2= new Account(3000, new Person("Kathy", 20));
		person1.deposit(2000);
		person2.withdraw(2000);
		System.out.println(person1);
		System.out.println(person2);
		*/
		SavingsAccount person1= new SavingsAccount(2000, new  Person("Smith", 22)); 
		CurrentAccount person2= new CurrentAccount(3000, new Person("Kathy", 20));
		person1.deposit(2000);
		person2.withdraw(2000);
		System.out.println(person1);
		System.out.println(person2);
		
	}

}
