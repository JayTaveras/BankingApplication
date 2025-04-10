package BankingApplication;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
	
	public static ArrayList<BankAccount> BankAccounts = new ArrayList<BankAccount>();
	
	public static void addAccount(BankAccount element) {
		BankAccounts.add(element);
	}
	
	public static BankAccount findAccount(int number, int pin) {
		int index = 0;
		for (int i = 0; 0 < BankAccounts.size(); i++) {
			if (BankAccounts.get(i).getNumber() == number && BankAccounts.get(i).validatePin(pin) == true) {
				break;
			}
			else {
				index++;
			}
		}
		index++;
		if (index > BankAccounts.size()) {
			BankAccount blah = new BankAccount("Null", 0000);
			return blah;
		}
		else {
			return BankAccounts.get(index);
		}
	}
	
	public static void performTransaction(BankAccount account) {
		Scanner scan = new Scanner(System.in);
		System.out.println("\n\t Select Your Service");
		System.out.println("Deposit Funds (1)");
		System.out.println("Withdraw (2)");
		System.out.println("Check Account Balance(3)");
		int selection = scan.nextInt();
		
		while (selection != 1 && selection != 2 && selection != 3){
			System.out.print("Invalid Input\ny/n\n");
			int answer = scan.nextInt();
			selection = answer;
		}
		do {
			if (selection == 1) {
				System.out.print("Deposit amount: ");
				double deposit = scan.nextDouble();
				account.deposit(deposit);
			}
			if (selection == 2) {
				System.out.print("Withdraw amount: ");
				double withdraw = scan.nextDouble();
				account.withdraw(withdraw);
			}
			if (selection == 3) {
				System.out.println("Your current balance is $" + account.checkBalance());
			}
			
			System.out.println("For Another Transaction, press (1, 2, 3). Exit, press 0");
			int new_select = scan.nextInt();
			selection = new_select;
			
		} while (selection != 0);
		
	}
}
