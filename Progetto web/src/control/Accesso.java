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
	
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		
		String user = (String) request.getAttribute("Username");
		String pass = (String) request.getAttribute("Password");
		String utente = checkAccesso(user, pass);
		
		if (utente != null) {
			
		}
	}

	
	private String checkAccesso(String user, String pass) {
		ConnectorDB condb = new ConnectorDB();
		
		try {
			Connection con = condb.createConnection();
			String query = "SELECT Nome FROM cliente" +
							"WHERE email = " + user + " and password = " + pass;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			String nome = null;
			if (rs != null) nome = rs.getString("Nome");
			con.close();
			return nome;
			
		} catch (InstantiationException | IllegalAccessException | SQLException e) {
			e.printStackTrace();
		} finally {
			return null;
		}
	}

}
