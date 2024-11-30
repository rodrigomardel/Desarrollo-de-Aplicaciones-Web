package jcolonia.daw2023.sorteos;

/**
 * Programa ejemplo de uso del {@link BomboGenérico} en el que se extrae al azar
 * un único nombre de una lista.
 * 
 * @author <a href= "mailto:dmartin.jcolonia@gmail.com">David H. Martín</a>
 * @version 3.0 (20240228)
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
		BomboGenérico<String> bombo;
		String[] nombres = args.length > 0 ? args : LISTA_NOMBRES_PREDETERMINADA;

		bombo = BomboGenérico.of(nombres);
		System.out.printf("¡¡¡El ganador es «%s»!!!", bombo.sacarBola());
	}
}
