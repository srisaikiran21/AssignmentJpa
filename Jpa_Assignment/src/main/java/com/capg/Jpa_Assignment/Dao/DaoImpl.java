package com.capg.Jpa_Assignment.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capg.Jpa_Assignment.beans.Account;
import com.capg.Jpa_Assignment.beans.Loan;
import com.capg.Jpa_Assignment.beans.Transaction;
import com.capg.Jpa_Assignment.beans.TransactionType;



public class DaoImpl implements IDao{
	
	private static EntityManagerFactory emf=Persistence.createEntityManagerFactory("JpaProject");
	private static EntityManager e=emf.createEntityManager();
	
	
 
	public void createAccount(Account a) {
		// TODO Auto-generated method stub
		e.getTransaction().begin();
		e.persist(a);
		e.getTransaction().commit();
		
	}
	public void createLoanAccount(Loan l) {
		// TODO Auto-generated method stub
		e.getTransaction().begin();
		e.persist(l);
		e.getTransaction().commit();
		
	}
	
	public Account getAccountDetails(String accountId) {
		// TODO Auto-generated method stub
		return e.find(Account.class, accountId);
	}
	
	
	
	public Loan getLoanDetails(String accountId) {
		// TODO Auto-generated method stub
		return e.find(Loan.class, accountId);
	}
	
	public double depositAmount(String accountId, double amount) 
	{
		// TODO Auto-generated method stub
		Account a = e.find(Account.class, accountId);
		
		if(a!=null) {
		System.out.println("before update : "+a.getDepositAmount());
		
		double temp = a.getDepositAmount()+amount;
		e.getTransaction().begin();
		a.setDepositAmount(a.getDepositAmount()+amount);
		e.getTransaction().commit();
		
		Transaction t = new Transaction( a, amount, TransactionType.Account_CREDIT);
		e.getTransaction().begin();
		e.persist(t);
		e.getTransaction().commit();
		
		return temp;
		}
		
		else 
		{
			System.out.println("Invalid account num");
			return 0;
		}
	

	}
	public double withdrawAmount(String accountId, double amount) 
	
	{
		// TODO Auto-generated method stub
		
Account a = e.find(Account.class, accountId);
		
		if(a!=null) {
		System.out.println("before update : "+a.getDepositAmount());
		
		e.getTransaction().begin();
		double d = a.getDepositAmount()-amount;
		a.setDepositAmount(a.getDepositAmount()-amount);
		e.getTransaction().commit();
		
		Transaction t = new Transaction(a, amount, TransactionType.Account_DEBIT);
		
		
		e.getTransaction().begin();
		e.persist(t);
		e.getTransaction().commit();
		
		return d;
		}
		
		else 
		{
			System.out.println("Invalid account num");
			return 0;
		}
	
	
	}
	public double payLoan(String accountId, double amount) 
	{
		// TODO Auto-generated method stub
		double updatedAmount = 0;
		Loan l = e.find(Loan.class, accountId);
		
		if(l!=null) {
		
		e.getTransaction().begin();
		updatedAmount = l.getLoanAmount()-amount;
		l.setLoanAmount(l.getLoanAmount()-amount);
		e.getTransaction().commit();
		
		
		Transaction tran = new Transaction( l, amount, TransactionType.LOAN_DEBIT);
		
		e.getTransaction().begin();
		e.persist(tran);
		e.getTransaction().commit();
		
		return updatedAmount;
		}
		else 
		{
			System.out.println("This "+accountId+" num does not have any record of loan ");
			return updatedAmount;
		}
		
	}
	public double getLoan(String loanId, double amount) {
		// TODO Auto-generated method stub
		
		double updatedAmount = 0;
		Loan l = e.find(Loan.class, loanId);
		if(l!=null) 
		{
			e.getTransaction().begin();
			updatedAmount = l.getLoanAmount()+amount;
			l.setLoanAmount(l.getLoanAmount()+amount);
			e.getTransaction().commit();
			
			Transaction t = new Transaction( l, amount, TransactionType.LOAN_CREDIT);
			e.getTransaction().begin();
			e.persist(t);
			e.getTransaction().commit();
			return updatedAmount;
		}
		else 
		{
			System.out.println("This "+loanId+" num does not have any record of loan ");
			return updatedAmount;
		}
		
	}
	public List<Transaction> getTransactionDetails(String accountId) {
		// TODO Auto-generated method stub
        e.getTransaction().begin();

		Query q = e.createQuery("select i from transaction i");
		@SuppressWarnings("unchecked")
		List<Transaction> t= (List<Transaction>)q.getResultList();
		
		e.getTransaction().commit();
		return t;
	}
	
	
	
}
		

