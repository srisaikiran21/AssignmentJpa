package com.capg.Jpa_Assignment;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;


import com.capg.Jpa_Assignment.Dao.DaoImpl;
import com.capg.Jpa_Assignment.Dao.IDao;
import com.capg.Jpa_Assignment.Service.IService;
import com.capg.Jpa_Assignment.Service.ServiceImpl;
import com.capg.Jpa_Assignment.beans.Account;
import com.capg.Jpa_Assignment.beans.Address;
import com.capg.Jpa_Assignment.beans.Loan;
import com.capg.Jpa_Assignment.beans.LoanType;
import com.capg.Jpa_Assignment.beans.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
	static IService service;
	
    public static void main( String[] args ) throws IOException
    {
    	Account a;
    	Loan l;
    	
    	
        Scanner scanner = new Scanner(System.in);
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			
			System.out.println("Choose any one");
			System.out.println("Enter 1 for Create account");
			System.out.println("Enter 2 for Deposit");
			System.out.println("Enter 3 for Withdraw");
			System.out.println("Enter 4 for ShowAccountDetails");
			System.out.println("Enter 5 for GetLoan");
			System.out.println("Enter 6 for PayLoan");
			System.out.println("Enter 7 for ShowLoanDetails");
			System.out.println("Enter 8 for ShowTransactionDetails");
			System.out.println("Enter 9 Exit");
			
			service = new ServiceImpl();
			IDao dao = new DaoImpl();
			
			switch(scanner.nextInt()) {
			case 1 :
					a = new Account();
					while(true) {
					System.out.println("Enter account Id");
					String accId = scanner.next();
					if(service.AccountIdValidation(accId)) {						
						a.setAccId(accId);
						break;
						}else {
							System.out.println("Entered account number is invalid");
							return;
						}
					}
					while(true) {
						System.out.println("Enter user name");
						String username = scanner.next();
						if(service.AccountNameValidation(username)) {				
							a.setAccName(username);
							break;
						}else {
							System.out.println("Entered Name is not in valid format");
							return;	
						}
					}
					
					
Address address = new Address();
					
		    System.out.println("Enter address: ");
	        System.out.println("Enter address line1 : ");				
		    address.setAddressLine(b.readLine());
			System.out.println("Enter City ");
					address.setCity( scanner.next());
					System.out.println("Enter State ");
					address.setState(b.readLine());
					
					a.setAddress(address);
					
					System.out.println("Enter deposit amount : ");
					a.setDepositAmount(scanner.nextDouble());
					
					System.out.println("Do u want to enter loan details :");
					System.out.println("If 'Yes' for press 1 and 'No' for press 2");
					if(scanner.nextInt()==1) 
					{
						l = new Loan();
						System.out.println("Enter loan id");
						l.setLoanId(scanner.next());
						System.out.println("Enter loantype (Car,Home,Education)");
						l.setLoanType(LoanType.valueOf(scanner.next()));
						System.out.println("Enter loan amount : ");
						l.setLoanAmount(scanner.nextDouble());
						l.setAccId(a.getAccId());
						l.setAccName(a.getAccName());
						l.setDepositAmount(a.getDepositAmount());
						l.setAddress(a.getAddress());
						dao.createLoanAccount(l);
						break;
					}
					else 
					{
						dao.createAccount(a);
						break;
					}
					
					
			case 2 :
				System.out.println("Enter account Id : ");
				String accountId = scanner.next();
				System.out.println("Enter amount : ");
				double amount = scanner.nextDouble();
				double nAmount = dao.depositAmount(accountId, amount);
				
				System.out.println("updated balance : "+nAmount);
				break;
		case 3 :
				System.out.println("Enter account Id : ");
				String accounId = scanner.next();
				System.out.println("Enter amount : ");
				double amountt = scanner.nextDouble();
				double nAmountt = dao.withdrawAmount(accounId, amountt);
				
				System.out.println("updated balance : "+nAmountt);
				break;
		case 4 :
				System.out.println("Enter account Id : ");
				Account account = dao.getAccountDetails(scanner.next());
				if(account!=null) {
				System.out.println("Account id = "+account.getAccId());
				System.out.println("Account Holder Name = "+account.getAccName());
				System.out.println("Address = [ address line 1 : "+account.getAddress().getAddressLine()+" , city : "+account.getAddress().getCity()+" , state : "+account.getAddress().getState()+" ]");
				System.out.println("Account Deposit : "+account.getDepositAmount());
				break;
				}else {
					System.out.println("No Account Record Found!!!");
					System.out.println("Check account no.");
					break;
				}
		case 5 :
			System.out.println("Enter account Id : ");
			String getLoanId = scanner.next();
			System.out.println("Enter pay amount : ");
			double getAmount = scanner.nextDouble();
					
			double updAmount = dao.getLoan(getLoanId, getAmount);
			System.out.println("Updated loan amount : "+updAmount);
			break;
					
		case 6 :
				System.out.println("Enter account Id : ");
				String accId = scanner.next();
				System.out.println("Enter amount : ");
				double amt = scanner.nextDouble();
				
				double newAmount = dao.payLoan(accId, amt);
				System.out.println("Updated loan amount : "+newAmount);
				break;	
		case 7 :
				System.out.println("Enter account Id : ");
				Loan loanDetails = dao.getLoanDetails(scanner.next());
				if(loanDetails!=null) {
					System.out.println("Account Id : "+loanDetails.getAccId());
					System.out.println("Loan Id : "+loanDetails.getLoanId());
					System.out.println("Loan type : "+loanDetails.getLoanType());
					System.out.println("Loan amount : "+loanDetails.getLoanAmount());
					System.out.println();
					break;
				}else
				{
					System.out.println("Loan record not Found");
					break;
				}
				
		case 8 :
				System.out.println("Enter account number ");
				List<Transaction> tran = dao.getTransactionDetails(scanner.next());
				
				if(tran!=null) {
					for(Transaction t : tran) {
					System.out.println("Transaction Id = "+t.getTransactionId());
					System.out.println("Transaction amt = "+t.getTransactionAmount());
					System.out.println("Transaction type = "+t.getTransactionType());
					System.out.println("Transaction Account Id = "+t.getAccountId());
					System.out.println();
					}
					break;
				}
				else 
				{
					System.out.println("Invalid Account Id");
					break;
				}
		case 9 :
				System.out.println("Thank you");
				scanner.close();
				b.close();
				break;
		default :
				System.out.println("Invalid choice ");
				break;
		}

    }
}
    }

