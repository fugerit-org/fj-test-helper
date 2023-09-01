package tes.util.org.fugerit.java.helpers.util;

import org.fugerit.java.core.cfg.ConfigRuntimeException;
import org.junit.Assert;
import org.junit.Test;

import test.org.fugerit.java.helpers.FailHelper;
import test.org.fugerit.java.helpers.util.ListStringConstructorFail;

public class TestListConstructorFail {

	@Test
	public void testInitFail() {
		Assert.assertThrows( ConfigRuntimeException.class , () -> {
			new ListStringConstructorFail();
		} );
	}
	
	@Test
	public void testInitOk() {
		Object obj = new ListStringConstructorFail( FailHelper.NO_FAIL );
		Assert.assertNotNull( obj );
	}
	
}
