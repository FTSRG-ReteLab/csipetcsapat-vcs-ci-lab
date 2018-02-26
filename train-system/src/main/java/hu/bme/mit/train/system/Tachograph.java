package hu.bme.mit.train.system;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.sensor.TrainSensorImpl;
import hu.bme.mit.train.user.TrainUserImpl;
import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;
import java.util.Date;

public class Tachograph {

	private TrainController controller;
	private TrainUser user;
	private Table<Date, Integer, Integer> table;

	public Tachograph(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
		this.table = TreeBasedTable.create();
	}

	public void update() {
		table.put(new Date(), controller.getReferenceSpeed(),  user.getJoystickPosition());
	}
	
	public boolean isEmpty() {
		return table.isEmpty();
	}

}
