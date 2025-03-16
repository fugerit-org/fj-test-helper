package org.fugerit.java.test.helper.core.util;


import lombok.extern.slf4j.Slf4j;
import org.fugerit.java.test.helper.core.FailHelper;

import java.util.ArrayList;

@Slf4j
public class ListConstructorFail<T> extends ArrayList<T> {

	private static final long serialVersionUID = 1769331402144969088L;

	private transient FailHelper helper;

	public ListConstructorFail( FailHelper helper ) {
		super();
		this.helper = helper;
		log.info( "init 1 : helper fail : {}", this.helper.isFail() );
		this.helper.handleFail();
		log.info( "init 2 : helper fail : {}", this.helper.isFail() );
	}

	public ListConstructorFail( boolean fail ) {
		this( new FailHelper( fail ) );
	}
	
	public ListConstructorFail() {
		this( new FailHelper() );
	}

	@Override
	public boolean equals( Object o ) {
		return super.equals( o );
	}

}
