package org.liquimessaging.config;

import javax.jms.JMSException;

public class ChangeException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ChangeException(JMSException e) {
		super(e);
	}

}
