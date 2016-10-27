package com.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ConcurentCollection {
	public static ArrayList<Integer> arrayList;

	static {
		arrayList = new ArrayList<>();
		for (int i = 0; i < 100; i++)
			arrayList.add(i);
	}

	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				Iterator<Integer> iterator;
				while (true) {
					iterator = arrayList.iterator();
					while (iterator.hasNext()) {
						System.out.println(iterator.next());
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					arrayList.add(-1);
					System.out.println("Inserted -1");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

}