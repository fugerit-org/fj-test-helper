package org.fugerit.java.test.helper.core;

import org.fugerit.java.core.cfg.ConfigRuntimeException;


public class FailHelper {

	private FailHelper() {}
	
	public static final boolean DO_FAIL = true;
	
	public static final boolean NO_FAIL = false;
	
	public static final String DEFAULT_FAIL_MESSAGE = "Expected exception for test design";
	
	public static void fail( boolean fail, String message ) {
		if ( fail ) {
			throw new ConfigRuntimeException( message );
		}
	}
	
	public static void fail( boolean fail ) {
		fail( fail, DEFAULT_FAIL_MESSAGE );
	}
	
	public static void fail( String message ) {
		fail( DO_FAIL, message );
	}
	
	public static void fail() {
		fail( DO_FAIL, DEFAULT_FAIL_MESSAGE );
	}
	
}
