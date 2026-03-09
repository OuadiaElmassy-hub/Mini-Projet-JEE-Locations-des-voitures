package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.Reservation;;

public class ReservationDao {
	public Reservation reserver(Reservation r) {
		Connection connection = SingletonConnection.getConnexion();
		try {
			PreparedStatement ps = connection.prepareStatement
					("INSERT INTO RESERVATION (IdReservation, DateDebut, DateFin, Montant,"
						+ " statusReservation, statusPaiement) VALUES (?, ?, ?, ?, ?, ?)");
			
			ps.setLong(1, r.getIdReservation());
			ps.setDate(2, r.getDateDebut());
			ps.setDate(3, r.getDateFin());
			ps.setDouble(4, r.getMontant());
			ps.setString(5, r.getStatutReservation());
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

	public List<Reservation> chercherReservationDate(Date dateDebut, Date dateFin) {
		List<Reservation> reservations = new ArrayList<>();
		Connection connection = SingletonConnection.getConnexion();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"SELECT IdReservation, DateDebut, DateFin, Montant, statusReservation, statusPaiement"
							+ "FROM RESERVATION WHERE DateDebut = ? AND DateFin = ?");
			
			ps.setDate(1, dateDebut);
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

	public Reservation getReservation(int id) {
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

	public Reservation modifierReservation(Reservation r) {
		return r;
	}

	public void supprimerReservation(int id) {

	}
}
