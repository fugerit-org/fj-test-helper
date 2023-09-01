package tes.util.org.fugerit.java;

import org.fugerit.java.core.cfg.ConfigRuntimeException;
import org.junit.Assert;
import org.junit.Test;

import test.org.fugerit.java.MemDBJunitBase;
import test.org.fugerit.java.helpers.FailHelper;

public class TestMemDBJunitBase extends MemDBJunitBase {

	@Test
	public void testInitFail() {
		Assert.assertThrows( ConfigRuntimeException.class , () -> { new MemDBJunitBase( FailHelper.DO_FAIL ); } );
	}
	
	@Test
	public void testInitOk() {
		Object obj = new MemDBJunitBase( FailHelper.NO_FAIL );
		Assert.assertNotNull( obj );;
	}
	
	@Test
	public void testSelectFail() {
		Assert.assertThrows( AssertionError.class , () -> { this.simpleTestSelectWorker( "SELECT TEST " ); } );
	}
	
}
