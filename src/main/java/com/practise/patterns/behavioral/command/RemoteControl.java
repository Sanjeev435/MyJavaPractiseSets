package com.practise.patterns.behavioral.command;

import lombok.Getter;
import lombok.Setter;

public class RemoteControl {
	
	@Setter
	@Getter
	private Command command;
	
	public void pressButton() {
		this.command.execute();
	}
}
