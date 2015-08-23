package org.liquimessaging.config;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.liquimessaging.base.jms.Message;

@XmlRootElement
public class TextMessageConfig extends Message implements Change{

	private String text;

	@XmlAttribute
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void execute() throws ChangeException {
		// TODO Auto-generated method stub
		
	}
	
	@XmlAttribute
	public boolean isFailOnError() {
		return false;
	}
}
