package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Vino;
import model.VinoManager;

@WebServlet("/VinoServlet")
public class VinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		VinoManager manager = new VinoManager();
		try {
			if (action.equals("findAll")) {
				List<Vino> lista = manager.findAll();
				req.setAttribute("listaVini", lista);
				
			} else if (action.equals("findById")) {
				String id = req.getParameter("id");
				Vino bean = manager.findById(id);
				req.setAttribute("vino", bean);
				
			} else if (action.equals("delete")) {
				String id = req.getParameter("id");
				manager.delete(id);
				req.setAttribute("canc", true);
				
			}
			
			req.setAttribute("errore", false);
		} catch (Exception e) {
			req.setAttribute("errore", true);
		}
		RequestDispatcher dispatcher =
				getServletContext().getRequestDispatcher("/page/index.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	

}
