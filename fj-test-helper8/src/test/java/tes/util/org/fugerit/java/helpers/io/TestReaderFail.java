package tes.util.org.fugerit.java.helpers.io;

import java.io.IOException;

import org.fugerit.java.core.cfg.ConfigRuntimeException;
import org.fugerit.java.core.io.StreamIO;
import org.junit.Assert;
import org.junit.Test;

import test.org.fugerit.java.BasicTest;
import test.org.fugerit.java.helpers.FailHelper;
import test.org.fugerit.java.helpers.io.ReaderFail;

public class TestReaderFail extends BasicTest {

	@Test
	public void testInit() {
		Assert.assertThrows( ConfigRuntimeException.class, () -> {
			try ( ReaderFail reader = new ReaderFail() ) {
				logger.info( "test {}", StreamIO.readString(reader) );
			}
		} );
	}
	
	@Test 
	public void voidTestInitOk() {
		try ( ReaderFail reader = new ReaderFail( FailHelper.NO_FAIL ) ) {
			logger.info( "test {}", StreamIO.readString(reader) );
		} catch (IOException e) {
			this.failEx(e);
		}
	}
	
}
