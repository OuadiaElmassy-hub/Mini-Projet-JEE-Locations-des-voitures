package metier;

import java.io.Serializable;

public class Client implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int idClient;
	private String numPermis;
	private String nom;
	private String prenom;
	private String email;
	private String motdepasse;
	
	public Client() {
		super();
	}
	
	public Client(String numPermis, String nom, String prenom, String email, String motdepasse) {
		super();
		this.numPermis = numPermis;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motdepasse = motdepasse;
	}
	
	public int getIdClient() {
		return idClient;
	}
	
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	
	public String getNumPermis() {
		return numPermis;
	}

	public void setNumPermis(String numPermis) {
		this.numPermis = numPermis;
	}

	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMotDePasse() {
		return motdepasse;
	}
	
	public void setMotDePasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}
}
