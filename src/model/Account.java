package model;

public class Account {
    private String accountnumber;
    private String accountholder;
    private double balance;
    
		// TODO Auto-generated constructor stub
	
    public Account(String accountnumber, String accountholder, double balance) {
        this.accountnumber = accountnumber;
        this.accountholder = accountholder;
        this.balance = balance;
    } 
		// TODO Auto-generated constructor stub
	
	public void setAccountNumber(String accountnumber){
        this.accountnumber = accountnumber;
    } 
    public String getAccountNumber(){
        return accountnumber;
    }
    public void setAccountHolder(String accountholder){
        this.accountholder = accountholder;
    }
    public String getAccountHolder(){
        return accountholder;
    }
    public void setBalance(double balance){
        this.balance =balance;
    }
     public double getBalance() {
        return balance;
    }

        public void deposit (double amount){
        if(amount>0){
            balance+=amount;
        }else{
            System.out.println("inefficient to deposit");
        }
    }
    public void withdraw(double amount){
        if(balance> amount){
            balance-=amount;
        }else{
            System.out.println("inefficient to withdraw");
        }
    }
    @Override
    public String toString() {
        return "Account Number: " + accountnumber +
               ", Account Holder: " + accountholder +
               ", Balance: ₹" + balance;
    }

}


