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
		boolean failValue = FailHelper.isDefaultBehaviour();
		FailHelper.setDefaultBehaviour( FailHelper.NO_FAIL );
		Assertions.assertNotNull( new MapConstructorFail<>() );
		FailHelper.setDefaultBehaviour( failValue );
		Assertions.assertTrue( Boolean.TRUE );
	}
	
}
