package servlet;


import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.ConnectorDB;

@WebServlet("/Accesso")
public class Accesso extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public Accesso() {
		super();
	}
	
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
	
	/*se non viene effettuato il login crea pagina bianca*/
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		
		String user = (String) request.getParameter("Username");
		String pass = (String) request.getParameter("Password");
		String[] utente = checkAccesso(user, pass);
		
		if (utente != null) {
			
			//controlla se � un dipendente[3] (o cliente[2])
			if (utente[3] != null) {
				session.setAttribute("nome", utente[3]);
			} else {
				session.setAttribute("nome", utente[2]);
			}
			
			
			//controlla se � admin
			if (Boolean.parseBoolean(utente[1]) == true) {
				session.setAttribute("isAdmin", true);
			} else {
				session.setAttribute("isAdmin", false);
			}
			
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
	private String[] checkAccesso(String user, String pass) {
		ConnectorDB condb = new ConnectorDB();
		
		try {
			Connection con = condb.createConnection();
			String[] result = new String[4];
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
				result[3] = rs.getString(4);
			}
			
			con.close();
			return result;
			
		} catch (InstantiationException | IllegalAccessException | SQLException e) {
			e.printStackTrace();
		} finally {
			return null;
		}
	}

}
