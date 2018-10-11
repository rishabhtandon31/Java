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
	static int pinNumberTry=0;
	//private static HashMap<Long, Integer> pinNumberTrack= new HashMap<Long, Integer>();
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
			if(account == null) throw new AccountNotFoundException("Account details not found. Enter your account no. again");
			//if(account.getStatus().equalsIgnoreCase("Locked")) throw new AccountBlockedException("Your Account Blocked!!");
			account.setTransaction(new Transaction(amount, "Savings"));
			//System.out.println("bankImpl "+account);
			account= accountDAO.transactionEntry(account);
			account.setAccountBalance(account.getAccountBalance() + amount);
			//System.out.println("hey2 "+account);
			boolean updateAccount= accountDAO.updateAccount(account);
			//System.out.println(updateAccount);
			if(updateAccount)
				return account.getAccountBalance();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public float withdrawAmount(long accountNo, float amount, int pinNumber) throws InsufficientAmountException,
	AccountNotFoundException, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException {
		Account account;
		try {
			account = accountDAO.getDetails(accountNo);
			if(account == null) throw new AccountNotFoundException("Account details not found. Enter your account no. again");
			if(account.getStatus().equalsIgnoreCase("Locked")) throw new AccountBlockedException("Your Account Blocked!!");
			pinNumberTry= accountDAO.getPinTrials(accountNo);
			//System.out.println("pin trials "+pinNumberTry);
			if(account.getPinNumber() != pinNumber && pinNumberTry ==3){
				account.setStatus("Locked");
				accountDAO.updateAccount(account);
				throw new InvalidPinNumberException("Your account get locked...!!!");
			}

			if(account.getPinNumber() != pinNumber && pinNumberTry <3){
				pinNumberTry=accountDAO.pinNumberTrialsUpdate(accountNo);
				System.out.println("Your Pin Trials "+pinNumberTry);
				throw new InvalidPinNumberException("Wrong Pin Number. Try again !!!");
			}
			//System.out.println("pin trials "+pinNumberTry);
			if(account.getAccountBalance() - amount < 1000)
				throw new InsufficientAmountException("Insufficient Amount in your account");
			pinNumber=0;
			account.setTransaction(new Transaction(amount, "Withdraw"));
			//System.out.println("bankImpl "+account);
			account= accountDAO.transactionEntry(account);
			account.setAccountBalance(account.getAccountBalance() - amount);
			//System.out.println("hey2 "+account);
			boolean updateAccount= accountDAO.updateAccount(account);
			//System.out.println(updateAccount);

			if(updateAccount)
				return account.getAccountBalance();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean fundTransfer(long accountNoTo, long accountNoFrom, float transferAmount, int pinNumber)
			throws InsufficientAmountException, AccountNotFoundException, InvalidPinNumberException,
			BankingServicesDownException, AccountBlockedException {
		try {
			Account account;
			account = accountDAO.getDetails(accountNoTo);
			if(account == null) throw new AccountNotFoundException("Wrong account number. Enter the recepient account number again!!!");
			account = accountDAO.getDetails(accountNoFrom);
			if(account==null) throw new AccountNotFoundException("Wrong account number. Enter the your account number again!!!");
			withdrawAmount(accountNoFrom, transferAmount, pinNumber);
			depositAmount(accountNoTo, transferAmount);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Account getAccountDetails(long accountNo) throws AccountNotFoundException, BankingServicesDownException {
		Account account;
		try {
			account = accountDAO.getDetails(accountNo);
			if(account == null) throw new AccountNotFoundException("Account not found!!!");
			return account;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AccountNotFoundException("Account not found!!!");
		}
	}

	@Override
	public List<Account> getAllAccountDetails() throws BankingServicesDownException {
		try{
			List<Account> accounts= accountDAO.getAllAccountDetail();
			return accounts;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new BankingServicesDownException("Servers are down. Try gain after sometime.");
		}
	}

	@Override
	public List<Transaction> getAccountAllTransaction(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException {
		try{
			List<Transaction> transactions= accountDAO.getAccountAllTransactions(accountNo);
			if(transactions.isEmpty())
				throw new AccountNotFoundException("Account Not Found. Try again!!!");
			return transactions;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new BankingServicesDownException("Servers are down. Try gain after sometime.");
		}
	}

	@Override
	public String accountStatus(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException, AccountBlockedException {
		try {
			Account account = accountDAO.getDetails(accountNo);
			if(account==null) throw new AccountNotFoundException("Account Not Found. Please Try Again!!!");
			return account.getStatus();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AccountNotFoundException("Account not found!!!");
		}
	}

}
