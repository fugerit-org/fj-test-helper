package org.fugerit.java.test.db.helper;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.fugerit.java.core.db.connect.ConnectionFactory;
import org.fugerit.java.core.db.dao.DAOException;
import org.fugerit.java.core.db.helpers.SQLScriptReader;
import org.fugerit.java.core.db.metadata.DataBaseInfo;

public class MemTestDBHelper {

	public static final String DRV = "db-mode-dc-drv";
	public static final String URL = "db-mode-dc-url";
	public static final String USR = "db-mode-dc-usr";
	public static final String PWD = "db-mode-dc-pwd";

	private static Properties cf;
	
	private static Connection newConnection( Properties props ) throws Exception {
		Class.forName( props.getProperty( DRV ) );
		return DriverManager.getConnection( props.getProperty( URL ), props.getProperty( USR ), props.getProperty( PWD ) );
	}

    public static void init( String dbConnPath, String... dbInitScripts ) throws Exception
    {
    	if ( cf == null ) {
    		try ( InputStream is = MemTestDBHelper.class.getClassLoader().getResourceAsStream( dbConnPath ) ) {
    			Properties props = new Properties();
    			props.load( is );
            	try ( Connection conn = newConnection( props ) ) {
            		for ( int k=0; k<dbInitScripts.length; k++ ) {
            			try ( SQLScriptReader reader = new SQLScriptReader( MemTestDBHelper.class.getClassLoader().getResourceAsStream( dbInitScripts[k] ) ) ) {
                			executeAll(reader, conn);
                			cf = props;
                		}	
            		}
        		}	
    		}
    	}
    } 
    
    public static Connection newConnection() throws Exception {
    	return newConnection( cf );
    }
    

	public static ConnectionFactory newCF() {
		return new ConnectionFactory() {
			@Override
			public void release() throws DAOException {
			}
			
			@Override
			public DataBaseInfo getDataBaseInfo() throws DAOException {
				return null;
			}
			@Override
			public Connection getConnection() throws DAOException {
				try {
					return newConnection();
				} catch (Exception e) {
					throw new DAOException( e );
				}
			}
		};
	}
	
	private static int executeAll( SQLScriptReader reader, Connection conn ) throws SQLException, IOException {
		int res = 0;
		try ( Statement stm = conn.createStatement() ) {
			while ( reader.hasNext() ) {
				String sql = reader.next();
				if ( sql.trim().length() > 0 ) {
					stm.execute( sql );
					res++;	
				}
			}	
		}
		return res;
	}
	
}
