package metier;

import java.sql.Date;
import java.util.List;

import dao.VoitureDAO;

public class TestVoiture {

	public static void main(String[] args) {
		VoitureDAO testvoiture = new VoitureDAO();

		Voiture v1 = new Voiture("1234-a-24", "audi", "exempleModele", "sport", 200, "chemin");
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
		    System.out.println("Image : " + v.getImage());
		    System.out.println("----------------------------------------");
		    System.out.println("===================================");
		}

		Voiture voitureAmodifier = testvoiture.rechercherVoitureParId(26);

		System.out.println("====== Opération de modification : ==========");
		System.out.println("------ Voiture à modifier : -----------");
		System.out.println("Numéro : " + voitureAmodifier.getIdVoiture());
		System.out.println("Matricule : " + voitureAmodifier.getMatricule());
	    System.out.println("Marque : " + voitureAmodifier.getMarque());
	    System.out.println("Modèle : " + voitureAmodifier.getModele());
	    System.out.println("Prix par jour : " + voitureAmodifier.getPrixJour());
	    System.out.println("Categorie : " + voitureAmodifier.getCategorie());
	    System.out.println("Image : " + voitureAmodifier.getImage());
		System.out.println("----------------------------------------");
		
		voitureAmodifier.setCategorie("4x4");
		voitureAmodifier.setPrixJour(450);
		voitureAmodifier.setImage("nouveu chemin dimage");
		
		voitureAmodifier = testvoiture.modifierVoiture(voitureAmodifier);

		System.out.println("------ Voiture après modification : -----------");
		System.out.println("Numéro : " + voitureAmodifier.getIdVoiture());
		System.out.println("Matricule : " + voitureAmodifier.getMatricule());
	    System.out.println("Marque : " + voitureAmodifier.getMarque());
	    System.out.println("Modèle : " + voitureAmodifier.getModele());
	    System.out.println("Prix par jour : " + voitureAmodifier.getPrixJour());
	    System.out.println("Categorie : " + voitureAmodifier.getCategorie());
	    System.out.println("Image : " + voitureAmodifier.getImage());
		System.out.println("----------------------------------------");
		System.out.println("===================================");

		testvoiture.supprimerVoiture(voitureAmodifier.getIdVoiture());

		Voiture voitureSuppreme = testvoiture.rechercherVoitureParId(voitureAmodifier.getIdVoiture());

		System.out.println("===== Opération de suppression : ==========");
		if (voitureSuppreme == null)
		    System.out.println("La voiture numéro :" + voitureAmodifier.getIdVoiture() + " a été supprimée");
		else
		    System.out.println("La voiture numéro :" + voitureAmodifier.getIdVoiture() + " n'a pas été supprimée");
		System.out.println("========================================");
		
		System.out.println("===== Opérations de recherche : ==========");
		System.out.println("---- Recherche par categorie et Date fin pour la consultation");
		
		List<Voiture> voitures1 = testvoiture.rechercherVoituresParCatDate("ludospace", Date.valueOf("2026-03-31"));
		System.out.println("===== Affichage des voitures resultats : ==========");
		for (Voiture v : voitures1) {
		    System.out.println("Numéro : " + v.getIdVoiture());
		    System.out.println("Matricule : " + v.getMatricule());
		    System.out.println("Marque : " + v.getMarque());
		    System.out.println("Modèle : " + v.getModele());
		    System.out.println("Prix par jour : " + v.getPrixJour());
		    System.out.println("Categorie : " + v.getCategorie());
		    System.out.println("Image : " + v.getImage());
		    System.out.println("----------------------------------------");
		}
		
		System.out.println("---- Recherche par Marque");
		List<Voiture> voitures2 = testvoiture.rechercherVoituresParMarque("dacia");
		
		System.out.println("===== Affichage des voitures resultats : ==========");
		for (Voiture v : voitures2) {
		    System.out.println("Numéro : " + v.getIdVoiture());
		    System.out.println("Matricule : " + v.getMatricule());
		    System.out.println("Marque : " + v.getMarque());
		    System.out.println("Modèle : " + v.getModele());
		    System.out.println("Prix par jour : " + v.getPrixJour());
		    System.out.println("Categorie : " + v.getCategorie());
		    System.out.println("Image : " + v.getImage());
		    System.out.println("----------------------------------------");
		}
		
		System.out.println("---- Recherche par Matricule");
		
		Voiture vmatricule = testvoiture.rechercherVoitureParMatricule("22334-أ-1");
		System.out.println("Numéro : " + vmatricule.getIdVoiture());
		System.out.println("Matricule : " + vmatricule.getMatricule());
	    System.out.println("Marque : " + vmatricule.getMarque());
	    System.out.println("Modèle : " + vmatricule.getModele());
	    System.out.println("Prix par jour : " + vmatricule.getPrixJour());
	    System.out.println("Categorie : " + vmatricule.getCategorie());
	    System.out.println("Image : " + vmatricule.getImage());
		System.out.println("===================================");
	}
}
