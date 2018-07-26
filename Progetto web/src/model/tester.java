package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class tester {
	public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException {
		ConnectorDB connector = new ConnectorDB();
		String user = "alexert";
		String pass = "alexert97";
		Connection con = connector.createConnection();
		
		try {
			String query2="select distinct account.idAccount, account.admin, account.username from account, cliente, dipendenti username = ?  or email =? and password = ? and account.cf_dipendente = dipendenti.CodiceFiscale and account.id_cliente= cliente.CodiceFiscale";
			PreparedStatement ps = con.prepareStatement(query2);
			ps.setString(1,user);
			ps.setString(2,user);
			ps.setString(3,pass);
			//ResultSet rs = ps.executeQuery();
			//Statement st = con.createStatement();
			ResultSet statmant = ps.executeQuery();
			
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
