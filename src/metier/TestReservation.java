package metier;

import java.sql.Date;
import java.util.List;

import dao.ReservationDAO;

public class TestReservation {

	public static void main(String[] args) {
		ReservationDAO testreservation = new ReservationDAO();
		
		Reservation r1 = new Reservation(Date.valueOf("2026-03-01"), Date.valueOf("2026-03-03"), "CONFIRMEE", 2000, 1, 3);
		testreservation.ajouterReservation(r1);// la methode retourne un element avec son id
		
	    List<Reservation> reservations = testreservation.getAllReservations();
	    
	    System.out.println("===== Affichage de tout les réservations éffectuées : ==========");
		for (Reservation r : reservations) {
			System.out.println("Numéro : " + r.getIdReservation());
		    System.out.println("Date Début : " + r.getDateDebut());
		    System.out.println("Date Fin : " + r.getDateFin());
		    System.out.println("État de Réservation : " + r.getStatutReservation());
		    System.out.println("Client : " + r.getIdClient());
		    System.out.println("Voiture : " + r.getIdVoiture());
		    System.out.println("----------------------------------------");
		    System.out.println("===================================");
	    }
		
		Reservation reservationAmodifier = testreservation.rechercherReservationParId(4);
		Reservation modifications = new Reservation(/*reservationAmodifier.getDateDebut(), reservationAmodifier.getDateFin(), montant, statutReservation, statutPaiement*/);
		
		System.out.println("====== Opération de modification : ==========");
		System.out.println("------ Reservation à modifier : -----------");
		System.out.println("Numéro : " + reservationAmodifier.getIdReservation());
	    System.out.println("Date Début : " + reservationAmodifier.getDateDebut());
	    System.out.println("Date Fin : " + reservationAmodifier.getDateFin());
	    System.out.println("État de Réservation : " + reservationAmodifier.getStatutReservation());
	    System.out.println("Client : " + reservationAmodifier.getIdClient());
	    System.out.println("Voiture : " + reservationAmodifier.getIdVoiture());
		System.out.println("----------------------------------------");
		
		reservationAmodifier = testreservation.modifierReservation(modifications);
		
		System.out.println("------ Reservation après modifier : -----------");
		System.out.println("Numéro : " + reservationAmodifier.getIdReservation());
	    System.out.println("Date Début : " + reservationAmodifier.getDateDebut());
	    System.out.println("Date Fin : " + reservationAmodifier.getDateFin());
	    System.out.println("État de Réservation : " + reservationAmodifier.getStatutReservation());
	    System.out.println("Client : " + reservationAmodifier.getIdClient());
	    System.out.println("Voiture : " + reservationAmodifier.getIdVoiture());
		System.out.println("----------------------------------------");
		System.out.println("===================================");
		
		testreservation.supprimerReservation(reservationAmodifier.getIdReservation());
		
		Reservation reservationApressuppression = testreservation.rechercherReservationParId(reservationAmodifier.getIdReservation());
		
	    System.out.println("===== Opération de supprission : ==========");
		if (reservationApressuppression == null) 
			System.out.println("La réservation numéro :" + reservationAmodifier.getIdReservation() + " n'à pas été supprimé");
		else
			System.out.println("La réservation numéro :" + reservationAmodifier.getIdReservation() + " n'à pas été supprimé");
	    System.out.println("========================================");
	}
}
