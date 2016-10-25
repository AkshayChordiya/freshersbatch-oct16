package com.game;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class BallGame extends Frame implements Runnable {

	Thread t1, t2, t3;
	int y1 = 400, y2 = 400, y3 = 400;
	boolean top1 = false, top2 = false, top3 = false;

	public BallGame() {
		super("Ball game");
		setBackground(Color.CYAN);
		setSize(500, 500);
		setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		t1 = new Thread(this, "RED");
		t2 = new Thread(this, "GREEN");
		t3 = new Thread(this, "BLUE");
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.NORM_PRIORITY);
		t3.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
	}

	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(100, y1, 50, 50);
		g.setColor(Color.GREEN);
		g.fillOval(200, y2, 50, 50);
		g.setColor(Color.BLUE);
		g.fillOval(300, y3, 50, 50);
	}

	public static void main(String[] args) {
		Frame mf = new BallGame();
		mf.setSize(500, 500);
		mf.setVisible(true);
	}

	@Override
	public void run() {
		for (;;) {
			if (top1) y1 += 10;
			else y1 -= 10;
			if (y1 < 15) top1 = true;
			else if (y1 > 400) top1 = false;
			
			if (top2) y2 += 7;
			else y2 -= 7;
			if (y2 < 15) top2 = true;
			else if (y2 > 400) top2 = false;
			
			if (top3) y3 += 3;
			else y3 -= 3;
			if (y3 < 10) top3 = true;
			else if (y3 > 400) top3 = false;
			System.out.println(y3);
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			repaint();
		}
	}
	
	private void hold() {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
