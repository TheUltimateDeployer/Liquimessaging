package org.liquimessaging.base;

import javax.xml.bind.annotation.XmlElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

class Property {
	  @XmlElement(name = "name")
	  private String name;

	  @XmlElement(name = "value")
	  private String value;

	  Property() {
	  }

	  Property(String name, String value) {
	    this.name = name;
	    this.value = value;
	  }

	  String getValue() {
	    return value;
	  }

	  String getName() {
	    return name;
	  }

	@Override
	public boolean equals(Object another) {
		Property other = (Property) another;
		EqualsBuilder eb = new EqualsBuilder();
		return eb.append(this.getName(), other.getName()).append(this.getValue(), other.getValue()).isEquals();
	}

	@Override
	public int hashCode() {
		HashCodeBuilder hcb = new HashCodeBuilder(13,7);
		return hcb.append(getName()).append(getValue()).hashCode();
	}
	}
