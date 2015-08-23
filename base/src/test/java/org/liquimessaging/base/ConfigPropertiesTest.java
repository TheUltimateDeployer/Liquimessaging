package org.liquimessaging.base;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConfigPropertiesTest {

	ConfigProperties cp;
	
			@Test
	public void testEntries() {
		testAddEntry();
	}

	@Test
	public void testAddEntry() {
		cp = new ConfigProperties();
		Property prop = new Property("test", "string");
		cp.addEntry(prop);
		Property testProp = cp.entries().get(0);
		assertTrue(prop.equals(testProp));		
	}

}
