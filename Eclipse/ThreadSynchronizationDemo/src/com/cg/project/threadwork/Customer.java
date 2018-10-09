package com.cg.project.threadwork;
import com.cg.project.beans.Account;
public class Customer implements Runnable {
	public Customer() {}
	private static Account account;
	static {
		account = new Account(10000);
		System.out.println("Initial Balance 	:-	" + account.getBalance()
		+ "\n\n==========================");
	}


	@Override
	public void run() {

		Thread customerThread = Thread.currentThread();

		if (customerThread.getName().equals("rahul")) {
			for (int i = 1; i <= 10; i++) {
				try {
					System.out.println("\nRahul  has call  withdraw()	" + i
							+ "	time  balance := " + account.withdraw(3000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			}
		}
		else if (customerThread.getName().equals("anil")) {
			for (int i = 1; i <= 10; i++) {
				try {
					System.out.println("\nAnil has call deposit()	" + i
							+ "	time balance :=  " + account.deposit(2000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else if (customerThread.getName().equals("satish")) {
			for (int i = 1; i <= 3; i++) {
				System.out.println("\nSatish has call checkBalance()	" + i
						+ "	time balance := " + account.getBalance());
			}
		}
	}
}




