package org.liquimessaging.base.jms;

import javax.jms.Queue;

import org.liquimessaging.config.GenericQueueConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.stereotype.Component;

/**
 * This class creates the instances based on the configuration and the registered 
 * types.
 * 
 * @author che
 *
 */
@Component
public class QueueFactory extends AbstractFactoryBean<Object>{
	
	@Autowired
	QueueRegistry queueRegistry;


	protected Object createInstance(GenericQueueConfig config) throws Exception {
		Class queueClass = queueRegistry.getQueueClass(config.getType());
		Object instance = queueClass.newInstance();
		return queueClass;
	}

	@Override
	public Class<?> getObjectType() {
		Class queueClass = queueRegistry.getQueueClass(null);
		return queueClass;
	}

	@Override
	protected Object createInstance() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
