package test.org.fugerit.java.helpers.util;

import java.util.ArrayList;
import java.util.Collection;

import test.org.fugerit.java.helpers.FailHelper;

public class ListConstructorFail<T> extends ArrayList<T> {

	private static final long serialVersionUID = 1769331402144969088L;

	public ListConstructorFail() {
		super();
		FailHelper.fail();
	}

	public ListConstructorFail(Collection<? extends T> c) {
		super(c);
		FailHelper.fail();
	}
	
}
