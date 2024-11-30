package jcolonia.daw2023.sorteos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/**
 * Colección de elementos con extracción aleatoria. Simula el funcionamiento de
 * un «bombo» para sorteos diversos. Versión genérica avanzada.
 * 
 * @see TestsGeneralesBombo
 * 
 * @author <a href= "mailto:rodrigo.mardel@educa.jcyl.es">Rodrigo Martínez
 *         Delgado</a>
 * @version 3.0 (20240229)
 * @param <E> tipos de elementos a guardar del sorteo
 */
public class Bombo<E> {
	/**
	 * Conjunto de elementos de cualquier tipo,entre los que se produce el sorteo.
	 */
	private Vector<E> bolsa;

	/**
	 * Último elemento anteriormente extraído. <em>null</em> si no se ha realizado
	 * todavía ninguna extracción.
	 */
	private E bandeja;

	/** Generador de valores aleatorios -pseudoaleatorios. */
	private final static Random rnd;

	static {
		rnd = new Random();
	}

	/**
	 * @param elementos
	 */
	public Bombo(List<E> elementos) {
		bolsa = new Vector<E>(elementos.size());
		for (E elemento : elementos) {
			bolsa.add(elemento);
		}
		bandeja = null;
	}

//	/**
//	 * Carga el bombo con etiquetas para indicar los elementos objeto del sorteo.
//	 * 
//	 * @param etiquetas la lista con los todos textos correspondientes
//	 * @throws SorteoException lanza la excepción si la lista está nula o vacía
//	 */
//	public Bombo(E[] etiquetas) throws SorteoException {
//		if (etiquetas == null || etiquetas.length == 0) {
//			throw new SorteoException("Lista nula o vacía.");
//		}
//		bolsa = new Vector<String>(etiquetas.length);
//		for (String elemento : etiquetas) {
//			bolsa.add(elemento);
//		}
//
//		bandeja = null;
//	}

	/**
	 * Carga el bombo con etiquetas,textos objeto del sorteo.
	 * 
	 * @param etiquetas la lista con los todos textos correspondientes
	 * @return bomo de etiquetas
	 * @throws SorteoException lanza la excepción si la lista está nula o vacía
	 */
	public static Bombo<String> of(String[] etiquetas) throws SorteoException {
		if (etiquetas == null || etiquetas.length == 0) {
			throw new SorteoException("Lista nula o vacía.");
		}
		Bombo<String> resultado;
		List<String> lista = new ArrayList<String>();

		for (String etiqueta : etiquetas) {
			lista.add(etiqueta);
		}
		resultado = new Bombo<String>(lista);
		return resultado;
	}

	/**
	 * Carga el bombo con los elementos deseados.
	 * 
	 * @param <T>       tipos de elementos a guardar
	 * @param etiquetas
	 * @return
	 * @throws SorteoException
	 */
	public static <T> Bombo<T> of(T[] etiquetas) throws SorteoException {
		if (etiquetas == null || etiquetas.length == 0) {
			throw new SorteoException("Lista nula o vacía.");
		}
		Bombo<T> resultado;
		List<T> lista = new ArrayList<T>();

		for (T etiqueta : etiquetas) {
			lista.add(etiqueta);
		}
		resultado = new Bombo<T>(lista);
		return resultado;
	}

	/**
	 * Carga el bombo con una secuencia de números –enteros– consecutivos que serán
	 * los objetos del sorteo.
	 * 
	 * @param primero el valor inicial a incluir
	 * @param último  el valor final a incluir
	 * @return el bombo con los valores recibidos
	 * @throws SorteoException lanza la excepción si los valores de los números son
	 *                         negativos o el último valor es menor que el primero
	 */
	public static Bombo<Integer> of(int primero, int último) throws SorteoException {
		if (primero < 0 || último < primero) {
			throw new SorteoRTException("Valores negativos o último valor menor que el primero.");
		}
		Bombo<Integer> bombo;
		List<Integer> lista = new ArrayList<Integer>();

		for (int i = primero; i < último; i++) {
			lista.add(i);
		}
		bombo = new Bombo<Integer>(lista);
		return bombo;
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
	public E getBandeja() {
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
	public E sacarBola() throws SorteoRTException {
		if (getNúmBolas() == 0) {
			throw new SorteoRTException("No se pueden sacar bolas, el bomo está vacío.");
		}
		int posición;

		posición = rnd.nextInt(bolsa.size());
		bandeja = bolsa.remove(posición);

		return bandeja;
	}
}
