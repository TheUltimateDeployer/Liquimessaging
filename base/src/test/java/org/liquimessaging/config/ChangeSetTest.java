package org.liquimessaging.config;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class ChangeSetTest {

	ChangeSet cs = new ChangeSet();
	
	@Test
	public void testExecute() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddChange() {
		Change change = new GenericQueueConfig();
		cs.addChange(change);
		List<Change> changes = cs.getChanges();
		assertTrue(changes.contains(change));
	}

	@Test
	public void testIsFailOnError() {
		testSetFailOnError();
	}

	@Test
	public void testSetFailOnError() {
		cs.setFailOnError(true);
		assertTrue(cs.isFailOnError());
		cs.setFailOnError(false);
		assertFalse(cs.isFailOnError());
	}

	@Test
	public void testGetAuthor() {
		testSetAuthor();
	}

	@Test
	public void testSetAuthor() {
		cs.setAuthor("che");
		assertEquals("che", cs.getAuthor());
	}

	@Test
	public void testGetId() {
		testSetId();
	}

	@Test
	public void testSetId() {
		cs.setId("Ticket-123");
		assertEquals("Ticket-123", cs.getId());
	}

	@Test
	public void testGetProfile() {
		testSetProfile();
	}

	@Test
	public void testSetProfile() {
		cs.setProfile("profiles");
		assertEquals("profiles", cs.getProfile());
	}

}
