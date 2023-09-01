package test.org.fugerit.java.helpers.util;

import java.util.ArrayList;

import test.org.fugerit.java.helpers.FailHelper;

public class ListConstructorFail<T> extends ArrayList<T> {

	private static final long serialVersionUID = 1769331402144969088L;

	public ListConstructorFail( boolean fail ) {
		super();
		FailHelper.fail( fail );
	}
	
	public ListConstructorFail() {
		this( FailHelper.DO_FAIL );
	}
	
}
