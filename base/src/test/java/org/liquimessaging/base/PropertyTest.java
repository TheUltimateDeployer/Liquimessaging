package org.liquimessaging.base;

import static org.junit.Assert.*;

import org.junit.Test;

public class PropertyTest {

	@Test
	public void testHashCode() {
		Property pro = new Property("test", "string");
		assertTrue(pro.hashCode() != 0);
	}

	@Test
	public void testProperty() {
		Property pro = new Property();
		assertNotNull(pro);
	}

	@Test
	public void testPropertyStringString() {
		Property pro = new Property("test", "string");
		assertNotNull(pro);
	}

	@Test
	public void testGetValue() {
		Property pro = new Property("test", "string");
		assertEquals(pro.getValue(), "string");
	}

	@Test
	public void testGetName() {
		Property pro = new Property("test", "string");
		assertEquals(pro.getName(), "test");
	}

	@Test
	public void testEqualsObject() {
		Property pro = new Property("test", "string");
		Property pro2 = new Property("test", "string");
		assertEquals(pro,pro2);
	}

}
