package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// cette classe permis de creer la connexion à la bdd mais pour chaque requete, alors on peut utiliser 
// le patern singleton ou ona une connexion statique.
// ca d on fait la connexion dans un bloc static et dans la methode getConnection on retourn la connection.

public class SingletonConnection {
	//private static String jdbcURL = "jdbc:mysql://localehost:3306/location_voitures";
	//private static String jdbcUsername = "root";
	//private static String jdbcPassWord = "";
		
	private static Connection connection = null;
	static {
		try { // car il se peut qu'on ne trouve pas la classe : classe not found exception.
			// charger le pilote jdbc :
			Class.forName("com.mysql.cj.jdbc.Driver");
			// creation de la connection
			connection = DriverManager.getConnection("jdbc:mysql://localehost:3306/location_voitures", "root", "");
		
		} catch(ClassNotFoundException e){
			e.getStackTrace();
		
		} catch(SQLException e) {
			e.getStackTrace();
		}
	}
	
	public static Connection getConnexion() {	
		return connection;
	}
}
