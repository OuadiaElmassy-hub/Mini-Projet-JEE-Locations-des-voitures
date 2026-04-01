package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClientDAO;


@WebServlet("/Login")
public class LoginControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String login = request.getParameter("login");
		String password = request.getParameter("pwd");
		
		//stockage de login et password dans model
		
		ClientDAO clientlogin = new ClientDAO();
		int id = clientlogin.getIdClientLogin(login, password);
		
		//stockage de id dans model puis dans if stockage de model dans session
		
		if(id != -1) {
			
			session.setAttribute("IdClient", id);
			response.sendRedirect("espaceClient.jsp");
			
		}else response.sendRedirect("auth.jsp");//Web-Content	
	}
}
