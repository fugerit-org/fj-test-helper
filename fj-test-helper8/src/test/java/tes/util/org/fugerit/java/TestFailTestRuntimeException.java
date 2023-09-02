package tes.util.org.fugerit.java;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import test.org.fugerit.java.helpers.FailTestRuntimeException;

public class TestFailTestRuntimeException {

	private static final Exception CAUSE_EX = new IOException( "cause" );
	
	private static final Exception CAUSE_EX_FAIL = new FailTestRuntimeException( "cause" );
	
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
			throw new FailTestRuntimeException( CAUSE_EX );
		} );
	}
	
	@Test
	public void testInit4() {
		Assert.assertThrows( FailTestRuntimeException.class , () -> {
			throw new FailTestRuntimeException( "fail", CAUSE_EX );
		} );
	}
	
	@Test
	public void testInit5() {
		Assert.assertThrows( FailTestRuntimeException.class , () -> {
			throw FailTestRuntimeException.convertEx( CAUSE_EX );
		} );
	}
	
	@Test
	public void testInit6() {
		Assert.assertThrows( FailTestRuntimeException.class , () -> {
			throw FailTestRuntimeException.convertEx( "fail", CAUSE_EX );
		} );
	}
	
	@Test
	public void testInit7() {
		Assert.assertThrows( FailTestRuntimeException.class , () -> {
			throw FailTestRuntimeException.convertExMethod( "testInit", CAUSE_EX );
		} );
	}
	
	@Test
	public void testInit8() {
		Assert.assertThrows( FailTestRuntimeException.class , () -> {
			throw FailTestRuntimeException.convertExMethod( "testInit", CAUSE_EX_FAIL );
		} );
	}
	
	@Test
	public void testInit() {
		Assert.assertThrows( FailTestRuntimeException.class , () -> {
			throw FailTestRuntimeException.stadardExceptionWrapping( CAUSE_EX );
		} );
	}
	
}
