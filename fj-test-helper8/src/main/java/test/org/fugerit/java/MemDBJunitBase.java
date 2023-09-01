package test.org.fugerit.java;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.fugerit.java.core.cfg.ConfigRuntimeException;
import org.fugerit.java.test.db.helper.MemTestDBHelper;

import test.org.fugerit.java.helpers.FailHelper;

public class MemDBJunitBase extends BasicTest {

	private Connection conn;

	public MemDBJunitBase( boolean fail ) {
		try {
			this.conn = MemTestDBHelper.newConnection( fail );
		} catch ( Exception e) {
			throw new ConfigRuntimeException( "Init error "+e, e );
		}
	}
	
	public MemDBJunitBase() {
		this( FailHelper.NO_FAIL );
	}

	public Connection getConnection() {
		return this.conn;
	}
	
	public void simpleTestSelectWorker( String select ) {
		try ( Connection conn = this.getConnection();
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery( select ) ) {
			int read = 0;
			while ( rs.next() ) {
				read++;
			}
			logger.info( "total record read from table : "+read );
		} catch (Exception e) {
			this.failEx(e);
		}
	}
	
}
