package jcolonia.daw2023.g4d;

import static java.lang.System.out;

/**
 * Genera diez elementos «{@link Grupo4DMejorado}» con números aleatorios.
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel@educa.jcyl.es&gt;
 * @version 1.0 (20240201)
 */
public class Ensayo4DMejorado {

	/**
	 * Genera 10 listas de grupos de 4 números aleatorios.
	 * 
	 * @param args argumentos deseados
	 */

	public static void main(String[] args) {
		Grupo4DMejorado grupo;
		double[] lista = { Math.random(), Math.random(), Math.random(), Math.random() };

		try {

			for (int i = 1; i <= 10; i++) {
				grupo = new Grupo4DMejorado(lista);
				out.println(grupo);
			}

		} catch (Grupo4DException ex) {
			String mensaje = String.format(("Error insperado al generar la lista: %s"), ex.getLocalizedMessage());

			System.err.println(mensaje); // ex.printStackTrace(); → Equivalente a mensaje de la pila de java

			System.exit(27);

		}

	}
}
