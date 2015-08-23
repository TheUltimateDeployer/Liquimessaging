package org.liquimessaging.base.jms;

import javax.jms.MessageProducer;

public abstract class Destination {
	public abstract MessageProducer createProducer();
}
