package org.fugerit.java.test.javajars;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JavaJaxRSHelper {

	private JavaJaxRSHelper() {}
	
	public static boolean test() throws ClassNotFoundException {
		String testClass = "javax.ws.rs.GET";
		Class<?> c = Class.forName( testClass );
		log.info( "found {} -> {}", testClass, c );
		return c != null;
	}
	
}
