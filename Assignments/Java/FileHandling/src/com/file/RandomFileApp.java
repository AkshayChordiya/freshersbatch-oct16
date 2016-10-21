package com.file;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class RandomFileApp {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		String name;
		int no;
		double salary;

		System.out.println("1. Create");
		System.out.println("2. Read");
		System.out.println("3. Update");
		System.out.println("4. Delete");
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("Select your CRUD operation = ");
			switch (scanner.nextInt()) {
			case 1:
				name = scanner.next();
				no = scanner.nextInt();
				salary = scanner.nextDouble();
				create(new Account(name, no, salary));
				break;
			case 2:
				read(scanner.nextDouble());
				break;
			case 3:
				name = scanner.next();
				no = scanner.nextInt();
				salary = scanner.nextDouble();
				update(new Account(name, no, salary));
				break;
			case 4:
				delete(scanner.nextInt());
				break;
			default:
				break;
			}
		}
	}

	private static void delete(int no) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("crud.txt", "rw");
		long pointer = 0;
		while (raf.getFilePointer() < raf.length()) {
			pointer = raf.getFilePointer();
			int tempNo = raf.readInt();
			raf.readUTF();
			if (no == tempNo) {
				raf.seek(pointer);
				System.out.println("Found and Delete");
				raf.writeInt(0);
				raf.writeUTF("");
				raf.writeDouble(0);
				raf.close();
				return;
			}
		}
		raf.close();
		System.out.println("Unable to delete, not found!");
	}

	public static void read(double minSalary) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("crud.txt", "r");
		long pointer = 0;
		while (raf.getFilePointer() < raf.length()) {
			pointer = raf.getFilePointer();
			raf.readInt();
			raf.readUTF();
			if (raf.readDouble() > minSalary) {
				System.out.println("Showing accounts with salary more than " + minSalary);
				raf.seek(pointer);
			} else {
				System.out.println("No account");
				raf.close();
				return;
			}
			System.out
					.println("No = " + raf.readInt() + ", Name = " + raf.readUTF() + ", Balance = " + raf.readDouble());
		}
		raf.close();
		System.out.println("Read");
	}

	private static void update(Account account) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("crud.txt", "rw");
		long pointer = 0;
		while (raf.getFilePointer() < raf.length()) {
			pointer = raf.getFilePointer();
			int tempNo = raf.readInt();
			raf.readUTF();
			if (account.accountNo == tempNo) {
				raf.seek(pointer);
				System.out.println("Found and updated!");
				raf.writeInt(account.accountNo);
				raf.writeUTF(account.name);
				raf.writeDouble(account.balance);
				raf.close();
				return;
			}
		}
		raf.close();
		System.out.println("Unable to update, not found!");
	}

	public static void create(Account account) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("crud.txt", "rw");
		raf.writeInt(account.accountNo);
		raf.writeUTF(account.name);
		raf.writeDouble(account.balance);
		raf.close();
		System.out.println("Created");
	}

}
