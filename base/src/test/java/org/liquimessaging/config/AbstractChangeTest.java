package org.liquimessaging.config;

import static org.junit.Assert.*;

import org.junit.Test;
import org.liquimessaging.config.command.Command;

public class AbstractChangeTest {

	TestChange tc = new TestChange();
	
	
	class TestChange extends AbstractChange {
		
		private boolean executed = false;
		@Override
		public void execute() throws ChangeException {
			executed = true;
		}
		
		public boolean isExecuted() {
			return executed;
		}
	}
	
	@Test
	public void testIsFailOnError() {
		tc.setFailOnError(true);
		assertTrue(tc.isFailOnError());
		tc.setFailOnError(false);
		assertFalse(tc.isFailOnError());
	}

	@Test
	public void testExecute() {
		try {
			tc.execute();
		} catch (ChangeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(tc.executed);
	}

	@Test
	public void testGetCommand() {
		testSetCommand();
	}

	@Test
	public void testSetCommand() {
		tc.setCommand(Command.CREATE);
		assertEquals(Command.CREATE, tc.getCommand());
	}

}
