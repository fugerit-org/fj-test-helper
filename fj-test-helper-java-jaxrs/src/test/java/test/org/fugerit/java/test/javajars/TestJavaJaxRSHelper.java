package test.org.fugerit.java.test.javajars;

import org.fugerit.java.test.javajars.JavaJaxRSHelper;
import org.junit.Assert;
import org.junit.Test;

public class TestJavaJaxRSHelper {

	@Test
	public void test() throws ClassNotFoundException {
		Assert.assertTrue( JavaJaxRSHelper.test() );
	}
	
}
