package com.practise.patterns.behavioral.command;

public class LightOffCommand implements Command {

	private Light light;

	// This field is only for testing purpose
	public static String message;

	public LightOffCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		LightOffCommand.message = this.light.switchOff();
	}

}
