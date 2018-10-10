package com.cg.banking.main;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.services.BankingServices;
import com.cg.banking.services.BankingServicesImpl;

public class MainClass {
	public static void main(String[] args)  {
		try {
			BankingServices bankServices= new BankingServicesImpl();
			long account1;
			//account1 = bankServices.openAccount("Savings", 2000);
			float amount= bankServices.depositAmount(112233003	, 5000);
			System.out.println("Transaction successful "+amount);
		} catch (BankingServicesDownException e) {
			e.printStackTrace();
		} catch (AccountNotFoundException e) {
			e.printStackTrace();
		} catch (AccountBlockedException e) {
			e.printStackTrace();
		}
		
	}
}
