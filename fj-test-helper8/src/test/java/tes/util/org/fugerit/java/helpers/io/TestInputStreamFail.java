package tes.util.org.fugerit.java.helpers.io;

import java.io.IOException;

import org.fugerit.java.core.cfg.ConfigRuntimeException;
import org.fugerit.java.core.io.StreamIO;
import org.junit.Assert;
import org.junit.Test;

import test.org.fugerit.java.BasicTest;
import test.org.fugerit.java.helpers.FailHelper;
import test.org.fugerit.java.helpers.io.InputStreamFail;

public class TestInputStreamFail extends BasicTest {

	@Test
	public void testInitFail() throws IOException {
		runTestEx( () -> {
			try ( InputStreamFail is = new InputStreamFail() ) {
				Assert.assertThrows( ConfigRuntimeException.class, () -> {
					StreamIO.readString(is);
				} );
			}
		} );
	}
	
	@Test 
	public void voidTestInitOk() {
		runTestEx( () -> {
			try ( InputStreamFail is = new InputStreamFail( FailHelper.NO_FAIL ) ) {
				logger.info( "test {}", StreamIO.readString(is) );
			}
		} );
	}
	
}
