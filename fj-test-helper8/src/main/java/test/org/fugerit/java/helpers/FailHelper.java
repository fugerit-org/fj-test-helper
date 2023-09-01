package test.org.fugerit.java.helpers;

import org.fugerit.java.core.cfg.ConfigRuntimeException;


public class FailHelper {

	private static final boolean FAIL = true;
	
	public static final String DEFAULT_FAIL_MESSAGE = "Expected exception for test design";
	
	public static void fail( String message ) {
		if ( FAIL ) {
			throw new ConfigRuntimeException( message );
		}
	}
	
	public static void fail() {
		fail( DEFAULT_FAIL_MESSAGE );
	}
	
}
