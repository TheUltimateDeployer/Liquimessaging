package org.liquimessaging.config;

import java.util.Map;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Session;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.liquimessaging.base.ConfigProperties;
import org.liquimessaging.base.spring.ApplicationContextProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.connection.CachingConnectionFactory;

@XmlRootElement(name="queue")
public class GenericQueueConfig extends AbstractChange implements Change {
	
	private String name;
	
	private String type;
	
	private ConfigProperties properties;
	
	private ConnectionFactory conFactory;
	
	public void execute() throws ChangeException {
		
		try {
			ApplicationContext context = ApplicationContextProvider.getApplicationContext();
			conFactory = context.getBean(CachingConnectionFactory.class);
			Connection conn = conFactory.createConnection();
			Session session = conn.createSession(true,Session.AUTO_ACKNOWLEDGE);
			session.createQueue(name);
			session.commit();
			session.close();
		} catch (JMSException e) {
			throw new ChangeException(e);
		}
	}


	@XmlAttribute(required=true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlAttribute
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


}
