
public class TirePressureTest {
	// налагане е под минимума (< 17) -> true
	@Test
	public void testAlarmWithLowerValue() {
		// винаги налягането < 17
		Sensor sensor = Mockito.mock(Sensor.class);
		Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(16.9);
		Alarm alarm = new Alarm(sensor);
		alarm.check();
		Assert.assertTrue(alarm.getAlarmOn());
	}

	// налагянето е над максимума (> 21) -> true
	@Test
	public void testAlarmWithHigherValue() {
		Sensor sensor = Mockito.mock(Sensor.class);
		Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(21.4);
		Alarm alarm = new Alarm(sensor);
		alarm.check();
		Assert.assertTrue(alarm.getAlarmOn());
	}

	// налягането е в норма (17 до 21 вкл) -> false
	@Test
	public void testAlarmWitNormalValue() {
		Sensor sensor = Mockito.mock(Sensor.class);
		Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(19.6);
		Alarm alarm = new Alarm(sensor);
		alarm.check();
		Assert.assertFalse(alarm.getAlarmOn());
	}
}