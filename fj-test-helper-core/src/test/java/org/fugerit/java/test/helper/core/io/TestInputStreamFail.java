package org.fugerit.java.test.helper.core.io;

import org.fugerit.java.core.cfg.ConfigRuntimeException;
import org.fugerit.java.core.io.StreamIO;
import org.fugerit.java.test.helper.core.FailHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

 class TestInputStreamFail {

	@Test
	void testInitFail() throws IOException {
		try ( InputStreamFail is = new InputStreamFail() ) {
			Assertions.assertThrows( ConfigRuntimeException.class, () -> StreamIO.readString(is) );
		}
	}
	
	@Test 
	void voidTestInitOk() throws IOException {
		try ( InputStreamFail is = new InputStreamFail( FailHelper.NO_FAIL ) ) {
			Assertions.assertTrue( StreamIO.readString( is ).isEmpty() );
		}
	}
	
}
