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


@WebServlet("/addToKart")
public class AddToKart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public AddToKart() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String id = req.getParameter("id"); 
		int amount = Integer.parseInt(req.getParameter("amount"));
		
		Carrello kart = (Carrello) session.getAttribute("kart");
		
		VinoManager manager = new VinoManager();
		VinoInKart bean = new VinoInKart();
		
		try {
			bean.setVino(manager.findById(id));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		if (bean.getVino() != null) {
			bean.setAmount(amount);
			kart.addToKart(bean);
		} else {
			req.setAttribute("kartErrore", "Errore nel caricamento del prodotto");
		}
		
		RequestDispatcher dispositivo =
		          getServletContext().getRequestDispatcher("/page/index.jsp");
		dispositivo.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}
	

}
