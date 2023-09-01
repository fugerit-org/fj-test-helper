package test.org.fugerit.java.helpers.io;

import java.io.IOException;
import java.io.Reader;

import test.org.fugerit.java.helpers.FailHelper;

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
