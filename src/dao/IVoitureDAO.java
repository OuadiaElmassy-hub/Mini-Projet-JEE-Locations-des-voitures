package dao;

import java.sql.Date;
import java.util.List;

import metier.Voiture;

public interface IVoitureDAO {
	
	public Voiture ajouterVoiture(Voiture v);
	
	public Voiture modifierVoiture(Voiture v);
	
	public void supprimerVoiture(int id);
	
	public Voiture rechercherVoitureParId(int id);
	
	public List<Voiture> rechercherVoituresParMarque(String marque);
	
	public List<Voiture> rechercherVoituresParCatDate(String categorie, Date dateDebut);
	
	public Voiture rechercherVoitureParMatricule(String matricule);
	
	public List<Voiture> getAllVoitures();
	
	public Voiture rechercherVoituresParAutre(/* Depend on attributes*/);

}
