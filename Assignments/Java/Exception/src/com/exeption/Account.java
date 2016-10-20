package com.exeption;

/**
	Account Program
	@author Akshay Chordiya
*/
public class Account {

	private double balance;
	
	/** Default Constructor **/
	public Account() {
		balance = 0.0;
	}
	
	public Account(double balance) {
		this.balance = balance;
	}
	
	public String toString() {
		return "Balance = " + balance;
	}
	
	/** GETTERS and SETTERS **/
	
	public void deposit(double amount) {
		this.balance += amount; 
	}
	
	public void withdraw(double amount) throws InsufficientBalanceException {
		if (balance <= amount) {
			throw new InsufficientBalanceException("withdraw " + amount);
		}
		this.balance -= amount; 
	}

}