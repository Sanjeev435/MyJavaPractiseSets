package com.practise.patterns.behavioral.command;

public class LightOnCommand implements Command {

	private Light light;

	// This field is only for testing purpose
	public static String message;

	public LightOnCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		LightOnCommand.message = this.light.switchOn();
	}

}
