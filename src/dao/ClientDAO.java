package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.Client;

public class ClientDAO implements IClientDAO {

	@Override
	public Client ajouterClient(Client c) {
		
		Connection connection = SingletonConnection.getConnexion();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO CLIENT "
					+ "( NumPermis, Nom, Prenom, Email, MotDePasse) VALUES (?, ?, ?, ?, ?)");

			ps.setString(1, c.getNumPermis());
			ps.setString(2, c.getNom());
			ps.setString(3, c.getPrenom());
			ps.setString(4, c.getEmail());
			ps.setString(5, c.getMotDePasse());

			ps.executeUpdate();

			PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(IdClient) AS MAX_ID FROM CLIENT");

			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				c.setIdClient(rs.getInt("MAX_ID"));
			}
			ps.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Client modifierClient(Client c) {
		Connection connection = SingletonConnection.getConnexion();
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE CLIENT "
					+ "SET NumPermis = ?,SET Nom = ?,SET Prenom = ?,"
					+ "SET Email = ?,SET MotDePasse = ? WHERE IdClient = ?");

			ps.setString(1, c.getNumPermis());
			ps.setString(2, c.getNom());
			ps.setString(3, c.getPrenom());
			ps.setString(4, c.getEmail());
			ps.setString(5, c.getMotDePasse());
			ps.setInt(6, c.getIdClient());

			ps.executeUpdate();

			// on peut retourner directement le Client de parametre.
			
			PreparedStatement ps1 = connection.prepareStatement("SELECT IdClient, NumPermis, Nom, Prenom, Email, MotDePasse"
					+ "FROM CLIENT WHERE IdClient = ?");

			ps1.setInt(1, c.getIdClient());
		
			ResultSet rs = ps1.executeQuery();
			if (rs.next()) {
		
				c.setNumPermis(rs.getString("NumPermis"));
				c.setNom(rs.getString("Nom"));
				c.setPrenom(rs.getString("Prenom"));
				c.setEmail(rs.getString("Email"));
				c.setMotDePasse(rs.getString("MotDePasse"));
			}
			ps.close();
			ps1.close();
			rs.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public void supprimerClient(int id) {
		
		Connection connection = SingletonConnection.getConnexion();
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM CLIENT WHERE IdClient = ?");

			ps.setInt(1, id);

			ps.executeUpdate();
		
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public List<Client> getAllClients() {
		List<Client> clients = new ArrayList<>();
		Connection connection = SingletonConnection.getConnexion();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"SELECT IdClient, NumPermis, Nom, Prenom, Email, MotDePasse"
							+ "FROM CLIENT");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				Client c = new Client();
				c.setIdClient(rs.getInt("IdClient"));
				c.setNumPermis(rs.getString("NumPermis"));
				c.setNom(rs.getString("Nom"));
				c.setPrenom(rs.getString("Prenom"));
				c.setEmail(rs.getString("Email"));
				c.setMotDePasse(rs.getString("MotDePasse"));
				
				clients.add(c);	
			}
			ps.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}

	@Override
	public Client rechercherClientParId(int id) {
		Client c = new Client();
		Connection connection = SingletonConnection.getConnexion();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"SELECT IdClient, NumPermis, Nom, Prenom, Email, MotDePasse"
							+ "FROM CLIENT WHERE IdClient = ?");

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				c.setIdClient(rs.getInt("IdClient"));
				c.setNumPermis(rs.getString("NumPermis"));
				c.setNom(rs.getString("Nom"));
				c.setPrenom(rs.getString("Prenom"));
				c.setEmail(rs.getString("Email"));
				c.setMotDePasse(rs.getString("MotDePasse"));
			}
			ps.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<Client> rechercherClientsParNom(String nom) {
		
		List<Client> clients = new ArrayList<>();
		Connection connection = SingletonConnection.getConnexion();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"SELECT IdClient, NumPermis, Nom, Prenom, Email, MotDePasse"
							+ "FROM CLIENT WHERE Nom = ?");

			ps.setString(1, nom);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				Client c = new Client();
				c.setIdClient(rs.getInt("IdClient"));
				c.setNumPermis(rs.getString("NumPermis"));
				c.setNom(rs.getString("Nom"));
				c.setPrenom(rs.getString("Prenom"));
				c.setEmail(rs.getString("Email"));
				c.setMotDePasse(rs.getString("MotDePasse"));
				
				clients.add(c);	
			}
			ps.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}

	@Override
	public List<Client> rechercherClientParAutre() {
		// TODO Auto-generated method stub
		return null;
	}
}

