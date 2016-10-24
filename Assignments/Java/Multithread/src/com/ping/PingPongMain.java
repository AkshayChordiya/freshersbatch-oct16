package com.ping;

public class PingPongMain {
	public static void main(String[] args) {
		PingThread pingThread = new PingThread();
		pingThread.setName("Ping");
		PongThread pongThread = new PongThread();
		pongThread.setName("Pong");
		pingThread.start();
		pongThread.start();
	}
}
