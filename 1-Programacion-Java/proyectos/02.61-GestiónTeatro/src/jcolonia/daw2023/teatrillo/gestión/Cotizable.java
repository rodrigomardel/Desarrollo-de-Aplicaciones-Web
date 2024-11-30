/** Ampliación para contabilidad de operaciones realizadas.*/
package jcolonia.daw2023.teatrillo.gestión;

/**
 * Sujeto compatible con {@link Nominilla}.
 * 
 * @author David H. Martín
 * @version 4.0 (20221212)
 */
public interface Cotizable {
	
	/**
	 * Precio base unitario a pagar.
	 */
	final double PRECIO=48.08;

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

}
