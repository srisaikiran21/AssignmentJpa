package com.capg.Jpa_Assignment.Dao;

import java.util.List;


import com.capg.Jpa_Assignment.beans.Account;
import com.capg.Jpa_Assignment.beans.Loan;
import com.capg.Jpa_Assignment.beans.Transaction;

public interface IDao {
	public void createAccount(Account a);
	public void createLoanAccount(Loan l);
	public Account getAccountDetails(String accountId);
	
	public Loan getLoanDetails(String accountId);
	public double depositAmount(String accountId, double amount);
	
	public double withdrawAmount(String accountId,double amount);
	
	public double payLoan(String accountId,double amount);
	public double getLoan(String loanId,double amount);
	
	public List<Transaction> getTransactionDetails(String accountId);
	
}
