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
			
			// on peut retourner directement la voiture de parametre.
			
			PreparedStatement ps1 = connection.prepareStatement
					("SELECT IdVoiture, Matricule, Marque, Modele, PrixJour, Categorie "
							+ "FROM VOITURE WHERE IdVoiture = ?");
			ps1.setInt(1, v.getIdVoiture());
			
			ResultSet rs = ps1.executeQuery();
			if(rs.next()) {
				v.setMatricule(rs.getString("Matricule"));
				v.setMarque(rs.getString("Marque"));
				v.setModele(rs.getString("Modele"));
				v.setCategorie(rs.getString("Categorie"));
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
		Voiture v = new Voiture();
		Connection connection = SingletonConnection.getConnexion();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT IdVoiture, Matricule, Marque, Modele, PrixJour, Categorie "
							+ "FROM VOITURE WHERE IdVoiture = ?");
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

	@Override
	public List<Voiture> getAllVoitures() {
		List<Voiture> voitures = new ArrayList<>();
		Connection connection = SingletonConnection.getConnexion();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT IdVoiture, Matricule, Marque, Modele, PrixJour, Categorie "
							+ "FROM VOITURE");
			
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

	@Override
	public List<Voiture> rechercherVoituresParMarque(String marque) {
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

	@Override
	public List<Voiture> rechercherVoituresParCatDate(String categorie, Date dateDebut, Date dateFin) {
		List<Voiture> voitures = new ArrayList<>();
		Connection connection = SingletonConnection.getConnexion();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT IdVoiture, Matricule, Marque, Modele, PrixJour, Categorie "
							+ "FROM VOITURE V JOIN RESERVATION R"
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

	@Override
	public Voiture rechercherVoitureParMatricule(String matricule) {
		Voiture v = new Voiture();
		Connection connection = SingletonConnection.getConnexion();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT IdVoiture, Matricule, Marque, Modele, PrixJour, Categorie "
							+ "FROM VOITURE WHERE Matricule = ?");
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

	@Override
	public Voiture rechercherVoituresParAutre() {
		// TODO Auto-generated method stub
		return null;
	}
}
