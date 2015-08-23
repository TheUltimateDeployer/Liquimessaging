package org.liquimessaging.config;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

import org.liquimessaging.config.command.Command;

@XmlTransient
public abstract class AbstractChange implements Change{
	
	private boolean failOnError;
	
	private Command command;
	
	@XmlAttribute
	public boolean isFailOnError() {
		return failOnError;
	}
	
	public void setFailOnError(boolean failOnError) {
		this.failOnError = failOnError;
	}

	public abstract void execute() throws ChangeException;
	
	@XmlAttribute(name="command") 
	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}
}
