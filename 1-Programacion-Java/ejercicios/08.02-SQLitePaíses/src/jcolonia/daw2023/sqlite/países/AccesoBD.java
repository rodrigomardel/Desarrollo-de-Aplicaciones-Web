package jcolonia.daw2023.sqlite.países;

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

	public static List<País> leerDatos(String textoRecibido) throws NombrePaísException {
		verificarTextoNoNulo(textoRecibido);
		verificarNombreVálido(textoRecibido);
		
		String fuente = "jdbc:sqlite:world2.db";

		List<País> listadoPaíses = new ArrayList<País>();

		try {
			Connection conexión = DriverManager.getConnection(fuente);
			Statement sentenciaSQL = conexión.createStatement();
			PreparedStatement preparaciónSQL;

			// Conexión fallida: ¿conexión == null? ¿try/catch?
			{
				// …obrar en consecuencia
			}

			sentenciaSQL.setQueryTimeout(5);

			preparaciónSQL = conexión.prepareStatement("SELECT * from Country where Name like '%"+textoRecibido+"%'");
			preparaciónSQL.setQueryTimeout(5);

			ResultSet loteDatos = preparaciónSQL.executeQuery();

			String nombre;
			String capital;
			String idioma;

			while (loteDatos.next()) {
				nombre = loteDatos.getString("Name");
				capital = loteDatos.getString("Capital");
				idioma = loteDatos.getString("Language");
				País paísActual = new País(nombre, capital, idioma);
				listadoPaíses.add(paísActual);
			}
		} catch (SQLException ex) {
			System.err.printf("Error: %s%n\t-%s-%n", "No se ha creado la base de datos SQLite",
					ex.getLocalizedMessage());
			ex.printStackTrace();
		}
		return listadoPaíses;

	}
	
	/**
	 * Comprueba que el nombre del país sea válido. La longitud del nombre debe
	 * estar en el rango [4, 60].
	 * 
	 * @param texto el nombre a verificar
	 * @throws NombrePaísException si la longitud del nombre no es adecuada.
	 */
	protected static void verificarNombreVálido(String texto) throws NombrePaísException {
		if (texto.length() < 4) {
			throw new NombrePaísException("Nombre demasiado corto");
		} else if (texto.length() > 40) {
			throw new NombrePaísException("Nombre demasiado largo");
		}

	}
	
	/**
	 * Verifica que se haya proporcionado un texto.
	 * 
	 * @param texto el dato a comprobar
	 * @throws NombrePaísException si el texto es nulo o está vacío
	 */
	public static void verificarTextoNoNulo(String texto) throws NombrePaísException {
		if (texto == null || texto.length() == 0) {
			throw new NombrePaísException("Dato vacío");
		}
	}

}
