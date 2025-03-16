package tes.util.org.fugerit.java.helpers;

import org.fugerit.java.core.cfg.ConfigRuntimeException;
import org.junit.Assert;
import org.junit.Test;

import test.org.fugerit.java.helpers.FailHelper;

public class TestFailHelper {

	@Test
	public void testBase() {
		Assert.assertThrows( ConfigRuntimeException.class , FailHelper::fail );
	}
	
	@Test
	public void testMessage() {
		Assert.assertThrows( ConfigRuntimeException.class , () -> {
			FailHelper.fail( "Fail" );
		});
	}
	
	@Test
	public void testBaseAlt() {
		boolean ok = false;
		FailHelper.fail(FailHelper.NO_FAIL);
		ok = true;
		Assert.assertTrue( ok );
	}
	
	@Test
	public void testMessageAlt() {
		boolean ok = false;
		FailHelper.fail( FailHelper.NO_FAIL, "Fail" );
		ok = true;
		Assert.assertTrue( ok );
	}
	
}
