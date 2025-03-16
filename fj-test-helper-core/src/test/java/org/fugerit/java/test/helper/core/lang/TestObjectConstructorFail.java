package org.fugerit.java.test.helper.core.lang;

import org.fugerit.java.core.cfg.ConfigRuntimeException;
import org.fugerit.java.test.helper.core.FailHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestObjectConstructorFail {

	@Test
	void testInitFail() {
		Assertions.assertThrows( ConfigRuntimeException.class , ObjectConstructorFail::new );
	}

	@Test
	void testInitOk() {
		ObjectConstructorFail obj = new ObjectConstructorFail( FailHelper.NO_FAIL );
		Assertions.assertNotNull( obj );
	}
	
}
