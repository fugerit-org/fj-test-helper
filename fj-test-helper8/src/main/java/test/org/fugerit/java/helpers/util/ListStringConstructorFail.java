package test.org.fugerit.java.helpers.util;

import java.util.ArrayList;

import test.org.fugerit.java.helpers.FailHelper;

public class ListStringConstructorFail extends ArrayList<String> {

	private static final long serialVersionUID = 1769331402144969088L;

	public ListStringConstructorFail( boolean fail ) {
		super();
		FailHelper.fail( fail );
	}
	
	public ListStringConstructorFail() {
		this( FailHelper.DO_FAIL );
	}
	
}
