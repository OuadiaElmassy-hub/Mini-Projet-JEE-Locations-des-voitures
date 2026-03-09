package metier;

import java.io.Serializable;

public class Voiture implements Serializable  { // dans tous les classes entities il est optionnel d'implementer l'interface Serialisable
	
	private static final long serialVersionUID = 1L;
	private int idVoiture;
	private String matricule;
	private String marque;
	private String modele;
	private String categorie;
	private Double prixJour;
	//private boolean disponible;
	
	public Voiture(){
		super();
	}
	
	public Voiture(String matricule, String marque, String modele, String categorie, Double prixJour) {
		super();
		this.matricule = matricule;
		this.marque = marque;
		this.modele = modele;
		this.categorie = categorie;
		this.prixJour = prixJour;
	}
	
	public void setIdVoiture(int idVoiture) {
		this.idVoiture = idVoiture;
	}
	
	public int getIdVoiture() {
		return idVoiture;
	}
	
	
	
	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
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
	
	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public void setPrixJour(Double prixJour) {
		this.prixJour = prixJour;
	}
	
	public Double getPrixJour() {
		return prixJour;
	}
}
