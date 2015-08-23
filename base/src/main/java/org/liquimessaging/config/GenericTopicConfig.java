package org.liquimessaging.config;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.liquimessaging.base.ConfigProperties;
import org.liquimessaging.base.spring.ApplicationContextProvider;
import org.springframework.jms.connection.CachingConnectionFactory;

@XmlRootElement(name="topic")
public class GenericTopicConfig extends AbstractChange implements Change{

	private String name;
	
	private ConfigProperties properties;
	
	private ConnectionFactory conFactory;
	
	public void execute() throws ChangeException {
		try {
			conFactory = ApplicationContextProvider.getApplicationContext().getBean(CachingConnectionFactory.class);
			Connection con  = conFactory.createConnection();
			Session session = con.createSession(true,0);
			session.createTopic(name);
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

	public ConfigProperties getProperties() {
		return properties;
	}

	public void setProperties(ConfigProperties properties) {
		this.properties = properties;
	}
}
