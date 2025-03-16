package org.fugerit.java.test.helper.core;

import org.fugerit.java.core.cfg.ConfigRuntimeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestFailHelper {

	@Test
	void testBase() {
		Assertions.assertThrows( ConfigRuntimeException.class , () -> {
			FailHelper.fail();
		});
	}
	
	@Test
	void testMessage() {
		Assertions.assertThrows( ConfigRuntimeException.class , () -> {
			FailHelper.fail( "Fail" );
		});
	}
	
	@Test
	void testBaseAlt() {
		boolean ok = false;
		FailHelper.fail(FailHelper.NO_FAIL);
		ok = true;
		Assertions.assertTrue( ok );
	}
	
	@Test
	void testMessageAlt() {
		boolean ok = false;
		FailHelper.fail( FailHelper.NO_FAIL, "Fail" );
		ok = true;
		Assertions.assertTrue( ok );
	}
	
}
