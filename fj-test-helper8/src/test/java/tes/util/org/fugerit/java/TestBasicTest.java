package tes.util.org.fugerit.java;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import org.fugerit.java.core.cfg.ConfigException;
import org.fugerit.java.core.function.SimpleValue;
import org.fugerit.java.core.io.StreamIO;
import org.junit.Assert;
import org.junit.Test;

import test.org.fugerit.java.BasicTest;
import test.org.fugerit.java.helpers.io.InputStreamFail;

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
	public void testRunTestEx1() {
		SimpleValue<Boolean> result = new SimpleValue<Boolean>( true );
		Assert.assertThrows( AssertionError.class , () -> {
			runTestEx( () -> {
				try ( InputStream is = new InputStreamFail() ) {
					StreamIO.readBytes( is );
					result.setValue( false ); // should not get to this line
				}
			} );
		});
		Assert.assertTrue( result.getValue() );
	}

	@Test
	public void testRunTestEx2() {
		SimpleValue<Boolean> result = new SimpleValue<Boolean>( false );
		runTestEx( () -> {
			try ( InputStream is = new ByteArrayInputStream( "a".getBytes() ) ) {
				StreamIO.readBytes( is );
				result.setValue( true );
			}
		} );
		Assert.assertTrue( result.getValue() );
	}
	
	@Test
	public void testRunTestSilent1() {
		SimpleValue<Boolean> result = new SimpleValue<Boolean>( true );
		runTestSilent( () -> {
			try ( InputStream is = new InputStreamFail() ) {
				StreamIO.readBytes( is );
				result.setValue( false ); // should not get to this line
			}
		} );
		Assert.assertTrue( result.getValue() );
	}

	@Test
	public void testRunTestSilent2() {
		SimpleValue<Boolean> result = new SimpleValue<Boolean>( false );
		runTestSilent( () -> {
			try ( InputStream is = new ByteArrayInputStream( "a".getBytes() ) ) {
				StreamIO.readBytes( is );
				result.setValue( true );
			}
		} );
		Assert.assertTrue( result.getValue() );
	}
	
	@Test
	public void testRunTestCustom1() {
		SimpleValue<Boolean> result = new SimpleValue<Boolean>( true );
		runTestCustom( () -> {
			try ( InputStream is = new InputStreamFail() ) {
				StreamIO.readBytes( is );
				result.setValue( false ); // should not get to this line
			}
		}, EX_CONSUMER_LOG );
		Assert.assertTrue( result.getValue() );
	}

	@Test
	public void testRunTestCustom2() {
		SimpleValue<Boolean> result = new SimpleValue<Boolean>( false );
		runTestCustom( () -> {
			try ( InputStream is = new ByteArrayInputStream( "a".getBytes() ) ) {
				StreamIO.readBytes( is );
				result.setValue( true );
			}
		}, EX_CONSUMER_LOG );
		Assert.assertTrue( result.getValue() );
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