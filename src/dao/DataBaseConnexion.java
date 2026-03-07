package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import model.Client;
import model.Reservation;
import model.Voiture;

public class DataBaseConnexion {
	private String jdbcURL = "jdbc:mysql://localehost:3306/location_voitures";
	private String jdbcUsername = "root";
	private String jdbcPassWord = "";
	
	private static final String INSERT_Client = "INSERT INTO CLIENT (npermis, name, email, password)"
			+ "VALUES (?, ?, ?, ?)";
	
	private static final String INSERT_Reservation = "INSERT INTO RESERVATION "
			+ "(idReservation, dateDebut, dateFin, montant, statusReservation, statusPaiement)"
			+ "VALUES (?, ?, ?, ?, ?, ?)";
	
	private static final String INSERT_Voiture = "INSERT INTO VOITURE (idVoiture, marque, modele, prixJour)"
			+ "VALUES (?, ?, ?, ?)";
	
	Connection connection = null;
	
	protected Connection getConnexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassWord);
		} catch(ClassNotFoundException e){
			e.getStackTrace();
		} catch(SQLException e) {
			e.getStackTrace();
		}
		return connection;
	}
	
	protected void insertReservation(Reservation r) throws SQLException {
		Statement statement = connection.createStatement();
		
	}
	
	protected void insertClient(Client c) {
		
	}
	
	protected void insertVoiture(Voiture v) {
		
	}

}
