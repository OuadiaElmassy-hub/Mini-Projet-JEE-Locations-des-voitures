package dao;

import java.util.List;

import entities.Client;

public interface IClientDAO {
	
	public  Client ajouterClient(Client c);
	
	public  Client modifierClient(Client c);
	
	public void supprimerClient(int id);
	
	public Client rechercherClientParId(int id);
	
	public List<Client> rechercherClientsParNom(String nom);
	
	public List<Client> rechercherClientParAutre(/* Depend on attributes*/);
	
	public List<Client> getAllClients();

}
