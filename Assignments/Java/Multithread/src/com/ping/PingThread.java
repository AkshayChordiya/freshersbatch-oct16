package com.ping;

public class PingThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Ping");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
			}
		}
	}

}
