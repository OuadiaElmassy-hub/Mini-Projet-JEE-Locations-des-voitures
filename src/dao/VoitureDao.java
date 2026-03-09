package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.Voiture;

public class VoitureDao {
	public Voiture ajouterVoiture(Voiture v) {
		Connection connection = SingletonConnection.getConnexion();
		try {
			PreparedStatement ps = connection.prepareStatement
					("INSERT INTO VOITURE (Matricule, Marque, Modele, PrixJour) VALUES(?,?,?,?)");
			ps.setString(1, v.getMatricule());
			ps.setString(2, v.getMarque());
			ps.setString(3, v.getModele());
			ps.setDouble(4, v.getPrixJour());
			ps.executeUpdate();
			PreparedStatement ps2 = connection.prepareStatement
					("SELECT MAX(IdVoiture) AS MAX_ID FROM VOITURE");
			ResultSet rs = ps2.executeQuery();
			if(rs.next()) {
				v.setIdVoiture(rs.getInt("MAX_ID"));
			}
			ps.close();
			// connection.close(); non si on utilise un singleton.
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}
	
	public List<Voiture> chercherVoitureMarque(String marque){
		List<Voiture> voitures = new ArrayList<>();
		Connection connection = SingletonConnection.getConnexion();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT IdVoiture, Matricule, Marque, Modele, PrixJour, Categorie "
							+ "FROM VOITURE WHERE Marque = ?");
			ps.setString(1, marque);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Voiture v = new Voiture();
				v.setIdVoiture(rs.getInt("IdVoiture"));
				v.setMatricule(rs.getString("Matricule"));
				v.setMarque(rs.getString("Marque"));
				v.setModele(rs.getString("Modele"));
				v.setCategorie(rs.getString("Categorie"));
				
				voitures.add(v);
			}
			ps.close();
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return voitures;
	}
	
	public List<Voiture> chercherVoitureCatDate(String categorie, Date dateDebut, Date dateFin){
		List<Voiture> voitures = new ArrayList<>();
		Connection connection = SingletonConnection.getConnexion();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT IdVoiture, Matricule, Marque, Modele, PrixJour, Categorie "
							+ "FROM VOITURES V JOIN RESERVATION R"
							+ "ON V.IdVoiture = R.IdVoiture"
							+ "WHERE V.Categorie = ? AND R.DateDebut = ? AND R.DateFin = ?");
			ps.setString(1, categorie);
			ps.setDate(2, dateDebut);
			ps.setDate(3, dateFin);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Voiture v = new Voiture();
				v.setIdVoiture(rs.getInt("IdVoiture"));
				v.setMatricule(rs.getString("Matricule"));
				v.setMarque(rs.getString("Marque"));
				v.setModele(rs.getString("Modele"));
				v.setCategorie(rs.getString("Categorie"));
				
				voitures.add(v);
			}
			ps.close();
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return voitures;
	}
	
	public Voiture getVoiture(int id) {
		Voiture v = new Voiture();
		Connection connection = SingletonConnection.getConnexion();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT IdVoiture, Matricule, Marque, Modele, PrixJour, Categorie "
							+ "FROM VOITURES WHERE IdVoiture = ?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				v.setIdVoiture(rs.getInt("IdVoiture"));
				v.setMatricule(rs.getString("Matricule"));
				v.setMarque(rs.getString("Marque"));
				v.setModele(rs.getString("Modele"));
				v.setCategorie(rs.getString("Categorie"));
			}
			
			ps.close();
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}
	
	public Voiture getVoitureMatricule(String matricule) {
		Voiture v = new Voiture();
		Connection connection = SingletonConnection.getConnexion();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT IdVoiture, Matricule, Marque, Modele, PrixJour, Categorie "
							+ "FROM VOITURES WHERE Matricule = ?");
			ps.setString(1, matricule);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				v.setIdVoiture(rs.getInt("IdVoiture"));
				v.setMatricule(rs.getString("Matricule"));
				v.setMarque(rs.getString("Marque"));
				v.setModele(rs.getString("Modele"));
				v.setCategorie(rs.getString("Categorie"));
			}
			
			ps.close();
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}
	
	public Voiture modifierVoiture(Voiture v) { // Dépend de se qu'on veut modifier
		Connection connection = SingletonConnection.getConnexion();
		try {
			PreparedStatement ps = connection.prepareStatement
					("UPDATE VOITURE SET Matricule = ?, "
							+ "SET Marque = ?,"
							+ "SET Modele = ?,"
							+ "SET PrixJour = ?,"
							+ "SET Categorie = ? "
							+ "WHERE IdVoiture = ?");
			
			ps.setString(1, v.getMatricule());
			ps.setString(2, v.getMarque());
			ps.setString(3, v.getModele());
			ps.setDouble(4, v.getPrixJour());
			ps.setString(5, v.getCategorie());
			ps.setInt(6, v.getIdVoiture());
			
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}
	
	public void supprimerVoiture(int id) {
		Connection connection = SingletonConnection.getConnexion();
		try {
			PreparedStatement ps = connection.prepareStatement
					("DELETE FROM VOITURE WHERE IdVoiture = ?");
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
