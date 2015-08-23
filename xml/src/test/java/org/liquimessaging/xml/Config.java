package org.liquimessaging.xml;

import javax.jms.ConnectionFactory;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.spring.ActiveMQConnectionFactoryFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
@ComponentScan("org.liquimessaging")
public class Config {

	static {
        BrokerService brokerService = new BrokerService();
        try {
			brokerService.addConnector("tcp://localhost:61616");
	        brokerService.setDataDirectory("C:/temp/data");
	        brokerService.setEnableStatistics(true);
	        brokerService.setPersistent(true);
	        brokerService.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Bean
	public Jaxb2Marshaller getMarshaller() {
		Jaxb2Marshaller jaxbM = new Jaxb2Marshaller();
		jaxbM.setPackagesToScan("org.liquimessaging.config", "org.liquimessaging.base.jms");
		return jaxbM;
	}
	
	@Bean
	public ConnectionFactory getAmqFactory() throws Exception {
		ActiveMQConnectionFactoryFactoryBean factory = new ActiveMQConnectionFactoryFactoryBean();
		factory.setTcpHostAndPort("tcp://localhost:61616");
		return (ConnectionFactory) factory.getObject();
	}
	
	@Bean
	public CachingConnectionFactory getCachingFactory() throws Exception {
		return new CachingConnectionFactory(getAmqFactory());
	}
}
