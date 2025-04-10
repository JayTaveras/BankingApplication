package BankingApplication;

public class BankAccount {
	
	public int accountNumber; 
	public int pin;
	public String name;
	public double currentBalance;
	
	public BankAccount(String name, int pin) {
		this.name = name;
		this.pin = pin;
		this.currentBalance = 0;
		this.accountNumber = (int)(Math.random() * 9999);
	}
	public void deposit(double amount) {
		currentBalance += amount;
		System.out.println("$" + amount + " has been deposited.");
	}
	public void withdraw(double amount) {
		if (amount > currentBalance) {
			System.out.println("Cannot Withdraw. Withdraw Amount is greater than Current Balance.");
		}
		else {
			currentBalance -= amount;
			System.out.println("$" + amount + " has been withdrawn.");
		}
	}
	public double checkBalance() {
		return currentBalance;
	}
	public int getNumber() {
		return accountNumber;
	}
	public String getName() {
		return name;
	}
	public boolean validatePin(int inputPin) {
		if (inputPin == pin) {
			return true;
		}
		else {
			return false;
		}
	}
	

}
