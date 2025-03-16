package org.fugerit.java.test.helper.core;

import lombok.extern.slf4j.Slf4j;
import org.fugerit.java.core.cfg.ConfigRuntimeException;

@Slf4j
public class FailHelper {

	private boolean fail;

	public FailHelper( boolean fail ) {
		this.fail = fail;
		log.info( "init : {}", this.fail );
	}

	public FailHelper() {
		this( NO_FAIL );
	}

	public void handleFail( String message ) {
		log.info( "fail : {}, message : {}", this.fail, message );
		if ( fail ) {
			throw new ConfigRuntimeException( message );
		}
	}

	public void handleFail() {
		handleFail( DEFAULT_FAIL_MESSAGE );
	}

	public boolean isFail() {
		return this.fail;
	}

	public static final boolean DO_FAIL = true;
	
	public static final boolean NO_FAIL = false;

	private static FailHelper defaultBehaviour = new FailHelper( DO_FAIL );

	public static final String DEFAULT_FAIL_MESSAGE = "Expected exception for test design";

	public static FailHelper getDefaultBehaviour() {
		return defaultBehaviour;
	}

	public static void setDefaultBehaviour(FailHelper defaultBehaviour) {
		FailHelper.defaultBehaviour = defaultBehaviour;
	}

	public static void fail( boolean fail, String message ) {
		new FailHelper( fail ).handleFail( message );
	}
	
	public static void fail( boolean fail ) {
		new FailHelper( fail ).handleFail();
	}
	
	public static void fail( String message ) {
		defaultBehaviour.handleFail( message);
	}
	
	public static void fail() {
		defaultBehaviour.handleFail();
	}
	
}
