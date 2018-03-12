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
	sensor = new TrainSensorImpl(controller, user);        
    }

    @Test
    public void testNormalRun() {
        sensor.overrideSpeedLimit(10);
	verify(user, times(0)).setAlarmState(true);
	verify(controller, times(1)).setSpeedLimit(10);
	Assert.assertEquals(10, sensor.getSpeedLimit());
    }

    @Test
    public void testMoreThan50PercentSlower() {
	when(controller.getReferenceSpeed()).thenReturn(5);
        sensor.overrideSpeedLimit(2);
	verify(user, times(1)).setAlarmState(true);
    }

    @Test
    public void testNegativeValues() {
        sensor.overrideSpeedLimit(-1);
	verify(user, times(1)).setAlarmState(true);
    }

    @Test
    public void testOutOfBoundPositiveValues() {
        sensor.overrideSpeedLimit(501);
	verify(user, times(1)).setAlarmState(true);
    }

}
