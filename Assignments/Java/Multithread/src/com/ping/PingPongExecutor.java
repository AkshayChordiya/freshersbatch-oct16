package com.ping;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PingPongExecutor {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		threadPool.submit(ping);
		threadPool.submit(pong);
		threadPool.shutdown();
	}

	private static Callable<Void> ping = new Callable<Void>() {
		@Override
		public Void call() throws Exception {
			for (int i = 0; i < 10; i++) {
				System.out.println("Ping");
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {}
			}
			return null;
		}
	};

	private static Callable<Void> pong = new Callable<Void>() {

		@Override
		public Void call() throws Exception {
			for (int i = 0; i < 10; i++) {
				System.out.println("\tPong");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {}
			}
			return null;
		}
	};
}
