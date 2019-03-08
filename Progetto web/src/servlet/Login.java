package servlet;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import bean.Utente;
import model.UtenteManager;
import util.DriverManagerConnectionPool;


@WebServlet("/Login")
public class Login extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	Login() {
		super();
	}
	
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("Metodo non consentito, usare il metodo doPost");
	}
	
	
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		
		String user = (String) request.getParameter("Username");
		String pass = (String) request.getParameter("Password");
		
		UtenteManager manager = new UtenteManager();
		
		try {
			Utente bean = manager.login(user, pass);
			if (bean != null) {
				session.setAttribute("utente", bean);
			}
			request.setAttribute("erroreLog", false);

		} catch (SQLException e) {
			request.setAttribute("erroreLog", true);
			e.printStackTrace();
		}

		RequestDispatcher dispatcher =
				getServletContext().getRequestDispatcher("/page/index.jsp");
		dispatcher.forward(request, response);
	}

}
