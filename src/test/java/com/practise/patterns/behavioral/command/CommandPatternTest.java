package com.practise.patterns.behavioral.command;

import org.junit.Assert;
import org.junit.Test;

public class CommandPatternTest {

	@Test
	public void shouldTestCommandPattern() {
		Light light = new Light();

		Command lightsOn = new LightOnCommand(light);
		Command lightsOff = new LightOffCommand(light);

		Assert.assertNull(LightOnCommand.message);
		Assert.assertNull(LightOffCommand.message);
		
		RemoteControl remoteControl = new RemoteControl();

		remoteControl.setCommand(lightsOn);
		remoteControl.pressButton();
		Assert.assertEquals("Light is on", LightOnCommand.message);

		remoteControl.setCommand(lightsOff);
		remoteControl.pressButton();
		Assert.assertEquals("Light is off", LightOffCommand.message);
	}

}
