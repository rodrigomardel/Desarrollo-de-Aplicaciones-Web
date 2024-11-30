package jcolonia.daw2023.g4d;

import static java.lang.System.out;

/**
 * Genera diez elementos «{@link Grupo4D}» con números aleatorios.
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel@educa.jcyl.es&gt;
 * @version 1.0 (20240118)
 */

public class Ensayo4D {

	/**
	 * Genera 10 grupos de 4 números aleatorios.
	 * 
	 * @param args argumentos deseados
	 */

	public static void main(String[] args) {
		Grupo4D grupo;

		for (int i = 1; i <= 10; i++) {
			grupo = new Grupo4D(Math.random(), Math.random(), Math.random(), Math.random());
			out.println(grupo);

		}

	}

}
