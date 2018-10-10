package com.cg.banking.services;
import java.sql.SQLException;
import java.util.List;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.daoservices.AccountDAO;
import com.cg.banking.daoservices.AccountDAOImpl;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;

public class BankingServicesImpl implements BankingServices {

	private AccountDAO accountDAO= new AccountDAOImpl();
	@Override
	public long openAccount(String accountType, float initBalance)
			throws InvalidAmountException, InvalidAccountTypeException, BankingServicesDownException {
		try {
			if(!(accountType.equalsIgnoreCase("Savings") || accountType.equalsIgnoreCase("Current")))
				throw new InvalidAccountTypeException("Account type is not valid. Choose only Savings or Current");
			if(initBalance <1000)
				throw new InvalidAmountException("Balance should be more than 1000Rs. !!!");
			else{
				Account account= new Account(accountType, initBalance);
				long accountNo;
				accountNo=accountDAO.saveAccountDetails(account);
				if (accountNo==0)
					throw new BankingServicesDownException("Servers ae down! try again after some time");
				return accountNo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BankingServicesDownException("Server is down. Please try again later");
		}
	}

	@Override
	public float depositAmount(long accountNo,float amount)
			throws AccountNotFoundException, BankingServicesDownException, AccountBlockedException {

		try {
			Account account = accountDAO.getDetails(accountNo);
			System.out.println(account);
			account.getTransaction().setAmount(amount);
			//account.getTransaction().setAmount(amount);
			account.getTransaction().setTransactionType("Deposit");
			account= accountDAO.transactionEntry(account);
			account.setAccountBalance(account.getAccountBalance() + amount);
			boolean updateAccount= accountDAO.updateAccount(account);
			if(updateAccount)
				return account.getTransaction().getAmount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public float withdrawAmount(long accountNo, float amount, int pinNumber) throws InsufficientAmountException,
	AccountNotFoundException, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean fundTransfer(long accountNoTo, long accountNoFrom, float transferAmount, int pinNumber)
			throws InsufficientAmountException, AccountNotFoundException, InvalidPinNumberException,
			BankingServicesDownException, AccountBlockedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account getAccountDetails(long accountNo) throws AccountNotFoundException, BankingServicesDownException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getAllAccountDetails() throws BankingServicesDownException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> getAccountAllTransaction(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String accountStatus(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException, AccountBlockedException {
		// TODO Auto-generated method stub
		return null;
	}

}
