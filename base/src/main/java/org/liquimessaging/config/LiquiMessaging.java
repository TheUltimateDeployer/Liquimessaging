package org.liquimessaging.config;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LiquiMessaging {

	private List<Import> imports;
	
	private List<ChangeSet> changeSets;
	
	private List<Profile> availableProfiles;

	@XmlElementWrapper(name="changeSets")
	@XmlElement(name="changeSet")
	public List<ChangeSet> getChangeSets() {
		return changeSets;
	}

	public void setChangeSets(List<ChangeSet> changeSets) {
		this.changeSets = changeSets;
	}

	@XmlElementWrapper(name="imports")
	@XmlElement(name="import")
	public List<Import> getImports() {
		return imports;
	}

	public void setImports(List<Import> imports) {
		this.imports = imports;
	}

	@XmlElementWrapper(name="profiles")
	@XmlElement(name="profile")
	public List<Profile> getAvailableProfiles() {
		return availableProfiles;
	}

	public void setAvailableProfiles(List<Profile> availableProfiles) {
		this.availableProfiles = availableProfiles;
	}
	
}
