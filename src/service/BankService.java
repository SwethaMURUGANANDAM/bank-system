package service;
import model.Account;
import model.Transaction;
import exceptions.InsufficientBalanceException;
import java.util.HashMap;
import java.util.LinkedList;
public class BankService {
	private HashMap<String, Account> accountMap = new HashMap<>();
	private HashMap<String, LinkedList<Transaction>> transactionMap = new HashMap<>();
	public void createAccount(String accountnumber, String accountholder, double balance) {
		Account newAccount = new Account(accountnumber, accountholder, balance);
	        accountMap.put(accountnumber, newAccount);
	        transactionMap.put(accountnumber, new LinkedList<>());
	        System.out.println("account created succesfully");
	        System.out.println(newAccount);
	}
	public void deposit(String accountnumber, double amount) {
		Account acc = accountMap.get(accountnumber);
        double currentbalance = acc.getBalance();  
        if (acc == null) {
        	System.out.println(" Account not found");
        	 return;
        }
        
        acc.deposit(amount);
        transactionMap.get(accountnumber).add(new Transaction("Deposit", amount));
        System.out.println(" ₹" + amount + " deposited to " + accountnumber);
	}

public void withdraw(String accountnumber, double amount) {
	 Account account = accountMap.get(accountnumber);
	 if (account == null) {
		 System.out.println("Account not found.please  check the account number");
		 return;
	 }
	  double currentbalance = account.getBalance();
	  if (currentbalance < amount) {
		  try {
			  throw new InsufficientBalanceException(" Not enough balance to withdraw ₹" + amount);
	        } catch (InsufficientBalanceException e){
	            System.out.println(" " + e.getMessage());
	        }
		  return;
		  }
	  account.withdraw(amount);
	  LinkedList<Transaction> userTransactions = transactionMap.get(accountnumber);
	  userTransactions.add(new Transaction("Withdraw", amount));
	  System.out.println(" ₹" + amount + " withdrawn from account " + accountnumber);
}
public void showBalance(String accountnumber){
    Account acc = accountMap.get(accountnumber);
    if (acc != null){
        System.out.println(" Current balance for account " + accountnumber + " is ₹" + acc.getBalance());
    } else {
        System.out.println(" Account not found.");
    }
}
public void showTransactions(String accountnumber){
    LinkedList<Transaction> transactionList = transactionMap.get(accountnumber); 
    if (transactionList == null){
        System.out.println(" Account not found.");
        return;
    }
    if (transactionList.isEmpty()) {
        System.out.println(" No transactions found for account: " + accountnumber);
        return;
    }
    System.out.println(" Transaction history for account " + accountnumber + " ");
    for (Transaction t : transactionList) {
        System.out.println("  " + t);
    }
}
	  }
	  