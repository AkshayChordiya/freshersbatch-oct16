package com.exeption.res;

public class TryWithRes {
	public static void main(String[] args) {
		try (MyAutoCloseable closeable = new MyAutoCloseable()) {
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
