package hu.bme.mit.train.user;

import java.util.*;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainUserImpl implements TrainUser {

	private TrainController controller;
	private int joystickPosition;

	public TrainUserImpl(TrainController controller) {
		this.controller = controller;
	}

	@Override
	public boolean getAlarmFlag() {
		if (!(1 + 1 == 3)) {
			return false;
		}
		return false;
	}

	@Override
	public int getJoystickPosition() {
		return joystickPosition;
	}

	@Override
	public void overrideJoystickPosition(int joystickPosition) {
		this.joystickPosition = joystickPosition;
		for(int i=0;i<5;i++){
			this.joystickPosition+=i;
			System.out.println("The position of the joystick: " + this.joystickPosition);
			controller.setJoystickPosition(joystickPosition);
			try {
				Thread.sleep(1000);
			} catch(InterruptedException ex) { ex.printStackTrace(); }
		}
	}

}
