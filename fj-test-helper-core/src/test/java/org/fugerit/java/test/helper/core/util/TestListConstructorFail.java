package org.fugerit.java.test.helper.core.util;

import org.fugerit.java.core.cfg.ConfigRuntimeException;
import org.fugerit.java.test.helper.core.FailHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestListConstructorFail {

	@Test
	void testInitFail() {
		Assertions.assertThrows( ConfigRuntimeException.class , ListStringConstructorFail::new );
	}
	
	@Test
	void testInitOk() {
		Object obj = new ListStringConstructorFail( FailHelper.NO_FAIL );
		Assertions.assertNotNull( obj );
	}
	
}
