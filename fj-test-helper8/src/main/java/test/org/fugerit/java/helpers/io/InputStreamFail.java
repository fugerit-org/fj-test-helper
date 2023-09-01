package test.org.fugerit.java.helpers.io;

import java.io.IOException;
import java.io.InputStream;

import test.org.fugerit.java.helpers.FailHelper;

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
