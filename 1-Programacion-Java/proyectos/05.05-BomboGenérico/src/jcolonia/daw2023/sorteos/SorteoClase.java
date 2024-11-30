package jcolonia.daw2023.sorteos;

/**
 * Programa ejemplo de uso del {@link Bombo} en el que se ordena una lista al
 * azar.
 * 
 * @author <a href= "mailto:rodrigo.mardel@educa.jcyl.es">Rodrigo Martínez
 *         Delgado</a>
 * @version 1.4 (20240209)
 */
public class SorteoClase {
	/** Lista de nombre de ejemplo. */
	private static final String[] LISTA_NOMBRES_PREDETERMINADA = { "David", "Hugo", "Juan", "Rubén" };

	/**
	 * Ordena al azar de una lista. Si no se facilita ningún nombre al ejecutar el
	 * programa se emplea la {@link #LISTA_NOMBRES_PREDETERMINADA lista de ejemplo}.
	 * 
	 * @param args argumentos dados al ejecutar: los nombres objeto del sorteo
	 */
	public static void main(String[] args) {
		Bombo<String> bombo;
		String[] nombres;

		int i;

		try {

			nombres = (args.length > 0) ? args : LISTA_NOMBRES_PREDETERMINADA;

			bombo = Bombo.of(nombres);

			i = 1;
			while (bombo.getNúmBolas() > 0) {
				System.out.printf("¡¡¡El %d es «%s»!!!%n", i, bombo.sacarBola());
				i++;
			}

		} catch (SorteoException ex) {
			String mensaje = String.format(("Error insperado al generar el sorteo: %s"), ex.getLocalizedMessage());
			System.err.println(mensaje);
			System.exit(27);

		}
	}
}
