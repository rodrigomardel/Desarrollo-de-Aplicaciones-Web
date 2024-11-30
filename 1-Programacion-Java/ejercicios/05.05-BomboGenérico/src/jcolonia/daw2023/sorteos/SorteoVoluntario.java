package jcolonia.daw2023.sorteos;

/**
 * Programa ejemplo de uso del {@link Bombo} en el que se extrae al azar un
 * único nombre de una lista.
 * 
 * @author <a href= "mailto:rodrigo.mardel@educa.jcyl.es">Rodrigo Martínez Delgado</a>
 * @version 1.4 (20240209)
 */
public class SorteoVoluntario {
	/** Lista de nombre de ejemplo. */
	private static final String[] LISTA_NOMBRES_PREDETERMINADA = { "David", "Hugo", "Igor", "Rubén" };

	/**
	 * Elige un nombre al azar de una lista. Si no se facilita ningún nombre al
	 * ejecutar el programa se emplea la {@link #LISTA_NOMBRES_PREDETERMINADA lista
	 * de ejemplo}.
	 * 
	 * @param args argumentos dados al ejecutar: los nombres objeto del sorteo
	 */
	public static void main(String[] args) {
		String[] nombres = args.length > 0 ? args : LISTA_NOMBRES_PREDETERMINADA;
		Bombo bombo;

		try {

			bombo = new Bombo(nombres);

			System.out.printf("¡¡¡El ganador es «%s»!!!", bombo.sacarBola());

		} catch (SorteoException ex) {
			String mensaje = String.format(("Error insperado al generar el sorteo: %s"), ex.getLocalizedMessage());

			System.err.println(mensaje);

			System.exit(27);
		}
	}
}
