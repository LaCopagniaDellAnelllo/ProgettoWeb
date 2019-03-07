package servlet;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import util.DriverManagerConnectionPool;


@WebServlet("/Accesso")
public class Accesso extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final String DB = "cantina";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	public Accesso() {
		super();
	}
	
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("Metodo non consentito, usare il metodo doPost");
	}
	
	/*se non viene effettuato il login crea pagina bianca*/
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		
		String user = (String) request.getParameter("Username");
		String pass = (String) request.getParameter("Password");
		String[] utente;
		try {
			utente = checkAccesso(user, pass);
		} catch (SQLException e) {
			utente = null;
		}
		
		if (utente != null) {
						
			//controlla se è admin
			if (Boolean.parseBoolean(utente[1]) == true) {
				session.setAttribute("isAdmin", true);
			} else {
				session.setAttribute("isAdmin", false);
			}
			session.setAttribute("nome", utente[2]);
			session.setAttribute("logged", true);
			session.setAttribute("errore", null);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/page/login.jsp");
			dispatcher.forward(request, response);
			
		} else {
			session.setAttribute("errore", "e-mail o password errata");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/page/index.jsp");
			dispatcher.forward(request, response);
		}

	}

	
	@SuppressWarnings("finally")
	private String[] checkAccesso(String user, String pass)  throws SQLException{
		
		
		try {
			Connection con = DriverManagerConnectionPool.getConnection(DB, USERNAME, PASSWORD);
			String[] result = new String[3];
			String query = 	"SELECT distinct account.idAccount, account.admin, account.username" +
							"FROM account, cliente, dipendenti" +
							"WHERE username =" + user +"  or email ="+ user +" and password = "+ pass+
							"and account.cf_dipendente = dipendenti.CodiceFiscale and account.id_cliente= cliente.CodiceFiscale";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				System.out.println("id account="+ rs.getString("account.username"));
				result[0] = rs.getString(1);
				result[1] = rs.getString(2);
				result[2] = rs.getString(3);
			}
			
			con.close();
			return result;
			
		} 
		finally {
			return null;
		}
	}

}
