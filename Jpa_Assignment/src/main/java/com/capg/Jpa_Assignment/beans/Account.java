package com.capg.Jpa_Assignment.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;



@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Account {
	
	@Id
	private String accId;
	@Column(nullable = false,length = 30)
	private String accName;
	@Column(nullable = false)
	private double depositAmount;
	@Embedded
	private Address address;
	
	@OneToMany(mappedBy = "accountId")
	private List<Transaction> transaction;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String accId, String accName, double depositAmount, Address address) {
		super();
		this.accId = accId;
		this.accName = accName;
		this.depositAmount = depositAmount;
		this.address = address;
	}

	public List<Transaction> getTransaction() {
		return transaction;
	}

	
	public String getAccId() {
		return accId;
	}
	

	public void setAccId(String accId) {
		this.accId = accId;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
