package org.fugerit.java.test.helper.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class TestFailTestRuntimeException {

	private static final Exception CAUSE_EX = new IOException( "cause" );
	
	private static final Exception CAUSE_EX_FAIL = new FailTestRuntimeException( "cause" );
	
	@Test
	void testInit1() {
		Assertions.assertThrows( FailTestRuntimeException.class , () -> {
			throw new FailTestRuntimeException();
		} );
	}
	
	@Test
	void testInit2() {
		Assertions.assertThrows( FailTestRuntimeException.class , () -> {
			throw new FailTestRuntimeException( "fail" );
		} );
	}
	
	@Test
	void testInit3() {
		Assertions.assertThrows( FailTestRuntimeException.class , () -> {
			throw new FailTestRuntimeException( CAUSE_EX );
		} );
	}
	
	@Test
	void testInit4() {
		Assertions.assertThrows( FailTestRuntimeException.class , () -> {
			throw new FailTestRuntimeException( "fail", CAUSE_EX );
		} );
	}
	
	@Test
	void testInit5() {
		Assertions.assertThrows( FailTestRuntimeException.class , () -> {
			throw FailTestRuntimeException.convertEx( CAUSE_EX );
		} );
	}
	
	@Test
	void testInit6() {
		Assertions.assertThrows( FailTestRuntimeException.class , () -> {
			throw FailTestRuntimeException.convertEx( "fail", CAUSE_EX );
		} );
	}
	
	@Test
	void testInit7() {
		Assertions.assertThrows( FailTestRuntimeException.class , () -> {
			throw FailTestRuntimeException.convertExMethod( "testInit", CAUSE_EX );
		} );
	}
	
	@Test
	void testInit8() {
		Assertions.assertThrows( FailTestRuntimeException.class , () -> {
			throw FailTestRuntimeException.convertExMethod( "testInit", CAUSE_EX_FAIL );
		} );
	}
	
	@Test
	void testInit() {
		Assertions.assertThrows( FailTestRuntimeException.class , () -> {
			throw FailTestRuntimeException.stadardExceptionWrapping( CAUSE_EX );
		} );
	}
	
}
