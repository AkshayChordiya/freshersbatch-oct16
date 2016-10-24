package com.ping;

public class PingPong implements Runnable {

	private Thread pingThread, pongThread;

	public static void main(String[] args) {
		PingPong pg = new PingPong();
		pg.main();
	}

	private void main() {
		pingThread = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("Ping");
					try {Thread.sleep(300);} catch (InterruptedException e) {}
				}
			}
		}, "Ping");
		pongThread = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("\tPong");
					try {Thread.sleep(500);} catch (InterruptedException e) {}
				}
			}
		}, "Pong");
		pongThread.setDaemon(true);
		pingThread.start();
		pongThread.start();
	}

	@Override
	public void run() {
		Thread currentThread = Thread.currentThread();
		if (currentThread.getName().equals("Ping")) {
			for (int i = 0; i < 10; i++) {
				System.out.println("Ping");
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
				}
			}
		}
		if (currentThread.getName().equals("Pong")) {
			for (;;) {
				System.out.println("\tPong");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
			}
		}
	}

}
