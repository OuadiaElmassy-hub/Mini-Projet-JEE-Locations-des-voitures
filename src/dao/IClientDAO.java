package dao;

import java.util.List;

import metier.Client;

public interface IClientDAO {
	
	public  Client ajouterClient(Client c);
	
	public  Client modifierClient(Client c);
	
	public void supprimerClient(int id);
	
	public Client rechercherClientParId(int id);
	
	public List<Client> rechercherClientsParPrenom(String prenom);
	
	public List<Client> rechercherClientParAutre(/* Depend on attributes*/);
	
	public int getIdClientForLogin(String username, String password);
	
	public List<Client> getAllClients();

}
