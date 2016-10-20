package com.exeption;

public class InsufficientBalanceException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public InsufficientBalanceException() {
		message = "";
	}

	public InsufficientBalanceException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "You don't have enough balance to " + message;
	}
	
}
