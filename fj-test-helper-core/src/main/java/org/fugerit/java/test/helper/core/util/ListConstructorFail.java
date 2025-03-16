package org.fugerit.java.test.helper.core.util;


import org.fugerit.java.test.helper.core.FailHelper;

import java.util.ArrayList;

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
