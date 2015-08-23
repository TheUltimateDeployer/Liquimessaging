package org.liquimessaging.xml;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liquimessaging.base.jms.QueueDestination;
import org.liquimessaging.config.ChangeException;
import org.liquimessaging.config.ChangeSet;
import org.liquimessaging.config.ChangeSetProcessor;
import org.liquimessaging.config.GenericQueueConfig;
import org.liquimessaging.config.GenericTopicConfig;
import org.liquimessaging.config.Import;
import org.liquimessaging.config.LiquiMessaging;
import org.liquimessaging.config.Profile;
import org.liquimessaging.config.TextMessageConfig;
import org.liquimessaging.config.command.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class})
public class TestXMLMarshalling {

    @Autowired
    protected Marshaller marshaller = null;
    
    @Autowired
    protected Unmarshaller unmarshaller = null;
    
    @Autowired
    protected ChangeSetProcessor csp;
    
    public transient String marshalledOutput = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><liquiMessaging><changeSets><changeSets author=\"che\" id=\"TestIssue-1\"><queue command=\"create\" durable=\"false\" failOnError=\"false\" name=\"testqueue\"/><topic command=\"create\" failOnError=\"false\" name=\"testopic\"/><failOnError>false</failOnError></changeSets></changeSets></liquiMessaging>";
    /**
     * Tests marshaller.
     */ 
    @Test
    public void testMarshaller() {
        assertNotNull("Marshaller is null.", marshaller);
        LiquiMessaging lm = new LiquiMessaging();
        
        Import testImport = new Import();
        testImport.setFileName("test.xml");
        List<Import> someImports = new ArrayList<Import>();
        someImports.add(testImport);
        lm.setImports(someImports);
        
        List<ChangeSet> someTestChangeSets = new ArrayList<ChangeSet>();
        lm.setChangeSets(someTestChangeSets);
        ChangeSet cs = new ChangeSet();
        someTestChangeSets.add(cs);
        cs.setAuthor("che");
        cs.setId("TestIssue-1");
        
        GenericQueueConfig queue = new GenericQueueConfig();
        cs.addChange(queue);;
        queue.setCommand(Command.CREATE);
        queue.setName("testqueue");
        GenericTopicConfig topic = new GenericTopicConfig();
        cs.addChange(topic);
        topic.setCommand(Command.CREATE);
        topic.setName("testopic");
        
        TextMessageConfig tm = new TextMessageConfig();
        tm.setText("Hahaha");
        tm.setDestination(new QueueDestination("testqueue"));
        cs.addChange(tm);
        
        List<Profile> testProfiles = new ArrayList<Profile>();
        Profile devProf = new Profile();
        devProf.setName("DEV");
        testProfiles.add(devProf);
        lm.setAvailableProfiles(testProfiles);
        
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
			marshaller.marshal(lm, new StreamResult(out));
			marshalledOutput = out.toString();
	        System.out.println("XML Created sucessfully:\n" + marshalledOutput);  
		} catch (XmlMappingException e) {
		} catch (IOException e) {

		}  
    }

    @Test
    public void testUnmarshaller() {
    	 assertNotNull("Unmarshaller is null.", unmarshaller);
    	 ByteArrayInputStream in = new ByteArrayInputStream(marshalledOutput.getBytes());
         
         Object value;
		try {
			 value = unmarshaller.unmarshal(new StreamSource(in));
	         
			 
			 
	         assertNotNull("Unmarshalled instance is null.", value);
	         assertTrue("Not an instance of LiquiMessaging.", (value instanceof LiquiMessaging));
	         
	         csp.process((LiquiMessaging) value);
		} catch (XmlMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ChangeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
}
