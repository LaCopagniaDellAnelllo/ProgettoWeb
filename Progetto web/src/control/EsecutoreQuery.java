package control;

import java.sql.*;

public class EsecutoreQuery {

	private ConnectorDB condb;
	
	
	
	public EsecutoreQuery() {
		condb = new ConnectorDB();
	}
	

	
	public ResultSet exeQuery(String query) throws SQLException, InstantiationException, IllegalAccessException {
		ResultSet rs = null;
		Connection con = condb.createConnection();
		Statement st = con.createStatement();
		if (query != null) {
			rs= st.executeQuery(query);
		}
		
		return rs;
	}
	
	public void closeConnection() {
		try {
			condb.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
