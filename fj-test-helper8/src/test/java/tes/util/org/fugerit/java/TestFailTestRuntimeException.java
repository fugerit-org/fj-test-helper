package tes.util.org.fugerit.java;

import org.fugerit.java.core.cfg.ConfigException;
import org.junit.Assert;
import org.junit.Test;

import test.org.fugerit.java.helpers.FailTestRuntimeException;

public class TestFailTestRuntimeException {

	@Test
	public void testInit1() {
		Assert.assertThrows( FailTestRuntimeException.class , () -> {
			throw new FailTestRuntimeException();
		} );
	}
	
	@Test
	public void testInit2() {
		Assert.assertThrows( FailTestRuntimeException.class , () -> {
			throw new FailTestRuntimeException( "fail" );
		} );
	}
	
	@Test
	public void testInit3() {
		Assert.assertThrows( FailTestRuntimeException.class , () -> {
			throw new FailTestRuntimeException( new ConfigException( "cause" ) );
		} );
	}
	
	@Test
	public void testInit4() {
		Assert.assertThrows( FailTestRuntimeException.class , () -> {
			throw new FailTestRuntimeException( "fail", new ConfigException( "cause" ) );
		} );
	}
	
	@Test
	public void testInit5() {
		Assert.assertThrows( FailTestRuntimeException.class , () -> {
			throw FailTestRuntimeException.convertEx( new ConfigException( "cause" ) );
		} );
	}
	
	@Test
	public void testInit6() {
		Assert.assertThrows( FailTestRuntimeException.class , () -> {
			throw FailTestRuntimeException.convertEx( "fail", new ConfigException( "cause" ) );
		} );
	}
	
	@Test
	public void testInit7() {
		Assert.assertThrows( FailTestRuntimeException.class , () -> {
			throw FailTestRuntimeException.convertExMethod( "testInit", new ConfigException( "cause" ) );
		} );
	}
	
	@Test
	public void testInit8() {
		Assert.assertThrows( FailTestRuntimeException.class , () -> {
			throw FailTestRuntimeException.convertExMethod( "testInit", new FailTestRuntimeException( "cause" ) );
		} );
	}
	
	@Test
	public void testInit() {
		Assert.assertThrows( FailTestRuntimeException.class , () -> {
			throw FailTestRuntimeException.stadardExceptionWrapping( new FailTestRuntimeException( "cause" ) );
		} );
	}
	
}
