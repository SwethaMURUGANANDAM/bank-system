package main;
import service.BankService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankService bank = new BankService();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n Online Banking System ");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Show Transactions");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");
            choice = sc.nextInt();
            sc.nextLine();

            String accNum;
            double amount;

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    accNum = sc.nextLine();
                    System.out.print("Enter Account Holder Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Initial Deposit: ");
                    amount = sc.nextDouble();
                    bank.createAccount(accNum, name, amount);
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    accNum = sc.nextLine();
                    System.out.print("Enter Deposit Amount: ");
                    amount = sc.nextDouble();
                    bank.deposit(accNum, amount);
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    accNum = sc.nextLine();
                    System.out.print("Enter Withdraw Amount: ");
                    amount = sc.nextDouble();
                    bank.withdraw(accNum, amount);
                    break;
                case 4:
                    System.out.print("Enter Account Number: ");
                    accNum = sc.nextLine();
                    bank.showBalance(accNum);
                    break;
                case 5:
                    System.out.print("Enter Account Number: ");
                    accNum = sc.nextLine();
                    bank.showTransactions(accNum);
                    break;
                case 6:
                    System.out.println(" Thank you for using Online Banking System");
                    break;
                default:
                    System.out.println(" Invalid option. Try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}


	


