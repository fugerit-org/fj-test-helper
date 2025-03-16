package org.fugerit.java.test.helper.core.io;

import lombok.extern.slf4j.Slf4j;
import org.fugerit.java.core.cfg.ConfigRuntimeException;
import org.fugerit.java.core.io.StreamIO;
import org.fugerit.java.test.helper.core.FailHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@Slf4j
class TestReaderFail {

	@Test
	void testInit() throws IOException {
		try ( ReaderFail reader = new ReaderFail() ) {
			Assertions.assertThrows( ConfigRuntimeException.class, () -> {
					StreamIO.readString(reader);
			} );
		}
	}
	
	@Test 
	void voidTestInitOk() throws IOException {
		try ( ReaderFail reader = new ReaderFail( FailHelper.NO_FAIL ) ) {
			log.info( "test {}", StreamIO.readString(reader) );
			Assertions.assertTrue( Boolean.TRUE );
		}
	}
	
}
