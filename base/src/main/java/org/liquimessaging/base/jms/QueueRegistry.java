package org.liquimessaging.base.jms;

import org.springframework.stereotype.Component;

@Component
public class QueueRegistry {

	public Class getQueueClass(String type) {
		if (type == null || type.equals("")) {
			return GenericQueueWrapper.class;
		}
		return null;
	}

	public Class getQueueWrapperClass(String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
