package com.ping;

public class PongThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("\tPong");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}

}
