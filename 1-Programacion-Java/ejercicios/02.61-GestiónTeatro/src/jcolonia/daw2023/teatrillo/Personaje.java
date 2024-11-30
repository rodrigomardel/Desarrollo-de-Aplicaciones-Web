/**
 * UT2 Ejemplo de clase con herencia implementando interfaces.
 */
package jcolonia.daw2023.teatrillo;

import jcolonia.daw2023.teatrillo.gestión.Cotizable;

/**
 * Sujeto que interactúa saludando al resto de personajes, contabilizando el número de frases.
 */
public class Personaje extends Actor implements Cotizable{
	
	/**
	 * Contador del número de frases.
	 */
	private int númFrases;
	

	/**
	 * Crea un personaje con el nombre deseado, inicializa el número de frases.
	 * @param nombre el nombre deseado
	 */
	public Personaje (String nombre) {

		super(nombre);
		númFrases = 0;
			
	}
	
	/**
	 * Incrementa el número de frases de cada personaje.
	 */
	private void anotaFrase() {
		númFrases++;
		
	}
	
	/**
	 * Genera un texto saludando.
	 * @return texto correspondiente
	 */
	public String saluda() {
		String texto;
		anotaFrase();
		texto = String.format("%s saluda [%d]",getNombre(),númFrases);
		return texto;
		
	}
	
	/**
	 * Genera un texto saludando al nuevo actor.
	 * @param nuevoActor el nuevo actor
	 * @return texto correspondiente
	 */
	public String saluda(Actor nuevoActor) {
		String texto;
		anotaFrase();
		texto = String.format("%s saluda a %s [%d]", getNombre(), nuevoActor.getNombre(),númFrases);
		return texto;		
		
	}
	
	/**
	 * Genera un texto de despedida.
	 * @return texto correspondiente
	 */
	public String despide() {
		String texto;
		anotaFrase();
		texto=String.format("%s se "
				+ "despide [%d]",getNombre(),númFrases);
		return texto;
		
	}
	
	/**
	 * Genera un texto de despedida al ex actor.
	 * @param exActor el actor ya generado
	 * @return texto correspondiente
	 */
	public String despide(Actor exActor) {
		String texto;
		anotaFrase();
		texto = String.format("%s despide a %s [%d]", getNombre(), exActor.getNombre(),númFrases);
		return texto;	
		
	}

	/**
	 * Consulta el identificador convirtiendolo a texto.
	 * @return texto correspondiente
	 */
	public String getIdentificador() {
		String texto;
		texto = String.format("%d",getId());
		return texto;
	}
	
	/**
	 * Consulta el número de frases.
	 * @return el valor correspondiente
	 */
	@Override
	public double getCantidad() {
		double cantidad;
		cantidad = númFrases;		
		return cantidad;
	}

	/**
	 * Consulta el coeficiente.
	 * @return valor constante 1
	 */
	@Override
	public double getCoeficiente() {
		return 1;
	}
	
}
