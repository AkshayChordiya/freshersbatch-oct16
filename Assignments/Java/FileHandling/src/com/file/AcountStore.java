package com.file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class Account {
	String name;
	int accountNo;
	double balance;
	
	public Account(String name, int accountNo, double balance) {
		super();
		this.name = name;
		this.accountNo = accountNo;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", accountNo=" + accountNo + ", balance=" + balance + "]";
	}
}

public class AcountStore {
	public static void main(String[] args) {
		Account[] accounts = new Account[3];
		accounts[0] = new Account("Akshay", 1, 10.0);
		accounts[1] = new Account("Janhavi", 2, 40.0);
		accounts[2] = new Account("Aditya", 3, 20.0);
		write(accounts);
		read();
	}

	private static void write(Account[] accounts) {
		try (DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("account.txt"));) {
			for (Account account : accounts) {
				dataOut.writeUTF(account.name);
				dataOut.writeInt(account.accountNo);
				dataOut.writeDouble(account.balance);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void read() {
		try (DataInputStream dataIn = new DataInputStream(new FileInputStream("account.txt"));) {
			while (dataIn.available() > 0) {
				System.out.println(
						"Name = " + dataIn.readUTF() +
						", No = " + dataIn.readInt() + 
						", Balance = " + dataIn.readDouble());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
