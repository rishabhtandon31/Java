package com.cg.banking.daoservices;

import java.sql.SQLException;
import java.util.List;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;

public interface AccountDAO {
	long saveAccountDetails(Account account) throws SQLException;
	Account getDetails(long accountNo) throws SQLException;
	boolean updateAccount(Account account) throws SQLException;
	Account transactionEntry(Account account) throws SQLException;
	List<Account> getAllAccountDetail() throws SQLException;
	List<Transaction> getAccountAllTransactions(long accountNo) throws SQLException;
	int pinNumberTrialsUpdate(long accountNo) throws SQLException;
	int getPinTrials(long accountNo) throws SQLException;
}