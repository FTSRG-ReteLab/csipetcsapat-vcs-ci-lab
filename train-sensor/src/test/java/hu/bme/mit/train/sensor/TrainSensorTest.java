package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    private TrainController controller;
    private TrainUser user;
    private TrainSensor sensor;

    @Before
    public void before() {
	controller = mock(TrainController.class);
	user = mock(TrainUser.class);
	sensor = new TrainSensor(controller, user);        
    }

    @Test
    public void testNormalRun() {
	when(controller
        sensor.overrideSpeedLimit(10);
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        // TODO Delete this and add test cases based on the issues
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        // TODO Delete this and add test cases based on the issues
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        // TODO Delete this and add test cases based on the issues
    }

}
