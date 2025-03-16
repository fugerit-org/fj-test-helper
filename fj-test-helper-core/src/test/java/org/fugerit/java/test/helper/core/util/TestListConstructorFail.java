package org.fugerit.java.test.helper.core.util;

import org.fugerit.java.core.cfg.ConfigRuntimeException;
import org.fugerit.java.test.helper.core.FailHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestListConstructorFail {

	@Test
	void testInitFail() {
		Assertions.assertThrows( ConfigRuntimeException.class , () ->  new ListConstructorFail<>( FailHelper.DO_FAIL ) );
	}
	
	@Test
	void testInitOk() {
		Assertions.assertNotNull( new ListConstructorFail( new FailHelper( FailHelper.NO_FAIL ) ) );
		Assertions.assertNotNull( new ListConstructorFail<>( FailHelper.NO_FAIL ) );
		Assertions.assertNotNull( new ListStringConstructorFail() );
	}
	
}
