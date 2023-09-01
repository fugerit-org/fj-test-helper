package test.org.fugerit.java.helpers.util;

import java.util.ArrayList;
import java.util.Collection;

import test.org.fugerit.java.helpers.FailHelper;

public class ListStringConstructorFail extends ArrayList<String> {

	private static final long serialVersionUID = 1769331402144969088L;

	public ListStringConstructorFail() {
		super();
		FailHelper.fail();
	}

	public ListStringConstructorFail(Collection<String> c) {
		super(c);
		FailHelper.fail();
	}
	
}
