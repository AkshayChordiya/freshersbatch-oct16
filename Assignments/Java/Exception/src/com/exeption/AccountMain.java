package com.exeption;

public class AccountMain {
	public static void main(String[] args) {
		Account account = new Account(4000);
		System.out.println(account);
		account.deposit(1000);
		System.out.println(account);
		try {
			account.withdraw(10000.5);
		} catch (InsufficientBalanceException e) {
			System.out.println(e);
		}
		System.out.println(account);
	}
}
