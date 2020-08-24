package com.capg.Jpa_Assignment.Service;

import java.util.List;

import com.capg.Jpa_Assignment.beans.Account;
import com.capg.Jpa_Assignment.beans.Loan;
import com.capg.Jpa_Assignment.beans.Transaction;

public class ServiceImpl implements IService{

	public boolean AccountIdValidation(String id) {
		// TODO Auto-generated method stub
		String regId = "^[0-9]{7}[A-Za-z]{4}$";
		return id.matches(regId);
	}

	public boolean AccountNameValidation(String name) {
		// TODO Auto-generated method stub
		String regName = "^[A-Z]{1}[a-z]{2,30}$";
		return name.matches(regName);
	}

	

}
