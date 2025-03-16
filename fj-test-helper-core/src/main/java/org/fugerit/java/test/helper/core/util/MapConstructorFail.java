package org.fugerit.java.test.helper.core.util;

import org.fugerit.java.test.helper.core.FailHelper;

import java.util.HashMap;

public class MapConstructorFail<K, V> extends HashMap<K, V> {

	private static final long serialVersionUID = 1769331402144969088L;

	public MapConstructorFail(boolean fail ) {
		super();
		FailHelper.fail( fail );
	}

	public MapConstructorFail() {
		this( FailHelper.isDefaultBehaviour() );
	}
	
}
