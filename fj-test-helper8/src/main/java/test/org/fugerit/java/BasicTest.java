package test.org.fugerit.java;

import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.function.Consumer;

import org.fugerit.java.core.function.SafeFunction;
import org.fugerit.java.core.function.UnsafeVoid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BasicTest {

	protected static Logger logger = LoggerFactory.getLogger( BasicTest.class ); // this variable is kept for compatibility
	
	public static final Consumer<Exception> EX_CONSUMER_FAIL = e -> {
		String message = "Error : "+e.getMessage();
		log.error( message, e );
		fail( message );
	};
	
	public static final Consumer<Exception> EX_CONSUMER_LOG = e -> log.error( "Suppress exception : "+e.getMessage(), e );
	
	public static void runTestEx( UnsafeVoid<Exception> fun ) {
		SafeFunction.apply( fun, EX_CONSUMER_FAIL );
	}
	
	public static void runTestSilent( UnsafeVoid<Exception> fun ) {
		SafeFunction.apply( fun, EX_CONSUMER_LOG );
	}
	
	public static void runTestCustom( UnsafeVoid<Exception> fun, Consumer<Exception> exHandler ) {
		SafeFunction.apply( fun, exHandler );
	}

	protected void failEx( Exception e ) {
		EX_CONSUMER_FAIL.accept(e);
	}
	
	public Object fullSerializationTest( Object value ) throws IOException {
		byte[] data = this.serializeTest(value);
		return this.deserializeTest(data);
	}
	
	public Object deserializeTest( byte[] data ) throws IOException {
		Object res = null;
		try ( ObjectInputStream ois = new ObjectInputStream( new ByteArrayInputStream( data ) ) ) {
			res = ois.readObject();
			log.info( "deserializeTest, read object : {}", res );
		} catch (ClassNotFoundException e) {
			throw new IOException( e.toString(), e );
		}
		return res;
	}
	
	public byte[] serializeTest( Object value ) throws IOException {
		byte[] res = null;
		try ( ByteArrayOutputStream os = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream( os ) ) {
			oos.writeObject( value );
			res = os.toByteArray();
			log.info( "serializeTest, total byte written : {}", res.length );
		}
		return res;
	}
	
}
