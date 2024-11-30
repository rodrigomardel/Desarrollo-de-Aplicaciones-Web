package jcolonia.daw2023.sqlite.países;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class ConfiguraciónSQL {

	public ConfiguraciónSQL() {
	}

	public static void main(String[] args) {
		Properties configuración = new Properties();

		try {
			configuración.setProperty("jdbc.url", "jdbc:sqlite:world2.db");
			configuración.setProperty("jdbc.user", "Rodrigo");
			configuración.setProperty("jdbc.password", "1234");

			FileOutputStream out = new FileOutputStream("config.xml");
			configuración.storeToXML(out, "Configuración BD", "UTF-8");

			configuración = new Properties();
			FileInputStream in = new FileInputStream("config.xml");
			configuración.loadFromXML(in);
			configuración.getProperty("jdbc.url");
			configuración.getProperty("jdbc.user");
			configuración.getProperty("jdbc.password");
			
		} catch (FileNotFoundException ex) {
			System.err.printf("Error: %s%n\t-%s-%n", "No se ha localizado el archivo.", ex.getLocalizedMessage());
			ex.printStackTrace();
		} catch (InvalidPropertiesFormatException ex) {
			System.err.printf("Error: %s%n\t-%s-%n", "Formato inválido.", ex.getLocalizedMessage());
			ex.printStackTrace();
		} catch (IOException ex) {
			System.err.printf("Error: %s%n\t-%s-%n", "No se ha creado la base de datos SQLite",
					ex.getLocalizedMessage());
			ex.printStackTrace();
			System.exit(1);
		}
	}

}
