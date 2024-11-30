package jcolonia.daw2023.sorteos;

import java.util.Random;

/**
 * Colección de valores con extracción aleatoria. Simula el funcionamiento de un
 * «bombo» para sorteos diversos. Versión básica de referencia inicial
 * incompleta.
 * 
 * @see TestsGeneralesBombo
 * 
 * @author <a href= "mailto:dmartin.jcolonia@gmail.com">David H. Martín</a>
 * @version 20240130000
 */
public class Bombo {
	/**
	 * Conjunto de textos, etiquetas de los elementos entre los que se produce el
	 * sorteo. Los elementos disponibles deben estar siempre colocados de manera
	 * consecutiva, sin huecos, al comienzo.
	 */
	private String[] bolsa;

	/** Número de elementos disponibles que hay para la próxima extracción. */
	private int númBolas;

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
	 * @throws SorteoRTException lista de etiquetas nula o vacía
	 */
	public Bombo(String[] etiquetas) throws SorteoRTException {
		if (etiquetas == null || etiquetas.length <= 0) {
			throw new SorteoRTException("Bombo vacío");
		}
		bolsa = new String[etiquetas.length];
		for (int i = 0; i < etiquetas.length; i++) {
			bolsa[i] = etiquetas[i];
		}

		númBolas = bolsa.length;
		bandeja = null;
	}

	/**
	 * Carga el bombo con una secuencia de números –enteros– consecutivos que serán
	 * los objetos del sorteo.
	 * 
	 * @param primero el valor inicial a incluir
	 * @param último  el valor final a incluir
	 */
	public Bombo(int primero, int último) {
		bolsa = new String[último - primero + 1];

		for (int i = 0, j = primero; i < bolsa.length; i++, j++) {
			bolsa[i] = String.format("%d", j);
		}

		númBolas = bolsa.length;
		bandeja = null;
	}

	/**
	 * Informa del número de elementos que quedan en cada momento sin extraer.
	 * 
	 * @return el valor correspondiente
	 */
	public int getNúmBolas() {
		return númBolas;
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
	 * @throws SorteoRTException bombo vacío
	 */
	public String sacarBola() throws SorteoRTException {
		if (getNúmBolas() <= 0) {
			throw new SorteoRTException("Bombo vacío");
		}
		int posición;

		posición = rnd.nextInt(númBolas);
		bandeja = bolsa[posición];

		bolsa[posición] = bolsa[númBolas - 1];
		númBolas--;

		return bandeja;
	}
}
