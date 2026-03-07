package model;

public class Voiture {
	private int idVoiture;
	private String marque;
	private String modele;
	private float prixJour;
	//private boolean disponible;
	
	public Voiture(){
		
	}
	
	public Voiture(int idVoiture, String marque, String modele, float prixJour) {
		super();
		this.idVoiture = idVoiture;
		this.marque = marque;
		this.modele = modele;
		this.prixJour = prixJour;
	}
	
	public void setIdVoiture(int idVoiture) {
		this.idVoiture = idVoiture;
	}
	
	public int getIdVoiture() {
		return idVoiture;
	}
	
	public void setMarque(String marque) {
		this.marque = marque;
	}
	
	public String getMarque() {
		return marque;
	}
	
	public void setModele(String modele) {
		this.modele = modele;
	}
	
	public String getModele() {
		return modele;
	}
	
	public void setPrixJour(float prixJour) {
		this.prixJour = prixJour;
	}
	
	public float getPrixJour() {
		return prixJour;
	}
}
