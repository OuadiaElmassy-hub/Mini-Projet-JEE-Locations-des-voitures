package web;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClientDAO;
import dao.ReservationDAO;
import dao.VoitureDAO;
import metier.Reservation;
import metier.Voiture;

@WebServlet(name="MyControler", urlPatterns= {"/controler", "*.do"})
public class MyControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletPath();
		VoitureDAO voituredao = new VoitureDAO();
		
		if(path.equals("/consultationAdmin.do")) {
			
			/*HttpSession session = request.getSession(false);
			if(session == null || session.getAttribute("idClient") == null) { // seulement idClient = Admin
				response.sendRedirect("auth.jsp");
				return;
			}*/
			List<Voiture> voitures = voituredao.getAllVoitures();
			
			request.setAttribute("voitures", voitures);

			request.getRequestDispatcher("consultationDesVoituresAdmin.jsp").forward(request, response);
			
		}else if(path.equals("/formSupprimerVoiture.do")) {
			
			/*HttpSession session = request.getSession(false);
			if(session == null || session.getAttribute("idClient") == null) { // seulement idClient = Admin
				response.sendRedirect("auth.jsp");
				return;
			}*/
			int idVoiture = Integer.parseInt(request.getParameter("idVoiture"));
			Voiture v = voituredao.rechercherVoitureParId(idVoiture);
			request.setAttribute("voiture", v);
			
			request.getRequestDispatcher("supprimerVoiture.jsp").forward(request, response);
			
		}else if(path.equals("/formAjouterVoiture.do")) {
			/*HttpSession session = request.getSession(false);
			if(session == null || session.getAttribute("idClient") == null) { // seulement idClient = Admin
				response.sendRedirect("auth.jsp");
				return;
			}*/
			request.getRequestDispatcher("ajouterVoiture.jsp").forward(request, response);
			
		}else if(path.equals("/formModifierVoiture.do")) {
			/*HttpSession session = request.getSession(false);
			if(session == null || session.getAttribute("idClient") == null) { // seulement idClient = Admin
				response.sendRedirect("auth.jsp");
				return;
			}*/
			int idVoiture = Integer.parseInt(request.getParameter("idVoiture"));
			Voiture v = voituredao.rechercherVoitureParId(idVoiture);
			request.setAttribute("voiture", v);
			
			request.getRequestDispatcher("modifierVoiture.jsp").forward(request, response);
			
			//----------------------------------------------------------------------
			
		}else if(path.equals("/supprimerVoiture.do")) {
			
			/*HttpSession session = request.getSession(false);
			if(session == null || session.getAttribute("idClient") == null) { // seulement idClient = Admin
				response.sendRedirect("auth.jsp");
				return;
			}*/
			int idVoiture = Integer.parseInt(request.getParameter("idVoiture"));
			
			voituredao.supprimerVoiture(idVoiture);
			
			request.getRequestDispatcher("consultationAdmin.do").forward(request, response);
			
		}else if(path.equals("/ajouterVoiture.do")) {
			/*HttpSession session = request.getSession(false);
			if(session == null || session.getAttribute("idClient") == null) { // seulement idClient = Admin
				response.sendRedirect("auth.jsp");
				return;
			}*/
			Voiture v = new Voiture();
			
			v.setMatricule(request.getParameter("matricule"));
			v.setMarque(request.getParameter("marque"));
			v.setModele(request.getParameter("modele"));
			v.setCategorie(request.getParameter("categorie"));			
			v.setPrixJour(Integer.parseInt(request.getParameter("prixJour")));
			
			v.setImage(request.getParameter("image"));
			
			voituredao.ajouterVoiture(v);
			
			request.getRequestDispatcher("consultationAdmin.do").forward(request, response);
			
		}else if(path.equals("/modifierVoiture.do")) {
			/*HttpSession session = request.getSession(false);
			if(session == null || session.getAttribute("idClient") == null) { // seulement idClient = Admin
				response.sendRedirect("auth.jsp");
				return;
			}*/
			Voiture v = new Voiture();
			v.setIdVoiture(Integer.parseInt(request.getParameter("idVoiture")));
			v.setMatricule(request.getParameter("matricule"));
			v.setMarque(request.getParameter("marque"));
			v.setModele(request.getParameter("modele"));
			v.setCategorie(request.getParameter("categorie"));
			v.setPrixJour(Integer.parseInt(request.getParameter("prixJour")));
			v.setImage(request.getParameter("image"));
			voituredao.modifierVoiture(v);
			
			request.getRequestDispatcher("consultationAdmin.do").forward(request, response);
			
			//-----------------------------------------------------------------------
			
			
		}else if(path.equals("/login.do")) {
			
			HttpSession session = request.getSession();
			String login = request.getParameter("login");
			String password = request.getParameter("pwd");
			
			//stockage de login et password dans model
			
			ClientDAO clientlogin = new ClientDAO();
			int id = clientlogin.getIdClientForLogin(login, password);
			
			//stockage de id dans model puis dans if stockage de model dans session
			
			if(id != -1) {
				
				session.setAttribute("idClient", id);
				response.sendRedirect("espaceClient.jsp");
				
			}else response.sendRedirect("auth.jsp");	
	
		}else if(path.equals("/consultation.do")) {
			
			LocalDate today = LocalDate.now();
			String categorie = "tout";
			List<Voiture> voitures = voituredao.rechercherVoituresParCatDate(categorie, Date.valueOf(today));
			
			request.setAttribute("today", today.toString());
			request.setAttribute("voitures", voitures);
			request.setAttribute("categorie", "tout");
			request.getRequestDispatcher("consultationDesVoitures.jsp").forward(request, response);
			
		}else if(path.equals("/chercher.do")) {
			
			String dateString = request.getParameter("dateDebut");
			String categorie = request.getParameter("categorie");

			Date dateClient;
			if(dateString == null || dateString.isEmpty()){
			    dateClient = Date.valueOf(LocalDate.now());
			} else {
			    dateClient = Date.valueOf(dateString);
			}
			Date dateDisponibilite  = Date.valueOf(dateClient.toLocalDate().minusDays(1));
			
			List<Voiture> voitures = voituredao.rechercherVoituresParCatDate(categorie, dateDisponibilite);
			request.setAttribute("voitures", voitures);
			request.getRequestDispatcher("consultationDesVoitures.jsp").forward(request, response);
			
		}else if(path.equals("/voiture.do")) {	
			
			int idVoiture = Integer.parseInt(request.getParameter("idVoiture"));
			
			Voiture v = voituredao.rechercherVoitureParId(idVoiture);
			
			request.setAttribute("voiture", v);
			
			request.setAttribute("twodays", LocalDate.now().plusDays(2).toString());//reservation jour avant
			
			request.getRequestDispatcher("voitureAreserverDateFin.jsp").forward(request, response);
			
		}else if(path.equals("/paiement.do")) {
			
			HttpSession session = request.getSession(false);
			
			if(session == null || session.getAttribute("idClient") == null) {
				response.sendRedirect("auth.jsp");
				return;
			}
			
			String dateString = request.getParameter("dateRetour");
			
			Date dateFin  = Date.valueOf(dateString);
			Date dateDebut = Date.valueOf(LocalDate.now());// date d'aujourd'hui
			
			LocalDate debut = dateDebut.toLocalDate();
			LocalDate fin = dateFin.toLocalDate();
			
			int idVoiture = Integer.parseInt(request.getParameter("idVoiture"));
			Voiture v = voituredao.rechercherVoitureParId(idVoiture);
			
			Long duree = ChronoUnit.DAYS.between(debut, fin);
			int prixParJour = v.getPrixJour();
			
			int montant = (int) (prixParJour*duree);
			
			session.setAttribute("montant", montant);
			session.setAttribute("idVoiture", idVoiture);
			session.setAttribute("dateDebut", dateDebut);
			session.setAttribute("dateFin", dateFin);
			
			request.getRequestDispatcher("formulairePaiement.jsp").forward(request, response);		
			
		}else if(path.equals("/validerPaiement.do")) {
			
			HttpSession session = request.getSession(false);
			if(session == null || session.getAttribute("idClient") == null) {
				response.sendRedirect("auth.jsp");
				return;
			}
			
			//vérification de la validité des infos de paiement inseré
			
			int idVoiture = (int) session.getAttribute("idVoiture");
			int idClient = (int) session.getAttribute("idClient");
			Date dateDebut = (Date) session.getAttribute("dateDebut");
			Date dateFin  = (Date) session.getAttribute("dateFin");			
			int montant = (int)session.getAttribute("montant");
			
			ReservationDAO reservationdao = new ReservationDAO();
			
			Reservation r = new Reservation(dateDebut, dateFin, montant, idClient, idVoiture);
			
			reservationdao.ajouterReservation(r);
			response.sendRedirect("espaceClient.jsp");
			
		}else if(path.equals("/annulerPaiement.do")) {
			
			response.sendRedirect("consultation.do");
		
		}else response.sendRedirect("acceuil.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
