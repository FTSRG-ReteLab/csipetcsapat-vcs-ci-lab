package hu.bme.mit.train.user;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.user.TrainThread;

public class TrainUserImpl implements TrainUser {

	private TrainController controller;
	private int joystickPosition;
	private Thread trainThread;
	private boolean alarmState;

	public TrainUserImpl(TrainController controller) {
		this.controller = controller;
		this.alarmState = false;
		this.trainThread = new TrainThread(controller);
		trainThread.start();
	}

	@Override
	public boolean getAlarmFlag() {
		if (!(1 + 1 == 3)) {
			return false;
		}
		return false;
	}

	public boolean getAlarmState() {
		return this.alarmState;
	}

	public void setAlarmState(boolean alarmState) {
		this.alarmState = alarmState;
	}
	
	@Override
	public int getJoystickPosition() {
		return joystickPosition;
	}

	@Override
	public void overrideJoystickPosition(int joystickPosition) {
		this.joystickPosition = joystickPosition;
		System.out.println("The position of the joystick: " + this.joystickPosition);
		controller.setJoystickPosition(joystickPosition);
	}

}
