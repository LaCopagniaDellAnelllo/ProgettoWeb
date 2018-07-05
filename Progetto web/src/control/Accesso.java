package control;


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
	
	@Override
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
	
	
	@Override
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		
		String user = (String) request.getAttribute("Username");
		String pass = (String) request.getAttribute("Password");
		String[] utente = checkAccesso(user, pass);
		
		if (utente[0] != null) {
			
			//controlla se � un dipendente (o cliente)
			if (utente[3] != null) {
				session.setAttribute("nome", utente[3]);
			} else {
				session.setAttribute("nome", utente[2]);
			}
			
			
			//controlla se � admin
			if (Boolean.parseBoolean(utente[1]) == true) {
				session.setAttribute("isAdmin", Boolean.parseBoolean(utente[1]));
			}
			
		} else {
			session.setAttribute("Errore", "e-mail o password errata");
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}

	
	@SuppressWarnings("finally")
	private String[] checkAccesso(String user, String pass) {
		ConnectorDB condb = new ConnectorDB();
		
		try {
			Connection con = condb.createConnection();
			String query = "SELECT Account.idAccount, Account.admin, Cliente.nome, Dipendenti.nome " +
							"FROM Account, Cliente, Dipendenti" +
							"WHERE email = " + user + " and password = " + pass +
							"and Account.cf_dipendenti = Dipendenti.CodiceFiscale and Account.id_cliente = Cliente.CodiceCliente";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			String[] result = new String[4];
			if (rs.next()) {
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
