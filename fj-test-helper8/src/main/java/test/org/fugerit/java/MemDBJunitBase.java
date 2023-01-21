package test.org.fugerit.java;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.fugerit.java.test.db.helper.MemTestDBHelper;

public class MemDBJunitBase extends BasicTest {

	private Connection conn;
	
	public MemDBJunitBase() {
		try {
			this.conn = MemTestDBHelper.newConnection();
		} catch ( Exception e) {
			throw new RuntimeException( "Init error "+e, e );
		}
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
