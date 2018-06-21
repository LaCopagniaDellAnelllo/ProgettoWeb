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
<<<<<<< HEAD
		
=======
>>>>>>> d38f9e975607243439ad14a4ab692312d6448e33
		return rs;
	}
	
	public void closeConnection() {
		try {
			condb.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
<<<<<<< HEAD
	
=======
>>>>>>> d38f9e975607243439ad14a4ab692312d6448e33
}
