package com.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class AccountSerialized implements Serializable {
	private static final long serialVersionUID = 1L;

	String name;
	int accountNo;
	double balance;
	Date dob;

	public AccountSerialized(String name, int accountNo, double balance, Date dob) {
		super();
		this.name = name;
		this.accountNo = accountNo;
		this.balance = balance;
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", accountNo=" + accountNo + ", balance=" + balance + ", dob=" + dob + "]";
	}

}

/**
 * Date Program
 * 
 * @author Akshay Chordiya
 */
class Date implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int year;
	private int month;
	private int day;

	/** Default Constructor **/
	public Date() {
		day = 15;
		month = 06;
		year = 1995;
	}

	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public String toString() {
		return "DD/MM/YYYY = " + day + "/" + month + "/" + year;
	}

}

public class SerializeApp {

	public static void main(String[] args) throws Exception {
		serialize();
		deserialize();
	}

	private static void serialize() throws Exception {
		AccountSerialized account = new AccountSerialized("Akshay", 1, 100, new Date(1994, 5, 14));

		FileOutputStream fout = new FileOutputStream("saccount.txt");
		ObjectOutputStream out = new ObjectOutputStream(fout);

		out.writeObject(account);
		out.flush();
		out.close();
		fout.close();
	}

	private static void deserialize() throws Exception {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("saccount.txt"));
		AccountSerialized account = (AccountSerialized) in.readObject();
		System.out.println(account);

		in.close();
	}

}
