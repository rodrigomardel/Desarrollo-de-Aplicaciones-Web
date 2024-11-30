package jcolonia.daw2023.sorteos;

import static java.lang.System.out;

/**
 * Programa ejemplo de uso del {@link BomboGenérico} en el que se simula el
 * lanzamiento de una moneda. Las monedas presentan dos superficies planas: la
 * delantera suele representar la cara de un personaje y la trasera puede
 * incluir motivos variados. La probabilidad de que la moneda se mantenga sobre
 * el canto es infinitesimal y así la probabilidad de cualquiera de las dos
 * superficies planas se considera del 50&nbsp;%.
 * 
 * @author <a href= "mailto:dmartin.jcolonia@gmail.com">David H. Martín</a>
 * @version 3.0 (20240228)
 *
 */
public class SorteoMoneda {
	/**
	 * Resultados del lanzamiento de una moneda al aire: cara y cruz.
	 */
	enum Moneda {
		/** Anverso de la moneda. */
		CARA,
		/** Reverso de la moneda. */
		CRUZ
	};

	/**
	 * Elige al azar uno de los dos lados de una moneda.
	 * 
	 * @param args argumentos dados al ejecutar: no se usan
	 */
	public static void main(String[] args) {
		BomboGenérico<Moneda> bombo;

		bombo = BomboGenérico.of(Moneda.class); // Moneda.values()
		out.printf("¡¡¡Ha salido «%s»!!!", bombo.sacarBola());
	}
}
