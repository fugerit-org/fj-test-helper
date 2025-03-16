package org.fugerit.java.test.helper.core.util;

import org.fugerit.java.core.cfg.ConfigRuntimeException;
import org.fugerit.java.test.helper.core.FailHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestListStringConstructorFail {

	@Test
	void testInitFail() {
		Assertions.assertThrows( ConfigRuntimeException.class , () -> {
			new ListConstructorFail<String>();
		} );
	}
	
	@Test
	void testInitOk() {
		Object obj = new ListConstructorFail<String>( FailHelper.NO_FAIL );
		Assertions.assertNotNull( obj );
	}
	
}
