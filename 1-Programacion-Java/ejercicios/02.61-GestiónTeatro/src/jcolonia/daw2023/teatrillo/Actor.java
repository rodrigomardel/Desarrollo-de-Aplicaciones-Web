/** UT2, ejemplo de clases con herencia empleando interfaces.*/
package jcolonia.daw2023.teatrillo;

/**
 * Individuo del que almacenamos datos de identificación básicos: nombre e identificador.
 */

public class Actor {
	/** El nombre. */
	private String nombre;
	
	/** El Identificador numérico. */
	private int id;
	
	/** El número de actores creados hasta el momento. */
	private static int númActores;
	
	static {
		númActores=0;
	}
	
	/**
	 * Inicializa los datos básicos. Emplea como identificador el número de secuencia, el número de 
	 * actores creados empezando por 1.
	 * @param nombre el nombre deseado
	 */
	public Actor(String nombre) {
		this.nombre=nombre;
		
		númActores++;
		this.id=númActores;		
		
	}
	
	/** Consulta el nombre.
	 * @return el texto correspondiente
	 */
	public String getNombre() {
		return nombre;
		
	}
	
	/** Consulta el identificador.
	 * @return el número correspondiente
	 */
	public int getId() {
		return id;
		
	}
	
	/**
	 * Facilita un texto descriptivo con información del actor.
	 * <div>
	 * Ejemplo:
	 * <pre>
	 * Juan Luis Galiardo (54/5686)
	 * </pre>
	 * </div>
	 * 
	 * @return el texto correspondiente
	 */
	public String toString() {
		String texto;
		texto=String.format("%s (%d/%d)", nombre,id,númActores);
		return texto;
		
	}
	
	/**
	 * Facilita el número de actores creados hasta el momento.
	 * 
	 * @return el número correspondiente
	 */
	public static int getNúmActores() {
		return númActores;
		
	}
}
