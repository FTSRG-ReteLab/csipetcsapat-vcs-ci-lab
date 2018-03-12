package hu.bme.mit.train.user;

import hu.bme.mit.train.interfaces.TrainController;

public class TrainThread extends Thread {
	private TrainController controller;
	private boolean running;
	
	public TrainThread(TrainController controller) {
		this.controller = controller;
		this.running = false;
	}

	public void run() {
		this.running = true;
		while (this.running) {
			controller.followSpeed();
			try {
				Thread.sleep(1000);
			} catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void stopThread() {
		this.running = false;
	}
}
