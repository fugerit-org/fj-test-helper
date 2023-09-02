package tes.util.org.fugerit.java;

import java.sql.Connection;

import org.fugerit.java.core.db.connect.ConnectionFactory;
import org.fugerit.java.core.db.dao.DAOException;
import org.fugerit.java.test.db.helper.MemTestDBHelper;
import org.junit.Assert;
import org.junit.Test;

import test.org.fugerit.java.BasicTest;
import test.org.fugerit.java.helpers.FailHelper;

public class TestMemTestDBHelper extends BasicTest {

	@Test
	public void testConstructor1() {
		MemTestDBHelper obj = new MemTestDBHelper( FailHelper.NO_FAIL );
		logger.info( "obj : {}", obj );
		Assert.assertNotNull( obj );
	}
	
	@Test
	public void testConstructor2() {
		MemTestDBHelper obj = new MemTestDBHelper();
		logger.info( "obj : {}", obj );
		Assert.assertNotNull( obj );
	}
	
	@Test
	public void testCf() {
		ConnectionFactory cf = MemTestDBHelper.newCF();
		try ( Connection conn = cf.getConnection() ) {
			logger.info( "conn ok {} db info : {}", conn, cf.getDataBaseInfo() );
		} catch (Exception e) {
			this.failEx(e);
		} finally {
			try {
				cf.release();
			} catch (DAOException e) {
				this.failEx(e);
			}
		}
	}
	
}
