package dao;

import java.sql.Date;
import java.util.List;

import metier.Reservation;

public interface IReservationDAO {
	
	public  Reservation ajouterReservation(Reservation r);
	
	public  Reservation modifierReservation(Reservation r);
	
	public void supprimerReservation(int id);
	
	public Reservation rechercherReservationParAutre(/* Depend on attributes*/);
	
	public Reservation rechercherReservationParId(int id);
	
	public List<Reservation> rechercherReservationParDateDebut(Date datedebut);
	
	public List<Reservation> rechercherReservationParDateFin(Date datefin);
	
	public List<Reservation> getAllReservations();

}
