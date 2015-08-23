package org.liquimessaging.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class ConfigProperties {
	  @XmlElement(name = "property")
	  private List<Property> entries = new ArrayList<Property>();

	  public List<Property> entries() {
	    return Collections.unmodifiableList(entries);
	  }

	  public void addEntry(Property entry) {
	    entries.add(entry);
	  }
	}
