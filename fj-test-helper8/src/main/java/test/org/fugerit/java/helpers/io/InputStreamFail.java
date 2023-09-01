package test.org.fugerit.java.helpers.io;

import java.io.IOException;
import java.io.InputStream;

import test.org.fugerit.java.helpers.FailHelper;

public class InputStreamFail extends InputStream {

	@Override
	public int read() throws IOException {
		FailHelper.fail();
		return 0;
	}

}
