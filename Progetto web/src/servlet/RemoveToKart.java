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

import bean.Carrello;
import bean.VinoInKart;
import model.VinoManager;

@WebServlet("/removeToKart")
public class RemoveToKart extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String id = req.getParameter("id"); 
		
		Carrello kart = (Carrello) session.getAttribute("kart");
		
		VinoManager manager = new VinoManager();
		VinoInKart bean = new VinoInKart();
		
		try {
			bean.setVino(manager.findById(id));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		kart.removeToKart(bean);
		
		RequestDispatcher dispositivo =
		          getServletContext().getRequestDispatcher("/page/index.jsp");
		dispositivo.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	
}
