package test.org.fugerit.java.helpers;

import org.fugerit.java.core.lang.ex.ExConverUtils;

public class FailTestRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 6212515648582606179L;

	public FailTestRuntimeException() {
		super();
	}

	public FailTestRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public FailTestRuntimeException(String message) {
		super(message);
	}

	public FailTestRuntimeException(Throwable cause) {
		super(cause);
	}
	
	public static FailTestRuntimeException stadardExceptionWrapping( Exception e ) throws FailTestRuntimeException {
		throw convertEx( "Configuration error", e );
	}
	
	public static FailTestRuntimeException convertEx( String baseMessage, Exception e ) {
		FailTestRuntimeException res = null;
		if ( e instanceof FailTestRuntimeException ) {
			res = (FailTestRuntimeException)e;
		} else {
			res = new FailTestRuntimeException( ExConverUtils.defaultMessage(baseMessage, e), e );
		}
		return res;
	}

	public static FailTestRuntimeException convertExMethod( String method, Exception e ) {
		return convertEx( ExConverUtils.defaultMethodMessage(method), e );
	}
	
	public static FailTestRuntimeException convertEx( Exception e ) {
		return convertEx( ExConverUtils.DEFAULT_CAUSE_MESSAGE, e );
	}
	
}
