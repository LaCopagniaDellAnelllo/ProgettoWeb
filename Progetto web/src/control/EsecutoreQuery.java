package control;

import java.sql.*;
import java.util.ArrayList;

public class EsecutoreQuery {

	private ConnectorDB condb;
	ArrayList<String[]> result = null;
	String[] tupla;
	
	public EsecutoreQuery() {
		condb = new ConnectorDB();
	}
	
	
	public ArrayList<String[]> exeQuery(String query) throws SQLException, InstantiationException, IllegalAccessException {
		try {
			ResultSet rs = null;
			Connection con = condb.createConnection();
			System.out.println(con);
			if (con!=null){
				Statement st = con.createStatement();

				if (query != null) {
					rs= st.executeQuery(query);
				}

				result = new ArrayList<String[]>();

				//copio ogni tupla di rs in un array di stringhe
				while(rs.next()){
					int i = 1;
					while(rs.getString(i) != null) {
						tupla[i] = rs.getString(i);
						i++;
					}
					// salvo l'array in un ArrayList
					result.add(tupla);
				}
			} else {System.out.println("Connessione assente con Database");}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void closeConnection() {
		try {
			condb.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
