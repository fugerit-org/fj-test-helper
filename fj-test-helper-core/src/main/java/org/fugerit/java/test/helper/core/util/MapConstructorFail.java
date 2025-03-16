package org.fugerit.java.test.helper.core.util;

import org.fugerit.java.test.helper.core.FailHelper;

import java.util.HashMap;

public class MapConstructorFail<K, V> extends HashMap<K, V> {

	private static final long serialVersionUID = 17693314144969088L;

	private transient FailHelper helper;

	public MapConstructorFail( FailHelper helper ) {
		super();
		this.helper = helper;
		this.helper.handleFail();
	}

	public MapConstructorFail(boolean fail ) {
		this( new FailHelper( fail ) );
	}

	public MapConstructorFail() {
		this( new FailHelper() );
	}

	@Override
	public boolean equals( Object o ) {
		return super.equals( o );
	}

}
