package com.hospital;

public class Main implements PressureListener {
	public static void main(String[] args) throws InterruptedException {
		Main main = new Main();
		main.main();
	}

	public void main() throws InterruptedException {
		BloodPressureManager manager = new BloodPressureManager(this);
		manager.observeBloodPressure();
	}

	@Override
	public void onCriticalPressure(int pressure) {
		System.err.println("Critical Pressure " + pressure);
	}
}
