package com.capg.Jpa_Assignment.Service;

import java.util.List;

import com.capg.Jpa_Assignment.beans.Account;
import com.capg.Jpa_Assignment.beans.Loan;
import com.capg.Jpa_Assignment.beans.Transaction;



public interface IService {
	
	
	public boolean AccountIdValidation(String id);

	public boolean AccountNameValidation(String name);
	
	
}
