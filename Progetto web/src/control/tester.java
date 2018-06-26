package control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class tester {
	public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException {
		ConnectorDB connector = new ConnectorDB();
		
		Connection con = connector.createConnection();
		
		try {
			String query2="select nome, cognome from dipendenti ";
			Statement st = con.createStatement();
			ResultSet statmant = st.executeQuery(query2);
			
		    while (statmant.next()){
		    	String nome = statmant.getString(1);
		    	String cognome = statmant.getString("cognome");
		    	System.out.print(nome + " " + cognome + "\n");
		           		
		    }
		    connector.closeConnection();
		 } 
		catch (SQLException e) {
			e.printStackTrace();
    }
		

		
		

	}

}
