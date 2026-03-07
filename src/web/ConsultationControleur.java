package web;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/consultation")
public class ConsultationControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		String dateString1 = request.getParameter("dateDebut"); 
		Date dateDebut  = Date.valueOf(dateString1);
		
		String dateString2 = request.getParameter("dateDebut"); 
		Date dateFin  = Date.valueOf(dateString2);

		String categorie = request.getParameter("categorie");
		
		// appel de la couche DAO une selection
		// envoyer le resultat vers la page consultation jsp
	}
}
