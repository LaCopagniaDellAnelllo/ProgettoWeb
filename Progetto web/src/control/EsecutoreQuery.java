package control;

import java.sql.*;

public class EsecutoreQuery {

	private String query;
	private ConnectorDB con;
	
	public EsecutoreQuery() {
		con = new ConnectorDB();
	}
	
	public void setQuery(String query1) {
		query = query1;
	}
	
	public ResultSet exeQuery() {
		ResultSet rs = null;
		try {
			Statement st = con.createConnection().createStatement();
			if (query != null) {
				rs= st.executeQuery(query);
			} else {
				return rs;
			}
		} catch (SQLException e) {
		}
		
		return rs;
	}
	
}
