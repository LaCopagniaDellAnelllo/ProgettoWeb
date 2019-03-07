package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Vino;
import model.VinoManager;

@WebServlet("/AddVino")
public class AddVino extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String descrizione = req.getParameter("descrizione");
		double centilitri = Double.parseDouble(req.getParameter("centilitri"));
		double prezzo = Double.parseDouble(req.getParameter("prezzo"));
		String vinoSfusoNome = req.getParameter("vinoSfusoNome");
		String vinoSfusoAnno = req.getParameter("vinoSfusoAnno");
		Vino bean = new Vino(descrizione, centilitri, prezzo, vinoSfusoNome, vinoSfusoAnno);
		
		VinoManager manager = new VinoManager();
		try {
			manager.insert(bean);
		} catch (SQLException e) {
			e.printStackTrace();
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
