package org.fugerit.java.test.helper.core;

import org.fugerit.java.core.cfg.ConfigRuntimeException;


public class FailHelper {

	private FailHelper() {}
	
	public static final boolean DO_FAIL = true;
	
	public static final boolean NO_FAIL = false;

	private static boolean defaultBehaviour = DO_FAIL;

	public static final String DEFAULT_FAIL_MESSAGE = "Expected exception for test design";

	public static boolean isDefaultBehaviour() {
		return defaultBehaviour;
	}

	public static void setDefaultBehaviour(boolean defaultBehaviour) {
		FailHelper.defaultBehaviour = defaultBehaviour;
	}

	public static void fail( boolean fail, String message ) {
		if ( fail ) {
			throw new ConfigRuntimeException( message );
		}
	}
	
	public static void fail( boolean fail ) {
		fail( fail, DEFAULT_FAIL_MESSAGE );
	}
	
	public static void fail( String message ) {
		fail( defaultBehaviour, message );
	}
	
	public static void fail() {
		fail( defaultBehaviour, DEFAULT_FAIL_MESSAGE );
	}
	
}
