package control;

import java.sql.*;


public class ConnectorDB {
	
	private static Connection con = null;
	
	public ConnectorDB() {
	}
	
	public Connection createConnection() throws SQLException, InstantiationException, IllegalAccessException {
		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			String ip = "127.0.0.1";
			String port = "3306";
			String db = "cantina";
			String url ="jdbc:mysql://"+ ip+":"+ port+"/"+db;
			con = DriverManager.getConnection(url, "root", "alex");
			con.setAutoCommit(false);
			
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}

		return con;	
	}
	
	public void closeConnection() throws SQLException{
		if (con != null) {
			con.close();
		}
	}	
}
