package org.fugerit.java.test.helper.core.io;


import org.fugerit.java.test.helper.core.FailHelper;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamFail extends InputStream {

	private boolean fail;

	public InputStreamFail() {
		this( FailHelper.DO_FAIL );
	}

	public InputStreamFail(boolean fail) {
		this.fail = fail;
	}
	
	@Override
	public int read() throws IOException {
		FailHelper.fail( this.fail );
		return -1;
	}

}
