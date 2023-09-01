package test.org.fugerit.java;

import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicTest {

	protected final static Logger logger = LoggerFactory.getLogger( BasicTest.class );
	
	protected void failEx( Exception e ) {
		String message = "Error : "+e;
		logger.error( message, e );
		fail( message );
	}
	
	public Object fullSerializationTest( Object value ) throws IOException {
		byte[] data = this.serializeTest(value);
		return this.deserializeTest(data);
	}
	
	public Object deserializeTest( byte[] data ) throws IOException {
		Object res = null;
		try ( ObjectInputStream ois = new ObjectInputStream( new ByteArrayInputStream( data ) ) ) {
			res = ois.readObject();
			logger.info( "deserializeTest, read object : {}", res );
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
			logger.info( "serializeTest, total byte written : {}", res.length );
		}
		return res;
	}
	
}
