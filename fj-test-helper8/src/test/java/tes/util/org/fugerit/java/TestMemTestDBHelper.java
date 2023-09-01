package tes.util.org.fugerit.java;

import org.fugerit.java.test.db.helper.MemTestDBHelper;
import org.junit.Assert;
import org.junit.Test;

import test.org.fugerit.java.helpers.FailHelper;

public class TestMemTestDBHelper {

	@Test
	public void testConstructor1() {
		MemTestDBHelper obj = new MemTestDBHelper( FailHelper.NO_FAIL );
		Assert.assertNotNull( obj );
	}
	
	@Test
	public void testConstructor2() {
		MemTestDBHelper obj = new MemTestDBHelper();
		Assert.assertNotNull( obj );
	}
	
}
