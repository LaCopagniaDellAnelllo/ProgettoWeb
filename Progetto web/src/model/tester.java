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
		
			String query = 	"select distinct account.idAccount, account.admin, account.username" +
							"from account, cliente, dipendenti" +
							"where username = "+ user +"  or email =" + user + " and password = " + pass +
							"and account.cf_dipendente = dipendenti.CodiceFiscale and account.id_cliente= cliente.CodiceFiscale";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				String[] result = new String[4];
				System.out.println("id account="+ rs.getString("account.username"));
				result[0] = rs.getString(1);
				result[1] = rs.getString(2);
				result[2] = rs.getString(3);
				result[3] = rs.getString(4);
			}
			
			con.close();
			
		} catch ( SQLException e) {
			e.printStackTrace();
		}
		
	}
}
