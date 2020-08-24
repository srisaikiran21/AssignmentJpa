package com.capg.Jpa_Assignment.beans;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;




@Entity
public class Loan extends Account{
	
	
	private String loanId;
	private double loanAmount;
	@Enumerated(EnumType.STRING)
	private LoanType loanType;
	

	public Loan() {
		
	}
		public Loan(String accId, String accName, double depositAmount, Address address, String loanId, double loanAmount,
				LoanType loanType) {
			super(accId, accName, depositAmount, address);
		this.loanId = loanId;
		this.loanAmount = loanAmount;
		this.loanType = loanType;
	}
	public String getLoanId() {
		return loanId;
	}
	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public LoanType getLoanType() {
		return loanType;
	}
	public void setLoanType(LoanType loanType) {
		this.loanType = loanType;
	}
}
