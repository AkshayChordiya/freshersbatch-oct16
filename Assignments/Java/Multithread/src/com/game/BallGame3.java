package com.game;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BallGame3 extends Frame implements Runnable {

	Thread t1, t2, t3;
	int y1 = 400, y2 = 400, y3 = 400;

	public static boolean allComplete = false;
	private ReentrantLock lock;
	private Condition condition;

	public BallGame3() {

		super("Ball game");
		setBackground(Color.CYAN);
		setSize(500, 500);
		setVisible(true);

		lock = new ReentrantLock();
		condition = lock.newCondition();

		t1 = new Thread(this);
		t2 = new Thread(this);
		t3 = new Thread(this);

		t1.setName("Y1");
		t2.setName("Y2");
		t3.setName("Y3");

		t1.start();
		t2.start();
		t3.start();

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(100, y1, 50, 50);
		g.setColor(Color.GREEN);
		g.fillOval(200, y2, 50, 50);
		g.setColor(Color.BLUE);
		g.fillOval(300, y3, 50, 50);
	}

	@Override
	public void run() {

		Thread currentThread = Thread.currentThread();
		if (currentThread.getName().equals("Y1")) {
			boolean top = false;
			boolean edge = false;
			for (;;) {
				if (!allComplete && edge) {
					lock.lock();
					try {
						condition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						lock.unlock();
					}
				}
				if (top) {
					y1++;
					if (y1 == 400) {
						top = false;
						edge = true;
					} else {
						edge = false;
					}
				} else {
					y1--;
					if (y1 < 50) {
						top = true;
						edge = true;
					} else {
						edge = false;
					}
				}
				repaint();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} else if (currentThread.getName().equals("Y2")) {
			boolean top = false;
			boolean edge = false;
			for (;;) {
				if (!allComplete && edge) {
					lock.lock();
					try {
						condition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						lock.unlock();
					}
				}
				if (top) {
					y2++;
					if (y2 == 400) {
						top = false;
						edge = true;
					} else {
						edge = false;
					}
				} else {
					y2--;
					if (y2 < 50) {
						top = true;
						edge = true;
					} else {
						edge = false;
					}
				}
				repaint();
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} else if (currentThread.getName().equals("Y3")) {
			boolean top = false;
			for (;;) {
				if (top) {
					y3++;
					if (y3 == 400) {
						top = false;
						allComplete = true;
						lock.lock();
						condition.signalAll();
						lock.unlock();
					} else {
						allComplete = false;
					}
				} else {
					y3--;
					if (y3 < 50) {
						top = true;
						allComplete = true;
						lock.lock();
						condition.signalAll();
						lock.unlock();
					} else {
						allComplete = false;
					}
				}
				repaint();
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {

		Frame mf = new BallGame3();
		mf.setSize(500, 500);
		mf.setVisible(true);
	}

}