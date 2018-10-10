package com.cg.banking.daoservices;

import java.sql.SQLException;

import com.cg.banking.beans.Account;

public interface AccountDAO {
	long saveAccountDetails(Account account) throws SQLException;
	Account getDetails(long accountNo) throws SQLException;
	boolean updateAccount(Account account) throws SQLException;
	Account transactionEntry(Account account) throws SQLException;
}