package tes.util.org.fugerit.java.helpers.lang;

import org.fugerit.java.core.cfg.ConfigRuntimeException;
import org.junit.Assert;
import org.junit.Test;

import test.org.fugerit.java.helpers.FailHelper;
import test.org.fugerit.java.helpers.lang.ObjectConstructorFail;

public class TestObjectConstructorFail {

	@Test
	public void testInitFail() {
		Assert.assertThrows( ConfigRuntimeException.class , () -> {
			new ObjectConstructorFail();
		} );
	}

	@Test
	public void testInitOk() {
		ObjectConstructorFail obj = new ObjectConstructorFail( FailHelper.NO_FAIL );
		Assert.assertNotNull( obj );
	}
	
}
