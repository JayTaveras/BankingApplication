package BankingApplication;

import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);	
		int repeat = 0;
		do {

			System.out.println("\tWelcome to Penguineer Banking\n");
			System.out.println("Do You have an Account? y/n");
			String ans = scan.nextLine();
			while (!ans.equalsIgnoreCase("y") && !ans.equalsIgnoreCase("yes") && !ans.equalsIgnoreCase("n") && !ans.equalsIgnoreCase("no")){
				System.out.print("Invalid Input\ny/n\n");
				String answer = scan.nextLine();
				ans = answer;
			}
			if (ans.equalsIgnoreCase("y") || ans.equalsIgnoreCase("yes")) {
				System.out.println("\t Sign In\n");
				System.out.print("Account Number: ");
				int number = scan.nextInt();
				System.out.print("Pin: ");
				int pin = scan.nextInt();
				scan.nextLine();
				BankAccount Account = Bank.findAccount(number, pin);
				
				if (Bank.BankAccounts.contains(Account) == true) {
					System.out.print("Welcome " + Account.getName());
					Bank.performTransaction(Account);					
				}
				else {
					System.out.println("Account Not Found\n");
				}

			}
			else if (ans.equalsIgnoreCase("n") || ans.equalsIgnoreCase("no")) {
				System.out.println("\tRegister Account\n ");
				System.out.print("Username: ");
				String username = scan.nextLine();
				System.out.print("Pin: ");
				int pin = scan.nextInt();
				scan.nextLine();
				BankAccount Account = new BankAccount(username, pin);
				Bank.addAccount(Account);
				System.out.println("Account Registered.");
				System.out.println("Your Account Number is: " + Account.getNumber());
			
				Bank.performTransaction(Account);
			}

		
		} while (repeat == 0);
	}
}
