package test.org.fugerit.java.helpers.lang;

import test.org.fugerit.java.helpers.FailHelper;

public class ObjectConstructorFail {

	public ObjectConstructorFail( boolean fail ) {
		FailHelper.fail( fail );
	}

	public ObjectConstructorFail() {
		this( FailHelper.DO_FAIL );
	}
	
}
