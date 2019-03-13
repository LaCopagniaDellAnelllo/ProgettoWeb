package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Utente;
import model.UtenteManager;

@WebServlet("/Signin")
public class Signin extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public Signin() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Utilizzare metodo doPost()");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String nome = req.getParameter("nome");
		String cognome = req.getParameter("cognome");
		String mail = req.getParameter("mail");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		Utente bean = new Utente("", nome, cognome, mail, password, username, false);
		UtenteManager manager = new UtenteManager();
		try {
			manager.insert(bean);
			Utente utente = manager.login(bean.getUsername(), bean.getPassword());
			session.setAttribute("utente", utente);
			
			req.setAttribute("erroreSign", false);
		} catch (SQLException e) {
			req.setAttribute("erroreSign", true);
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher =
				getServletContext().getRequestDispatcher("/page/index.jsp");
		dispatcher.forward(req, resp);
	}

}
