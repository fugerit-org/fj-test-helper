package org.fugerit.java.test.helper.core.util;


import org.fugerit.java.test.helper.core.FailHelper;

import java.util.ArrayList;

public class ListStringConstructorFail extends ArrayList<String> {

	private static final long serialVersionUID = 1769331402144969088L;

	private transient FailHelper helper;

	public ListStringConstructorFail( FailHelper helper ) {
		super();
		this.helper = helper;
		this.helper.handleFail();
	}

	public ListStringConstructorFail( boolean fail ) {
		this( new FailHelper( fail ) );
	}
	
	public ListStringConstructorFail() {
		this( new FailHelper() );
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals( Object o ) {
		return super.equals( o );
	}
	
}
