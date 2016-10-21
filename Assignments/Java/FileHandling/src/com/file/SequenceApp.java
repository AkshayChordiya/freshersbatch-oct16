package com.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceApp {
	public static void main(String[] args) throws IOException {
		FileInputStream fis1 = new FileInputStream("base.txt");
		FileInputStream fis2 = new FileInputStream("dest.txt");
		FileInputStream fis3 = new FileInputStream("seq.txt");

		Vector<InputStream> inputStreams = new Vector<InputStream>();
		inputStreams.add(fis1);
		inputStreams.add(fis2);
		inputStreams.add(fis3);

		Enumeration<InputStream> enu = inputStreams.elements();
		SequenceInputStream sis = new SequenceInputStream(enu);
		
		int character;
		while ((character = sis.read()) != -1) {
			System.out.print((char)character);
		}
		
		sis.close();
		fis1.close();
		fis2.close();
		fis3.close();
	}
}
