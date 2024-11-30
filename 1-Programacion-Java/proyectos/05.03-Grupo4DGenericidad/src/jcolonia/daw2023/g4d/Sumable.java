package jcolonia.daw2023.g4d;

/**
 * Ampliación para la realizar operaciones.
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel@educa.jcyl.es&gt;
 * @version 1.0 (20240118)
 */
public interface Sumable {
	
	/**
	 * Facilita la suma de los valores.
	 * 
	 * @return el resultado correspondiente
	 */
	double suma();
	
	/**
	 * Facilita la media de los valores.
	 * 
	 * @return el resultado correspondiente
	 */
	double media();
	
	/**
	 * Facilita el máximo de los valores.
	 * 
	 * @return el resultado correspondiente
	 */
	double máximo();
	
	/**
	 * Facilita el mínimo de los valores.
	 * 
	 * @return el resultado correspondiente
	 */
	double mínimo();

}
