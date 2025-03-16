package org.fugerit.java.test.helper.core.util;


import org.fugerit.java.test.helper.core.FailHelper;

import java.util.ArrayList;

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
