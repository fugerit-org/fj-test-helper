package org.fugerit.java.test.helper.core.util;

import org.fugerit.java.core.cfg.ConfigRuntimeException;
import org.fugerit.java.test.helper.core.FailHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestMapConstructorFail {

	@Test
	void testInitFail() {
		Assertions.assertThrows( ConfigRuntimeException.class , MapConstructorFail::new );
	}
	
	@Test
	void testInitOk() {
		Assertions.assertNotNull( new MapConstructorFail<>( FailHelper.NO_FAIL ) );
	}
	
}
