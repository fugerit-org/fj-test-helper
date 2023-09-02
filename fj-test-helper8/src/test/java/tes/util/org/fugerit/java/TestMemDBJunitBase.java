package tes.util.org.fugerit.java;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import test.org.fugerit.java.MemDBJunitBase;
import test.util.org.fugerit.java.core.db.helpers.TestMemDBHelper;

public class TestMemDBJunitBase extends MemDBJunitBase {

	@BeforeClass
	public static void init() {
		TestMemDBHelper.init();
	}
	
	@Test
	public void testSelectFail() {
		Assert.assertThrows( AssertionError.class , () -> { this.simpleTestSelectWorker( "SELECT TEST " ); } );
	}
	
}
