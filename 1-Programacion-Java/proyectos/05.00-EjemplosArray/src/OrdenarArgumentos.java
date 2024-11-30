import java.util.Arrays;

/**
 * - UT5 - Clase de ejemplo para ordenar los argumentos que recibe el main con
 * clases de utilidad.
 *
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel@educa.jcyl.es&gt;
 * @version 1.0 (20240216)
 */
public class OrdenarArgumentos {
	/**
	 * Lista de cadenas de texto.
	 */
	private String[] textos;

	/**
	 * Copia una lista de cadenas de texto truncando o rellenando con nulos (si es
	 * necesario).
	 * 
	 * @param entradas la lista de cadenas de texto
	 */
	public OrdenarArgumentos(String[] entradas) {
		textos = Arrays.copyOf(entradas, entradas.length);

	}

	/**
	 * Ordena alfabeticamente la lista de cadenas de texto.
	 */
	private void ordenar() {
		Arrays.sort(textos);
	}

	/**
	 * Ordena todos los carácteres alfabeticamente en orden inverso de la lista de
	 * cadenas de texto.
	 */
	private void ordenar2() {
		Arrays.sort(textos, (String a, String b) -> -a.compareTo(b));
	}

	/**
	 * 
	 */
	public String toString() {
		return Arrays.toString(textos);
	}

	/**
	 * Ejecuta los argumentos y los ordena.
	 * 
	 * @param args argumentos deseados
	 */
	public static void main(String[] args) {
		OrdenarArgumentos ordenador;

		if (args.length > 0) {
			ordenador = new OrdenarArgumentos(args);
			System.out.printf("Originales: %s%n", ordenador);

			ordenador.ordenar();
			System.out.printf("Ordenados: %s%n", ordenador);

		}
	}

}
