package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ConsultationControleur", urlPatterns = {"/consultation.php"})
public class ConsultationControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("today", java.time.LocalDate.now().toString());
		request.getRequestDispatcher("consultationDesVoitures.jsp").forward(request, response);

		/*String dateString = request.getParameter("dateDebut"); 
		Date dateDebut  = Date.valueOf(dateString);

		String categorie = request.getParameter("categorie");*/
		
		// appel de la couche DAO une selection
		// envoyer le resultat vers la page consultation jsp
	}
}
