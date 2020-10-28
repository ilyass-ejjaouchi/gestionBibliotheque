package ensa.liberarie.dao;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.FileAlreadyExistsException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SingletonConnection {
	private static final String FICHIER_PROPERTIES = "config.properties";
	private static final String PROPERTY_URL = "url";
	private static final String PROPERTY_DRIVER = "driver";
	private static final String PROPERTY_NOM_UTILISATEUR = "username";
	private static final String PROPERTY_MOT_DE_PASSE = "password";

	private static Connection cnx;

	static {
		// Private constructor to restrict new instances
		try {
			Properties properties = new Properties();

			String url;
			String driver;
			String user;
			String password;

			InputStream fichierProperties = SingletonConnection.class.getClassLoader()
					.getResourceAsStream(FICHIER_PROPERTIES);

			properties.load(fichierProperties);
			url = properties.getProperty(PROPERTY_URL);
			driver = properties.getProperty(PROPERTY_DRIVER);
			user = properties.getProperty(PROPERTY_NOM_UTILISATEUR);
			password = properties.getProperty(PROPERTY_MOT_DE_PASSE);

			Class.forName("com.mysql.jdbc.Driver");
			CreateConnection(url, user, password);
			System.out.println("sucess");
		} 
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	}

	private static void CreateConnection(String url, String user, String passwd) throws SQLException{
		cnx = DriverManager.getConnection(url, user, passwd);
	}

	public static Connection getConnection() {
		return cnx;
	}

}
