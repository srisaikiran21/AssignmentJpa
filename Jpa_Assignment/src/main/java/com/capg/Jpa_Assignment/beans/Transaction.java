package com.capg.Jpa_Assignment.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Transaction {
	
	@Id
	@Column(name = "transactId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	@ManyToOne
	private Account accountId;
	private double transactionAmount;
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public Account getAccountId() {
		return accountId;
	}
	public void setAccountId(Account accountId) {
		this.accountId = accountId;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public TransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	public Transaction(Account accountId, double transactionAmount, TransactionType transactionType) {
		super();
		this.accountId = accountId;
		this.transactionAmount = transactionAmount;
		this.transactionType = transactionType;
	}
	
	
	
}
