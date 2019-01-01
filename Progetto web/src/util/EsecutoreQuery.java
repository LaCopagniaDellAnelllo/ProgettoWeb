package util;

import java.sql.*;
import java.util.ArrayList;


public class EsecutoreQuery {

	
	ArrayList<String[]> result = null;
	String[] tupla;
	Connection con = null;
	
	public EsecutoreQuery() throws InstantiationException, IllegalAccessException, SQLException {
		
	}
	
	
	public ArrayList<String[]> exeQuery(String query, int numColonne) throws SQLException, InstantiationException, IllegalAccessException {
		try {
			ResultSet rs = null;
			con = DriverManagerConnectionPool.getConnection("", "", "");
			if (con!=null){
				Statement st = con.createStatement();

				if (query != null) {
					rs= st.executeQuery(query);
				}

				result = new ArrayList<String[]>();
				//copio ogni tupla di rs in un array di stringhe
				while(rs.next()){
					tupla = new String[10];
					int i = 0;
					while(i < numColonne ) {
						tupla[i] = rs.getString(i+1);
						i++;
					}
					// salvo l'array in un ArrayList
					result.add(tupla);
				}
			} else {System.out.println("Connessione assente con Database");}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void closeConnection() {
		try {
			DriverManagerConnectionPool.releaseConnection(con);;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
