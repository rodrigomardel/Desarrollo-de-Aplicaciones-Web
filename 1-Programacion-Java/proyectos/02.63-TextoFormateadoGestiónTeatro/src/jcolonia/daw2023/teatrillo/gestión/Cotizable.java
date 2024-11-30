/**
 * Ampliación para contabilidad de operaciones realizadas.
 */
package jcolonia.daw2023.teatrillo.gestión;

/**
 * Sujeto compatible con {@link Nominilla}.
 * 
 * @author David H. Martín
 * @version 5.0 (20231211)
 */
public interface Cotizable {
	/**
	 * Datos utilizados para rellenar cada línea de la nóminilla.
	 * @param id          código de identificación del sujeto
	 * @param nombre      nombre completo del sujeto
	 * @param cantidad    número de unidades trabajadas
	 * @param coeficiente coeficiente a multiplicar por el precio por unidad
	 * @see Cotizable#getIdentificador()
	 * @see Cotizable#getNombre()
	 * @see Cotizable#getCantidad()
	 * @see Cotizable#getCoeficiente()
	 */
	public record DatosNómina(String id, String nombre, double cantidad, double coeficiente) {
	}

	/**
	 * Precio base unitario a pagar.
	 */
	final double PRECIO = 48.08;

	/**
	 * Facilita un código de identificación del sujeto. Se recomienda que sea un
	 * código único, distinto de cualquier otro sujeto.
	 * 
	 * @return el texto correspondiente
	 */
	String getIdentificador();

	/**
	 * Facilita el nombre completo del sujeto.
	 * 
	 * @return el texto correspondiente
	 */
	String getNombre();

	/**
	 * Facilita el número de unidades trabajadas.
	 * 
	 * @return el valor correspondiente
	 */
	double getCantidad();

	/**
	 * Facilita un coeficiente a multiplicar por el precio por unidad establecido.
	 * 
	 * @return el valor correspondiente
	 */
	double getCoeficiente();

	/**
	 * Facilita los datos necesarios agrupados.
	 * @return los datos correspondientes
	 */
	DatosNómina getDatos();

}
