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
		
		if(path.equals("/login.do")) {
			
			HttpSession session = request.getSession();
			String login = request.getParameter("login");
			String password = request.getParameter("pwd");
			
			//stockage de login et password dans model
			
			ClientDAO clientlogin = new ClientDAO();
			int id = clientlogin.getIdClientLogin(login, password);
			
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
			
			if(session == null) {
				response.sendRedirect("auth.jsp");
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
			if(session == null) {
				response.sendRedirect("auth.jsp");
			}
			
			int idVoiture = (int) session.getAttribute("idVoiture");
			int idClient = (int) session.getAttribute("idClient");
			Date dateDebut = (Date) session.getAttribute("dateDebut");
			Date dateFin  = (Date) session.getAttribute("dateFin");			
			int montant = (int)session.getAttribute("montant");
			
			ReservationDAO reservationdao = new ReservationDAO();
			
			Reservation r = new Reservation(dateDebut, dateFin, montant, idClient, idVoiture);
			
			reservationdao.ajouterReservation(r);
			
		}else if(path.equals("/annulerPaiement.do")) {
			response.sendRedirect("consultation.do");
		
		}else response.sendRedirect("acceuil.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
