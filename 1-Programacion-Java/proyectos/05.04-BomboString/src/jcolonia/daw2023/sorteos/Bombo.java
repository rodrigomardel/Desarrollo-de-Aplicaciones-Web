package jcolonia.daw2023.sorteos;

import java.util.Random;
import java.util.Vector;

/**
 * Colección de valores con extracción aleatoria. Simula el funcionamiento de un
 * «bombo» para sorteos diversos. Versión completa utilizando colecciones.
 * incompleta.
 * 
 * @see TestsGeneralesBombo
 * @see Vector
 * 
 * @author <a href= "mailto:rodrigo.mardel@educa.jcyl.es">Rodrigo Martínez
 *         Delgado</a>
 * @version 2.0 (20240228)
 */
public class Bombo {
	/**
	 * Conjunto de textos, etiquetas de los elementos entre los que se produce el
	 * sorteo. Los elementos disponibles deben estar siempre colocados de manera
	 * consecutiva, sin huecos, al comienzo.
	 */
	private Vector<String> bolsa;

	/**
	 * Texto, etiqueta del último elemento anteriormente extraído. <em>null</em> si
	 * no se ha realizado todavía ninguna extracción.
	 */
	private String bandeja;

	/** Generador de valores aleatorios -pseudoaleatorios. */
	private final static Random rnd;

	static {
		rnd = new Random();
	}

	/**
	 * Carga el bombo con etiquetas para indicar los elementos objeto del sorteo.
	 * 
	 * @param etiquetas la lista con los todos textos correspondientes
	 * @throws SorteoException lanza la excepción si la lista está nula o vacía
	 */
	public Bombo(String[] etiquetas) throws SorteoException {
		if (etiquetas == null || etiquetas.length == 0) {
			throw new SorteoException("Lista nula o vacía.");
		}
		bolsa = new Vector<String>(etiquetas.length);
		for (String elemento : etiquetas) {
			bolsa.add(elemento);
		}

		bandeja = null;
	}

	/**
	 * Carga el bombo con una secuencia de números –enteros– consecutivos que serán
	 * los objetos del sorteo.
	 * 
	 * @param primero el valor inicial a incluir
	 * @param último  el valor final a incluir
	 * @throws SorteoException lanza la excepción si los valores de los números son
	 *                         negativos o el último valor es menor que el primero
	 */
	public Bombo(int primero, int último) throws SorteoException {
		if (primero < 0 || último < primero) {
			throw new SorteoRTException("Valores negativos o último valor menor que el primero.");
		}

		bolsa = new Vector<String>(último - primero + 1);
		for (int j = primero; j <= último; j++) {
			bolsa.add(String.format("%d", j));
		}

		bandeja = null;
	}

	/**
	 * Informa del número de elementos que quedan en cada momento sin extraer.
	 * 
	 * @return el valor correspondiente
	 */
	public int getNúmBolas() {
		return bolsa.size();
	}

	/**
	 * Informa del último elemento extraído.
	 * 
	 * @return el texto de la etiqueta correspondiente
	 */
	public String getBandeja() {
		return bandeja;
	}

	/**
	 * Extrae un elemento al elemento al azar. Se elige una posición de manera
	 * «pseudoaleatoria» y se mueve allí el último elemento elegible de la lista
	 * para no dejar huecos.
	 * 
	 * @return el texto de la etiqueta correspondiente a la extracción
	 * @throws SorteoRTException lanza la excepción si el bombo está vacío
	 */
	public String sacarBola() throws SorteoRTException {
		if (getNúmBolas() == 0) {
			throw new SorteoRTException("No se pueden sacar bolas, el bomo está vacío.");
		}
		int posición;

		posición = rnd.nextInt(bolsa.size());
		bandeja = bolsa.remove(posición);

		return bandeja;
	}
}
