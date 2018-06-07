package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorDB {
	
	private static Connection con = null;
	
	public ConnectorDB() {
	}
	
	public static Connection createConnection() throws SQLException {
		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			String ip = "127.0.0.1";
			String port = "3306";
			String db = "palestra";
	
			String url ="jdbc:mysql://"+ ip+":"+ port+"/"+db;
			con = DriverManager.getConnection(url, "root", "FEDElol96");
			con.setAutoCommit(false);
			
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
			System.out.println("DB driver not found!");
		}
		return con;	
	}
	
	public static void closeConnection() throws SQLException{
		if (con != null) {
			con.close();
		}
	}	
}
