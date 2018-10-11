package com.cg.banking.daoservices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.util.ConnectionProvider;

public class AccountDAOImpl implements AccountDAO{
	private Connection conn = ConnectionProvider.getDBConnection();

	@Override
	public long saveAccountDetails(Account account) throws SQLException {
		try{
			conn.setAutoCommit(false);
			String sql = "insert into account (accountNo, pinNumber, accountBalance, status, accountType) values(account_sequence.nextval,pinNo_sequence.nextval,?,'Active',?)";
			PreparedStatement pstmt1 = conn.prepareStatement(sql);
			pstmt1.setFloat(1, account.getAccountBalance());
			pstmt1.setString(2, account.getAccountType());
			pstmt1.executeUpdate();
			PreparedStatement pstmt2 = conn.prepareStatement("select max(accountNo) from account");
			ResultSet rs = pstmt2.executeQuery();
			rs.next();
			long  accountNo= rs.getLong(1);
			//System.out.println(accountNo);

			sql = "insert into transaction (accountNo, transactionId, amount, transactionType) values(?, transaction_sequence.nextval,?,'Deposit')";
			PreparedStatement pstmt3 = conn.prepareStatement(sql);
			pstmt3.setLong(1,accountNo);
			pstmt3.setFloat(2, account.getAccountBalance());
			pstmt3.executeUpdate();

			sql = "insert into pinTrack (accountNo, pinNumberTry) values(?,0)";
			PreparedStatement pstmt4 = conn.prepareStatement(sql);
			pstmt4.setLong(1,accountNo);
			pstmt4.executeUpdate();
			conn.commit();
			return accountNo;
		}catch(SQLException e){
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally { conn.setAutoCommit(true); }
	}

	@Override
	public Account getDetails(long accountNo) throws SQLException {
		try{
			PreparedStatement pstmt1 = conn.prepareStatement("select * from account where accountNo="+accountNo);
			ResultSet findAccountDetailsRS = pstmt1.executeQuery();
			//System.out.println("try "+findAccountDetailsRS);

			if(findAccountDetailsRS.next()){
				int pinNumber = findAccountDetailsRS.getInt("PinNumber");
				String accountType = findAccountDetailsRS.getString("AccountType");
				float accountBalance = findAccountDetailsRS.getFloat("accountBalance");
				String status = findAccountDetailsRS.getString("status");
				Account account= new Account(pinNumber, accountType, status, accountBalance, accountNo, null);
				//System.out.println("try "+account);

				/*
				PreparedStatement pstmt2 = conn.prepareStatement("select * from transaction where accountNo="+accountNo);
				ResultSet findTransactionRS = pstmt2.executeQuery();
				findTransactionRS.next();
				int transactionId= findTransactionRS.getInt("transactionId");
				float amount= findTransactionRS.getFloat("amount");
				String transactionType= findTransactionRS.getString("transactionType");
				account.setTransaction(new Transaction(transactionId, amount, transactionType));
				 */
				return account;

			}}catch(SQLException e){
				e.printStackTrace();
			}
		return null;

	}

	@Override
	public boolean updateAccount(Account account) throws SQLException {
		try{
			long accountNo= account.getAccountNo();

			PreparedStatement pstmt1 = conn.prepareStatement("update account set  accountNo= ?, pinNumber=?, accountBalance=?, status=?, accountType=? where accountNo="+accountNo);
			pstmt1.setLong(1, account.getAccountNo());
			pstmt1.setInt(2, account.getPinNumber());
			pstmt1.setFloat(3, account.getAccountBalance());
			pstmt1.setString(4, account.getStatus());
			pstmt1.setString(5, account.getAccountType());
			int flag = pstmt1.executeUpdate();
			if (flag > 0)	return true;
			else	return false;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Account transactionEntry(Account account) throws SQLException {
		try{
			conn.setAutoCommit(false);
			String sql = "insert into transaction (accountNo, transactionId, amount, transactionType) values(?, transaction_sequence.nextval,?,?)";
			PreparedStatement pstmt3 = conn.prepareStatement(sql);
			pstmt3.setLong(1,account.getAccountNo());
			pstmt3.setFloat(2, account.getTransaction().getAmount());
			pstmt3.setString(3, account.getTransaction().getTransactionType());
			pstmt3.executeUpdate();
			conn.commit();

			PreparedStatement pstmt2 = conn.prepareStatement("select max(transactionId) from transaction");
			ResultSet rs = pstmt2.executeQuery();
			rs.next();
			int transactionId= rs.getInt(1);
			account.getTransaction().setTransactionId(transactionId);

			return  account;
		}catch(SQLException e){
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally { conn.setAutoCommit(true); }
	}

	@Override
	public List<Account> getAllAccountDetail() throws SQLException {
		ArrayList<Account> accounts= new ArrayList<Account>();
		PreparedStatement pstmt1 = conn.prepareStatement("select * from account");
		ResultSet findAccountDetailsRS = pstmt1.executeQuery();
		while(findAccountDetailsRS.next()){
			long accountNo=findAccountDetailsRS.getLong("accountNo");
			int pinNumber = findAccountDetailsRS.getInt("PinNumber");
			String accountType = findAccountDetailsRS.getString("AccountType");
			float accountBalance = findAccountDetailsRS.getFloat("accountBalance");
			String status = findAccountDetailsRS.getString("status");
			Account account= new Account(pinNumber, accountType, status, accountBalance, accountNo, null);
			accounts.add(account);
			//System.out.println("try "+account);
		}
		return accounts;
	}

	@Override
	public List<Transaction> getAccountAllTransactions(long accountNo)
			throws SQLException {
		ArrayList<Transaction> transactions= new ArrayList<Transaction>();
		PreparedStatement pstmt2 = conn.prepareStatement("select * from transaction where accountNo="+accountNo);
		ResultSet findTransactionRS = pstmt2.executeQuery();
		while(findTransactionRS.next()){
			int transactionId= findTransactionRS.getInt("transactionId");
			float amount= findTransactionRS.getFloat("amount");
			String transactionType= findTransactionRS.getString("transactionType");
			Transaction transaction= new Transaction(transactionId, amount, transactionType);
			//System.out.println("try "+account);
			transactions.add(transaction);
		}
		
		return transactions;
	}

	@Override
	public int pinNumberTrialsUpdate(long accountNo) throws SQLException{
		try{
			conn.setAutoCommit(false);
			int pinTrials= getPinTrials(accountNo);
			//System.out.println("try10 :"+pinTrials);
			if(pinTrials == -1)
				return -1;
			int trials= pinTrials+1;
			//System.out.println("try11 :"+trials);
			PreparedStatement pstmt1 = conn.prepareStatement("update PinTrack set  pinNumbertry=? where accountNo="+accountNo);
			pstmt1.setLong(1, trials);
			int flag = pstmt1.executeUpdate();
			conn.commit();
			if (flag > 0)	
				return trials;
			else
				return -1;
		}catch(SQLException e){
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally { conn.setAutoCommit(true); }
	}

	@Override
	public int getPinTrials(long accountNo) throws SQLException{
		PreparedStatement pstmt1 = conn.prepareStatement("select * from pintrack where accountNo="+accountNo);
		ResultSet findAccountDetailsRS = pstmt1.executeQuery();
		if(findAccountDetailsRS.next()){
			int pinNumberTry = findAccountDetailsRS.getInt("PINNUMBERTRY");
			//int accno = findAccountDetailsRS.getInt("accountNo");
			//System.out.println("Pin Trials 121:" + pinNumberTry+" Acount "+accno);
			return pinNumberTry;
		}
		else
			return -1;
	}
}
