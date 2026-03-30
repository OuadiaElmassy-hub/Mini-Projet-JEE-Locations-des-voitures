package metier;

import java.util.List;

import dao.VoitureDAO;
import entities.Voiture;

public class TestVoiture {

	public static void main(String[] args) {
		VoitureDAO testvoiture = new VoitureDAO();

		Voiture v1 = new Voiture("1234-a-23", "audi", "exempleModele", "sport", 200.0);
		testvoiture.ajouterVoiture(v1); // la methode retourne un element avec son id
		List<Voiture> voitures = testvoiture.getAllVoitures();

		System.out.println("===== Affichage de toutes les voitures : ==========");
		for (Voiture v : voitures) {
		    System.out.println("Numéro : " + v.getIdVoiture());
		    System.out.println("Matricule : " + v.getMatricule());
		    System.out.println("Marque : " + v.getMarque());
		    System.out.println("Modèle : " + v.getModele());
		    System.out.println("Prix par jour : " + v.getPrixJour());
		    System.out.println("Categorie : " + v.getCategorie());
		    System.out.println("----------------------------------------");
		    System.out.println("===================================");
		}

		Voiture voitureAmodifier = testvoiture.rechercherVoitureParId(4);
		Voiture modifications = new Voiture(/* nouveaux attributs */);

		System.out.println("====== Opération de modification : ==========");
		System.out.println("------ Voiture à modifier : -----------");
		System.out.println("Numéro : " + voitureAmodifier.getIdVoiture());
		System.out.println("Matricule : " + voitureAmodifier.getMatricule());
	    System.out.println("Marque : " + voitureAmodifier.getMarque());
	    System.out.println("Modèle : " + voitureAmodifier.getModele());
	    System.out.println("Prix par jour : " + voitureAmodifier.getPrixJour());
	    System.out.println("Categorie : " + voitureAmodifier.getCategorie());
		System.out.println("----------------------------------------");

		voitureAmodifier = testvoiture.modifierVoiture(modifications);

		System.out.println("------ Voiture après modification : -----------");
		System.out.println("Numéro : " + voitureAmodifier.getIdVoiture());
		System.out.println("Matricule : " + voitureAmodifier.getMatricule());
	    System.out.println("Marque : " + voitureAmodifier.getMarque());
	    System.out.println("Modèle : " + voitureAmodifier.getModele());
	    System.out.println("Prix par jour : " + voitureAmodifier.getPrixJour());
	    System.out.println("Categorie : " + voitureAmodifier.getCategorie());
		System.out.println("----------------------------------------");
		System.out.println("===================================");

		testvoiture.supprimerVoiture(voitureAmodifier.getIdVoiture());

		Voiture voitureApresSuppression = testvoiture.rechercherVoitureParId(voitureAmodifier.getIdVoiture());

		System.out.println("===== Opération de suppression : ==========");
		if (voitureApresSuppression == null)
		    System.out.println("La voiture numéro :" + voitureAmodifier.getIdVoiture() + " a été supprimée");
		else
		    System.out.println("La voiture numéro :" + voitureAmodifier.getIdVoiture() + " n'a pas été supprimée");
		System.out.println("========================================");
		
		
	}
}
