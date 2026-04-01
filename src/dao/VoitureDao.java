package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.Voiture;

public class VoitureDAO implements IVoitureDAO{

	@Override
	public Voiture ajouterVoiture(Voiture v) {
		Connection connection = SingletonConnection.getConnexion();
		try {
			PreparedStatement ps = connection.prepareStatement
					("INSERT INTO VOITURE (Matricule, Marque, Modele, Categorie, PrixJour, Image) VALUES(?,?,?,?,?,?)");
			ps.setString(1, v.getMatricule());
			ps.setString(2, v.getMarque());
			ps.setString(3, v.getModele());
			ps.setString(4, v.getCategorie());
			ps.setInt(5, v.getPrixJour());
			ps.setString(6, v.getImage());
			ps.executeUpdate();
			PreparedStatement ps2 = connection.prepareStatement
					("SELECT MAX(IdVoiture) AS MAX_ID FROM VOITURE");
			ResultSet rs = ps2.executeQuery();
			if(rs.next()) {
				v.setIdVoiture(rs.getInt("MAX_ID"));
			}
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}

	@Override
	public Voiture modifierVoiture(Voiture v) {
		Connection connection = SingletonConnection.getConnexion();
		try {
			PreparedStatement ps = connection.prepareStatement
					("UPDATE VOITURE SET Matricule = ?, "
							+ "Marque = ?,"
							+ "Modele = ?,"
							+ "PrixJour = ?,"
							+ "Categorie = ?,"
							+ "Image = ? "
							+ "WHERE IdVoiture = ?");
			
			ps.setString(1, v.getMatricule());
			ps.setString(2, v.getMarque());
			ps.setString(3, v.getModele());
			ps.setInt(4, v.getPrixJour());
			ps.setString(5, v.getCategorie());
			ps.setString(6, v.getImage());
			ps.setInt(7, v.getIdVoiture());
			
			ps.executeUpdate();
			
			// on peut retourner directement la voiture de parametre.
			
			PreparedStatement ps1 = connection.prepareStatement
					("SELECT IdVoiture, Matricule, Marque, Modele, PrixJour, Categorie, Image "
							+ "FROM VOITURE WHERE IdVoiture = ?");
			ps1.setInt(1, v.getIdVoiture());
			
			ResultSet rs = ps1.executeQuery();
			if(rs.next()) {
				v.setIdVoiture(rs.getInt("IdVoiture"));
				v.setMatricule(rs.getString("Matricule"));
				v.setMarque(rs.getString("Marque"));
				v.setModele(rs.getString("Modele"));
				v.setPrixJour(rs.getInt("PrixJour"));
				v.setCategorie(rs.getString("Categorie"));
				v.setImage(rs.getString("Image"));
			}
			
			ps.close();
			ps1.close();
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}

	@Override
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

	@Override
	public Voiture rechercherVoitureParId(int id) {
		Voiture v = null ;
		Connection connection = SingletonConnection.getConnexion();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT IdVoiture, Matricule, Marque, Modele, PrixJour, Categorie, Image "
							+ "FROM VOITURE WHERE IdVoiture = ?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				v = new Voiture();
				v.setIdVoiture(rs.getInt("IdVoiture"));
				v.setMatricule(rs.getString("Matricule"));
				v.setMarque(rs.getString("Marque"));
				v.setModele(rs.getString("Modele"));
				v.setPrixJour(rs.getInt("PrixJour"));
				v.setCategorie(rs.getString("Categorie"));
				v.setImage(rs.getString("Image"));
			}
			
			ps.close();
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}

	@Override
	public List<Voiture> getAllVoitures() {
		List<Voiture> voitures = new ArrayList<>();
		Connection connection = SingletonConnection.getConnexion();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT IdVoiture, Matricule, Marque, Modele, PrixJour, Categorie, Image "
							+ "FROM VOITURE");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Voiture v = new Voiture();
				v.setIdVoiture(rs.getInt("IdVoiture"));
				v.setMatricule(rs.getString("Matricule"));
				v.setMarque(rs.getString("Marque"));
				v.setModele(rs.getString("Modele"));
				v.setPrixJour(rs.getInt("PrixJour"));
				v.setCategorie(rs.getString("Categorie"));
				v.setImage(rs.getString("Image"));
				
				voitures.add(v);
			}
			ps.close();
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return voitures;
	}

	@Override
	public List<Voiture> rechercherVoituresParMarque(String marque) {
		List<Voiture> voitures = new ArrayList<>();
		Connection connection = SingletonConnection.getConnexion();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT IdVoiture, Matricule, Marque, Modele, PrixJour, Categorie, Image "
							+ "FROM VOITURE WHERE Marque = ?");
			ps.setString(1, marque);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Voiture v = new Voiture();
				v.setIdVoiture(rs.getInt("IdVoiture"));
				v.setMatricule(rs.getString("Matricule"));
				v.setMarque(rs.getString("Marque"));
				v.setModele(rs.getString("Modele"));
				v.setPrixJour(rs.getInt("PrixJour"));
				v.setCategorie(rs.getString("Categorie"));
				v.setImage(rs.getString("Image"));
				
				voitures.add(v);
			}
			ps.close();
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return voitures;
	}

	// amodifier les parametre est ce que date fin ou debut ..?
	@Override
	public List<Voiture> rechercherVoituresParCatDate(String categorie, Date dateDisponibilite) {
		List<Voiture> voitures = new ArrayList<>();
		Connection connection = SingletonConnection.getConnexion();
		String sql ;
		if(categorie.equals("tout")) {
		
			sql = "SELECT IdVoiture, Matricule, Marque, Modele, PrixJour, Categorie, Image"
					+ " FROM VOITURE WHERE IdVoiture NOT IN "
					+ "(SELECT IdVoiture FROM RESERVATION WHERE DateFin >= ?)"; 
		}else {
			
			sql = "SELECT IdVoiture, Matricule, Marque, Modele, PrixJour, Categorie, Image"
					+ " FROM VOITURE WHERE IdVoiture NOT IN "
					+ "(SELECT IdVoiture FROM RESERVATION WHERE DateFin >= ?)"
					+ " AND Categorie = ?";
		}
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setDate(1, dateDisponibilite);
			
			if(!categorie.equals("tout")) {
	            ps.setString(2, categorie);
	        }
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Voiture v = new Voiture();
				v.setIdVoiture(rs.getInt("IdVoiture"));
				v.setMatricule(rs.getString("Matricule"));
				v.setMarque(rs.getString("Marque"));
				v.setModele(rs.getString("Modele"));
				v.setPrixJour(rs.getInt("PrixJour"));
				v.setCategorie(rs.getString("Categorie"));
				v.setImage(rs.getString("Image"));
				
				voitures.add(v);
			}
			ps.close();
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return voitures;
	}

	@Override
	public Voiture rechercherVoitureParMatricule(String matricule) {
		Voiture v = new Voiture();
		Connection connection = SingletonConnection.getConnexion();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT IdVoiture, Matricule, Marque, Modele, PrixJour, Categorie, Image "
							+ "FROM VOITURE WHERE Matricule = ?");
			ps.setString(1, matricule);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				v.setIdVoiture(rs.getInt("IdVoiture"));
				v.setMatricule(rs.getString("Matricule"));
				v.setMarque(rs.getString("Marque"));
				v.setModele(rs.getString("Modele"));
				v.setPrixJour(rs.getInt("PrixJour"));
				v.setCategorie(rs.getString("Categorie"));
				v.setImage(rs.getString("Image"));
			}
			
			ps.close();
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}

	@Override
	public Voiture rechercherVoituresParAutre() {
		// TODO Auto-generated method stub
		return null;
	}
}
