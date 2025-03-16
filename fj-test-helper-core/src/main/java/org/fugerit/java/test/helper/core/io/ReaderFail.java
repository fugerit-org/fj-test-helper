package org.fugerit.java.test.helper.core.io;

import org.fugerit.java.test.helper.core.FailHelper;

import java.io.IOException;
import java.io.Reader;

public class ReaderFail extends Reader {

	private boolean fail;
	
	public ReaderFail() {
		this( FailHelper.DO_FAIL );
	}

	public ReaderFail(boolean fail) {
		this.fail = fail;
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		FailHelper.fail( this.fail );
		return 0;
	}

	@Override
	public void close() throws IOException {
		// do nothing
	}
	
}
