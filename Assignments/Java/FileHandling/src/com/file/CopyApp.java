package com.file;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyApp {
	public static void main(String[] args) {
		String read = read();
		System.out.println("Read file = " + read);
		write(read);
		System.out.println("Wrote the contents into the file");
	}

	private static void write(String read) {
		try (FileWriter writer = new FileWriter("dest.txt", true);) {
			writer.write(read);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String read() {
		try (FileReader reader = new FileReader("base.txt");) {
			int character;
			StringBuilder builder = new StringBuilder();
			while ((character = reader.read()) != -1) {
				builder.append((char)character);
			}
			return builder.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

}
