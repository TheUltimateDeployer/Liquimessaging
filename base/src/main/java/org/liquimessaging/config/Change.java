package org.liquimessaging.config;

public interface Change {
	public void execute() throws ChangeException;
	public boolean isFailOnError();
}
