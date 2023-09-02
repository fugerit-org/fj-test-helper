package tes.util.org.fugerit.java;

import java.io.IOException;
import java.util.Base64;

import org.fugerit.java.core.cfg.ConfigException;
import org.junit.Assert;
import org.junit.Test;

import test.org.fugerit.java.BasicTest;

public class TestBasicTest extends BasicTest {

	private static final String BASE_64_OBJ_NOT_FOUND = "rO0ABXNyACN0ZXMudXRpbC5vcmcuZnVnZXJpdC5qYXZhLlNlcmlhbE9iaqpuE+tUyIL0AgABTAAFZmllbGR0ABJMamF2YS9sYW5nL1N0cmluZzt4cHQABHRlc3Q=";
	
	private static final String BASE_64_OBJ_FOUND = "rO0ABXNyACZ0ZXMudXRpbC5vcmcuZnVnZXJpdC5qYXZhLlNlcmlhbE9iamVjdP/9zzUBm0r0AgABTAAFZmllbGR0ABJMamF2YS9sYW5nL1N0cmluZzt4cHQABHRlc3Q=";
	
	private static final Exception CAUSE_EX = new ConfigException( "cause" );
	
	@Test
	public void testFailEx() {
		Assert.assertThrows( AssertionError.class , () -> { this.failEx( CAUSE_EX ); } );
	}
	
	@Test
	public void testFullSerialize() {
		String test = "test string";
		try {
			String deserTest = (String) this.fullSerializationTest(test);
			logger.info( "test {} - {}", test, deserTest );
			Assert.assertEquals( test , deserTest );
		} catch (IOException e) {
			this.failEx(e);
		}
	}
	
	@Test
	public void testToBase64() {
		try {
			SerialObject obj = new SerialObject();
			obj.setField( "test" );
			byte[] data = this.serializeTest( obj );
			String base64 = Base64.getEncoder().encodeToString( data );
			logger.info( "obj : {}, base64 : '{}'", obj, base64 );
			Assert.assertNotNull( base64 );
		} catch (IOException e) {
			this.failEx(e);
		}
	}
	
	@Test
	public void testFromBase64() {
		try {
			byte[] data = Base64.getDecoder().decode(BASE_64_OBJ_FOUND);
			Object obj = this.deserializeTest( data );
			Assert.assertNotNull( obj );
		} catch (IOException e) {
			this.failEx(e);
		}
	}
	
	@Test
	public void testFromBase64NotFound() {
		Assert.assertThrows( IOException.class , () -> {
			byte[] data = Base64.getDecoder().decode(BASE_64_OBJ_NOT_FOUND);
			Object obj = this.deserializeTest( data );
			logger.info( "obj -> {}", obj );
		} );
	}
	
}