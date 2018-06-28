package control;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class Accesso extends HttpServlet{
	private static final long serialVersionUID = 1L;

	
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}


}
