package jcolonia.daw2023.sorteos;

import static java.lang.System.out;

/**
 * Programa ejemplo de uso del {@link BomboGenérico} en el que se ordena al azar
 * una lista de nombres.
 * 
 * @author <a href= "mailto:dmartin.jcolonia@gmail.com">David H. Martín</a>
 * @version 3.0 (20240228)
 */
public class SorteoClase {
	/** Lista de nombre de ejemplo. */
	private static final String[] LISTA_NOMBRES_PREDETERMINADA = { "Andrés", "Beatriz", "Cosme", "Diana", "Evelio",
			"Flora" };

	/**
	 * Elige repetidamente un nombre al azar de una lista hasta vaciarla. Si no se
	 * facilita ningún nombre al ejecutar el programa se emplea la
	 * {@link #LISTA_NOMBRES_PREDETERMINADA lista de ejemplo}.
	 * 
	 * @param args argumentos dados al ejecutar: los nombres objeto del sorteo
	 */
	public static void main(String[] args) {
		BomboGenérico<String> bombo;
		String[] nombres = args.length > 0 ? args : LISTA_NOMBRES_PREDETERMINADA;

		int i;

		bombo = BomboGenérico.of(nombres);

		i = 1;
		while (bombo.getNúmBolas() > 0) {
			out.printf("¡¡¡El %d es «%s»!!!%n", i, bombo.sacarBola());
			i++;
		}
	}
}
