package entities;

import java.io.Serializable;
import java.sql.Date;

public class Reservation implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idReservation;
	private Date dateDebut;
	private Date dateFin;
	private Double montant;
	private String statutReservation;
	private int idClient;
	private int idVoiture;
	
	public Reservation() {
		super();
	}

	public Reservation(Date dateDebut, Date dateFin, Double montant, String statutReservation, int idClient, int idVoiture) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.montant = montant;
		this.statutReservation = statutReservation;
		this.idClient = idClient;
		this.idVoiture = idVoiture;
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
	
	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public int getIdVoiture() {
		return idVoiture;
	}

	public void setIdVoiture(int idVoiture) {
		this.idVoiture = idVoiture;
	}

}
