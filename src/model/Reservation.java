package model;

import java.util.Date;

public class Reservation {

	private int idReservation;
	private Date dateDebut;
	private Date dateFin;
	private float montant;
	private String statutReservation;
	private String statutPaiement;
	
	public Reservation() {
		
	}
	
	public Reservation(int idReservation, Date dateDebut, Date dateFin, float montant, String statutReservation,
			String statutPaiement) {
		super();
		this.idReservation = idReservation;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.montant = montant;
		this.statutReservation = statutReservation;
		this.statutPaiement = statutPaiement;
	}

	public Reservation(Date dateDebut, Date dateFin, float montant, String statutReservation, String statutPaiement) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.montant = montant;
		this.statutReservation = statutReservation;
		this.statutPaiement = statutPaiement;
	}

	public int getIdReservation() {
		return idReservation;
	}
	
	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}
	
	public Date getDateDebut() {
		return dateDebut;
	}
	
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	
	public Date getDateFin() {
		return dateFin;
	}
	
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	public float getMontant() {
		return montant;
	}
	
	public void setMontant(float montant) {
		this.montant = montant;
	}
	
	public String getStatutReservation() {
		return statutReservation;
	}
	
	public void setStatutReservation(String statutReservation) {
		this.statutReservation = statutReservation;
	}
	
	public String getStatutPaiement() {
		return statutPaiement;
	}
	
	public void setStatutPaiement(String statutPaiement) {
		this.statutPaiement = statutPaiement;
	}
}
