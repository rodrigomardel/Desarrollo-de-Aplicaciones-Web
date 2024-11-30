package jcolonia.daw2023.junio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccesoBD {

	public AccesoBD() {
	}

	/**
	 * Campos de los países que conforman la base de datos.
	 * 
	 * @param nombrePaís  nombre correspondiente
	 * @param capitalPaís capital correspondiente
	 * @param idiomaPaís  idioma correspondiente
	 */
	public record País(String nombrePaís, String capitalPaís, String idiomaPaís) {

		/**
		 * Crea un texto con el formato de los países.
		 * 
		 * @return texto correspondiente
		 */
		@Override
		public final String toString() {
			String texto;
			texto = String.format("País: %s\t\t Capital: %s\t\t Idioma:%s\n", nombrePaís, capitalPaís, idiomaPaís);
			return texto;
		}

	}

	public País leerDatos(int posición) {
		País paísActual = null;

		try {
			Connection conexión = DriverManager.getConnection("jdbc:sqlite:world2.db");
			Statement sentenciaSQL = conexión.createStatement();
			PreparedStatement preparaciónSQL;

			// Conexión fallida: ¿conexión == null? ¿try/catch?
			{
				// …obrar en consecuencia
			}

			sentenciaSQL.setQueryTimeout(5);

			preparaciónSQL = conexión.prepareStatement("SELECT * from Country  LIMIT 1 OFFSET ?");
			preparaciónSQL.setQueryTimeout(5);
			preparaciónSQL.setInt(1, posición);

			ResultSet loteDatos = preparaciónSQL.executeQuery();

			String nombre;
			String capital;
			String idioma;

			while (loteDatos.next()) {
				nombre = loteDatos.getString("Name");
				capital = loteDatos.getString("Capital");
				idioma = loteDatos.getString("Language");
				paísActual = new País(nombre, capital, idioma);
			}
		} catch (SQLException ex) {
			System.err.printf("Error: %s%n\t-%s-%n", "No se ha creado la base de datos SQLite",
					ex.getLocalizedMessage());
			ex.printStackTrace();
		}
		return paísActual;

	}

}
