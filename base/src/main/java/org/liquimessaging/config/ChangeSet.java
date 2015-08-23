package org.liquimessaging.config;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jms.ConnectionFactory;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;

@XmlRootElement
public class ChangeSet {
	@XmlAnyElement(lax=true)
	private List<Change> changes = new ArrayList<Change>();
	
	private boolean failOnError = false;
	
	private String author;
	
	private String id;
	
	private String profiles;
	
	@Autowired
	private ConnectionFactory conFactory;

	public void execute() throws ChangeException {
		for (Iterator<Change> iterator = changes.iterator(); iterator.hasNext();) {
			Object value = iterator.next();
			
			// JAXB doesn't like interfaces
			if (value instanceof GenericQueueConfig) {
				((GenericQueueConfig)value).execute();
			} else if (value instanceof GenericTopicConfig) {
				((GenericTopicConfig)value).execute();
			}
		}
	}
	
	public void addChange(Change change) {
		changes.add(change);
	}

	@XmlAttribute(required=false)
	public boolean isFailOnError() {
		return failOnError;
	}

	public void setFailOnError(boolean failOnError) {
		this.failOnError = failOnError;
	}

	@XmlAttribute(required=true)
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@XmlAttribute(required=true)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlAttribute
	public String getProfile() {
		return profiles;
	}

	public void setProfile(String profiles) {
		this.profiles = profiles;
	}

	public List<Change> getChanges() {
		return changes;
	}

}
