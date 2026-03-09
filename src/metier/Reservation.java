package metier;

import java.io.Serializable;
import java.sql.Date;

public class Reservation implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idReservation;
	private Date dateDebut;
	private Date dateFin;
	private Double montant;
	private String statutReservation;
	private String statutPaiement;
	
	public Reservation() {
		super();
	}

	public Reservation(Date dateDebut, Date dateFin, Double montant, String statutReservation, String statutPaiement) {
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
	
	public Double getMontant() {
		return montant;
	}
	
	public void setMontant(Double montant) {
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
