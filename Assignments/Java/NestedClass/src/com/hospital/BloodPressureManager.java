package com.hospital;

import java.util.Random;

public class BloodPressureManager {
	
	private PressureListener pressureListener;
	
	public BloodPressureManager(PressureListener pressureListener) {
		this.pressureListener = pressureListener;
	}

	public void observeBloodPressure() throws InterruptedException {
		Random random = new Random();
		int pressure = 0;
		while (true) {
			pressure = random.nextInt(200);
			if (pressure > 140) {
				pressureListener.onCriticalPressure(pressure);
			} else {
				System.out.println("Pressure = " + pressure);
			}
			Thread.sleep(1000);
		}
	}
}
