package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.Reservation;;

public class ReservationDAO implements IReservationDAO{

	@Override
	public Reservation ajouterReservation(Reservation r) {
		Connection connection = SingletonConnection.getConnexion();
		try {
			PreparedStatement ps = connection.prepareStatement
					("INSERT INTO RESERVATION (DateDebut, DateFin, Montant,"
						+ " statusReservation, statusPaiement) VALUES (?, ?, ?, ?, ?)");
			
			ps.setDate(1, r.getDateDebut());
			ps.setDate(2, r.getDateFin());
			ps.setDouble(3, r.getMontant());
			ps.setString(4, r.getStatutReservation());
			ps.setString(5, r.getStatutPaiement());
			
			ps.executeUpdate();
			
			PreparedStatement ps2 = connection.prepareStatement
					("SELECT MAX(IdReservation) AS MAX_ID FROM RESERVATION");
			
			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				r.setIdReservation(rs.getInt("MAX_ID"));
			}
			ps.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public Reservation modifierReservation(Reservation r) {
		Connection connection = SingletonConnection.getConnexion();
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE RESERVATION "
					+ "SET DateDebut = ?, SET DateFin = ?, SET Montant = ?,"
					+ "SET statusReservation = ?, SET statusPaiement = ? "
					+ "WHERE IdReservation = ?");
			
			ps.setDate(1, r.getDateDebut());
			ps.setDate(2, r.getDateFin());
			ps.setDouble(3, r.getMontant());
			ps.setString(4, r.getStatutReservation());
			ps.setString(5, r.getStatutPaiement());
			ps.setInt(6, r.getIdReservation());

			ps.executeUpdate();
			
			// on peut retourner directement la reservation de parametre.
			
			PreparedStatement ps2 = connection.prepareStatement("SELECT IdReservation, "
					+ "DateDebut, DateFin, Montant, statusReservation, statusPaiement" 
					+ "FROM RESERVATION WHERE IdReservation = ?");
			
			ps2.setInt(1, r.getIdReservation());

			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				
				r.setDateDebut(rs.getDate("DateDebut"));
				r.setDateFin(rs.getDate("DateFin"));
				r.setMontant(rs.getDouble("Montant"));
				r.setStatutReservation(rs.getString("StatusReservation"));
				r.setStatutPaiement(rs.getString("StatusPaiement"));
			}
			ps.close();
			ps2.close();
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;	
	}

	@Override
	public void supprimerReservation(int id) {
		Connection connection = SingletonConnection.getConnexion();
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM RESERVATION WHERE IdReservation = ?");

			ps.setInt(1, id);

			ps.executeUpdate();
		
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public Reservation rechercherReservationParId(int id) {
		Reservation r = new Reservation();
		Connection connection = SingletonConnection.getConnexion();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"SELECT IdReservation, DateDebut, DateFin, Montant, statusReservation, statusPaiement"
					+ "FROM RESERVATION WHERE IdReservation = ?");
			
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				r.setIdReservation(rs.getInt("IdReservation"));
				r.setDateDebut(rs.getDate("DateDebut"));
				r.setDateFin(rs.getDate("DateFin"));
				r.setMontant(rs.getDouble("Montant"));
				r.setStatutReservation(rs.getString("StatusReservation"));
				r.setStatutPaiement(rs.getString("StatusPaiement"));
			}
			ps.close();
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public List<Reservation> getAllReservations() {
		List<Reservation> reservations = new ArrayList<>();
		Connection connection = SingletonConnection.getConnexion();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"SELECT IdReservation, DateDebut, DateFin, Montant, statusReservation, "
					+ "statusPaiement FROM RESERVATION");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				Reservation r = new Reservation();
				r.setIdReservation(rs.getInt("IdReservation"));
				r.setDateDebut(rs.getDate("DateDebut"));
				r.setDateFin(rs.getDate("DateFin"));
				r.setMontant(rs.getDouble("Montant"));
				r.setStatutReservation(rs.getString("StatusReservation"));
				r.setStatutPaiement(rs.getString("StatusPaiement"));
				
				reservations.add(r);
			}
			ps.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservations;
	}

	@Override
	public List<Reservation> rechercherReservationParDateDebut(Date dateDebut) {
		List<Reservation> reservations = new ArrayList<>();
		Connection connection = SingletonConnection.getConnexion();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"SELECT IdReservation, DateDebut, DateFin, Montant, statusReservation, statusPaiement"
							+ "FROM RESERVATION WHERE DateDebut = ?");
			
			ps.setDate(1, dateDebut);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				Reservation r = new Reservation();
				r.setIdReservation(rs.getInt("IdReservation"));
				r.setDateDebut(rs.getDate("DateDebut"));
				r.setDateFin(rs.getDate("DateFin"));
				r.setMontant(rs.getDouble("Montant"));
				r.setStatutReservation(rs.getString("StatusReservation"));
				r.setStatutPaiement(rs.getString("StatusPaiement"));
				
				reservations.add(r);
			}
			ps.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservations;
	}

	@Override
	public List<Reservation> rechercherReservationParDateFin(Date dateFin) {
		List<Reservation> reservations = new ArrayList<>();
		Connection connection = SingletonConnection.getConnexion();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"SELECT IdReservation, DateDebut, DateFin, Montant, statusReservation, statusPaiement"
							+ "FROM RESERVATION WHERE DateFin = ?");
			
			ps.setDate(2, dateFin);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				Reservation r = new Reservation();
				r.setIdReservation(rs.getInt("IdReservation"));
				r.setDateDebut(rs.getDate("DateDebut"));
				r.setDateFin(rs.getDate("DateFin"));
				r.setMontant(rs.getDouble("Montant"));
				r.setStatutReservation(rs.getString("StatusReservation"));
				r.setStatutPaiement(rs.getString("StatusPaiement"));
				
				reservations.add(r);
			}
			ps.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservations;
	}

	@Override
	public Reservation rechercherReservationParAutre() {
		return null;
	}
}
