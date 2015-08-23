package org.liquimessaging.base.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.liquimessaging.base.spring.ApplicationContextProvider;
import org.springframework.jms.connection.CachingConnectionFactory;

@XmlRootElement
public class QueueDestination extends Destination{

	private String name;
	
	public QueueDestination() {
		super();
	}
			
	public QueueDestination(String name) {
		super();
		this.name = name;
	}



	@Override
	public MessageProducer createProducer() {
		ConnectionFactory cf = ApplicationContextProvider.getApplicationContext().getBean(CachingConnectionFactory.class);
		try {
			Connection con = cf.createConnection();
			Session session = con.createSession(true, Session.AUTO_ACKNOWLEDGE);
			Queue queue = session.createQueue(name);
			MessageProducer producer = session.createProducer(queue);
			return producer;
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	@XmlAttribute
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
