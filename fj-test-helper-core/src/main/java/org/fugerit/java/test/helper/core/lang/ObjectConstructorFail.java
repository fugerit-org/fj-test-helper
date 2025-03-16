package org.fugerit.java.test.helper.core.lang;


import org.fugerit.java.test.helper.core.FailHelper;

public class ObjectConstructorFail {

	public ObjectConstructorFail( boolean fail ) {
		FailHelper.fail( fail );
	}

	public ObjectConstructorFail() {
		this( FailHelper.DO_FAIL );
	}
	
}
