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
		    	System.out.print(statmant.getString(1)+ " " + statmant.getString("cognome") + "\n");
		           		
		    }
		    
		 } 
		catch (SQLException e) {
			e.printStackTrace();
    }
		
		connector.closeConnection();
		
		

	}

}
