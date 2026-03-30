package metier;

import java.util.List;

import dao.ClientDAO;
import entities.Client;

public class TestClient {

	public static void main(String[] args) {
		ClientDAO testclient = new ClientDAO();

		Client c1 = new Client("A12345", "Ouadia", "EL MASSY", "0650915482", "Beni Mellal", "ouadi3@gmail.com", "Ouadia1234");
		testclient.ajouterClient(c1);// la methode retourne un element avec son id
		List<Client> clients = testclient.getAllClients();

		System.out.println("===== Affichage de tout les clients : ==========");
		for (Client c : clients) {
		    System.out.println("Numéro : " + c.getIdClient());
		    System.out.println("Nom : " + c.getNom());
		    System.out.println("Prénom : " + c.getPrenom());
		    System.out.println("Téléphone : " + c.getTelephone());
		    System.out.println("Adresse : " + c.getAdresse());
			System.out.println("Email : " + c.getEmail());
			System.out.println("Mot de passe : " + c.getMotDePasse());
		    System.out.println("----------------------------------------");
		    System.out.println("===================================");
		}

		Client clientAmodifier = testclient.rechercherClientParId(4);
		Client modifications = new Client(/* nouveaux attributs */);

		System.out.println("====== Opération de modification : ==========");
		System.out.println("------ Client à modifier : -----------");
		System.out.println("Numéro : " + clientAmodifier.getIdClient());
		System.out.println("Nom : " + clientAmodifier.getNom());
		System.out.println("Prénom : " + clientAmodifier.getPrenom());
		System.out.println("Téléphone : " + clientAmodifier.getTelephone());
	    System.out.println("Adresse : " + clientAmodifier.getAdresse());
		System.out.println("Email : " + clientAmodifier.getEmail());
		System.out.println("Mot de passe : " + clientAmodifier.getMotDePasse());
		System.out.println("----------------------------------------");

		clientAmodifier = testclient.modifierClient(modifications);

		System.out.println("------ Client après modification : -----------");
		System.out.println("Numéro : " + clientAmodifier.getIdClient());
		System.out.println("Nom : " + clientAmodifier.getNom());
		System.out.println("Prénom : " + clientAmodifier.getPrenom());
		System.out.println("Téléphone : " + clientAmodifier.getTelephone());
		System.out.println("Adresse : " + clientAmodifier.getAdresse());
		System.out.println("Email : " + clientAmodifier.getEmail());
		System.out.println("Mot de passe : " + clientAmodifier.getMotDePasse());
		System.out.println("----------------------------------------");
		System.out.println("===================================");

		testclient.supprimerClient(clientAmodifier.getIdClient());

		Client clientApresSuppression = testclient.rechercherClientParId(clientAmodifier.getIdClient());

		System.out.println("===== Opération de suppression : ==========");
		if (clientApresSuppression == null)
		    System.out.println("Le client numéro :" + clientAmodifier.getIdClient() + " a été supprimé");
		else
		    System.out.println("Le client numéro :" + clientAmodifier.getIdClient() + " n'a pas été supprimé");
		System.out.println("========================================");
			
	}
}
