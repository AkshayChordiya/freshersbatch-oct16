package com.file;

import java.io.File;
import java.util.Date;

public class FileDetails {
	public static void main(String[] args) {
		File file = new File("base.txt");
		//file name, size, date, file permissions, directory
		System.out.println("Name = " + file.getName());
		System.out.println("Size = " + file.length());
		System.out.println("Modified = " + new Date(file.lastModified()));
		System.out.print("Permission = ");
		if (file.isDirectory()) {
			System.out.print("d");
		}
		if (file.canRead()) {
			System.out.print("r");
		}
		if (file.canWrite()) {
			System.out.print("w");
		}
		if (file.canExecute()) {
			System.out.print("x");
		}
	}
}
