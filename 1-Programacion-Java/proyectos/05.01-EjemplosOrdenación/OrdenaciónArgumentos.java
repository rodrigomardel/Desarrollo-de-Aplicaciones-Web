package jcolonia.daw2023.ordenación;

import java.text.Collator;
import java.util.Arrays;

/**
 * UT5: Ejemplo de ordenación de cadenas de texto usando {@link Arrays#sort} con
 * variantes.
 * 
 * @author <a href= "mailto:dmartin.jcolonia@gmail.com">David H. Martín</a>
 * @version 1.0 (20240215)
 */
public class OrdenaciónArgumentos {
	/** La lista de textos objeto de ordenación. */
	private String[] textos;

	/**
	 * Crea la lista de textos.
	 * 
	 * @param entradas una lista con los textos originales
	 */
	public OrdenaciónArgumentos(String[] entradas) {
		textos = Arrays.copyOf(entradas, entradas.length);
	}

	/**
	 * Ordenación simple con {@link Arrays#sort(Object[])} basado en la comparación
	 * natural de {@link String#compareTo(String)}. Da resultados no deseados con
	 * caracteres especiales (p.ej.: caracteres con acentos).
	 */
	private void ordenar1() {
		Arrays.sort(textos);
	}

	/**
	 * Ordenación inversa con {@link Arrays#sort(Object[], java.util.Comparator)}
	 * específicada mediante una expresión lambda. Da resultados no deseados con
	 * caracteres especiales (p.ej.: caracteres con acentos).
	 */
	private void ordenar2() {
		Arrays.sort(textos, (String a, String b) -> -a.compareTo(b));
	}

	/**
	 * Ordenación con {@link Arrays#sort(Object[], java.util.Comparator)}
	 * específicada mediante un comparador sensible a a localización predeterminada
	 * del sistema {@link Collator#getInstance()}. Da resultados correctos con
	 * caracteres especiales (p.ej.: caracteres con acentos).
	 */
	private void ordenar3() {
		Arrays.sort(textos, Collator.getInstance());
	}

	/**
	 * Ordenación inversa con {@link Arrays#sort(Object[], java.util.Comparator)}
	 * específicada mediante una expresión lambda apoyada en un comparador sensible
	 * a a localización predeterminada del sistema {@link Collator#getInstance()}.
	 * Da resultados correctos con caracteres especiales (p.ej.: caracteres con
	 * acentos).
	 */
	/**
	 * 
	 */
	private void ordenar4() {
		Collator ordenaciónLocal = Collator.getInstance();
		Arrays.sort(textos, (String a, String b) -> -ordenaciónLocal.compare(a, b));
	}

	/**
	 * Concatena todas los textos, separados por comas.
	 * 
	 * @return el texto completo
	 */
	@Override
	public String toString() {
		return String.join(", ", textos);
	}

	/**
	 * Recoge los textos introducidos al ejecutar en la línea de órdenes y los
	 * muestra ordenados con cada uno de los métodos incluidos.
	 * 
	 * @param args los textos, palabras a ordenar
	 */
	public static void main(String[] args) {
		if (args.length > 0) {
			final var ordenador = new OrdenaciónArgumentos(args);

			System.out.printf("Originales: %s%n", ordenador);

			ordenador.ordenar1();
			System.out.printf("Ordenados (1): %s%n", ordenador);

			ordenador.ordenar2();
			System.out.printf("Ordenados (2): %s%n", ordenador);

			ordenador.ordenar3();
			System.out.printf("Ordenados (3): %s%n", ordenador);

			ordenador.ordenar4();
			System.out.printf("Ordenados (4): %s%n", ordenador);
		}
	}
}
