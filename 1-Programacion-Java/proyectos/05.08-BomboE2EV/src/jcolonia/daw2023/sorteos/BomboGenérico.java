package jcolonia.daw2023.sorteos;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Colección de elementos de los que se pueden ir retirando unidades
 * aleatoriamente. Versión avanzada genérica.
 * 
 * @author <a href= "mailto:dmartin.jcolonia@gmail.com">David H. Martín</a>
 * @version 3.0 (20240228)
 * 
 * @param <E> el tipo común de todos los elementos
 */
public class BomboGenérico<E> {
	/** Almacén de elementos. */
	private Vector<E> bolsa;

	/**
	 * Registro del último elemento extraído. «<code>null</code>» si todavía no se
	 * ha realizado ninguna extracción.
	 */
	private E bandeja;

	/**
	 * Rellena el bombo con los elementos iniciales. Realiza una copia de la lista
	 * facilitada.
	 * 
	 * @param elementos la colección de elementos iniciales
	 */
	private BomboGenérico(List<E> elementos) {
		bolsa = new Vector<E>(elementos);
		bandeja = null;
	}

	/**
	 * Crea un bombo con los elementos iniciales.
	 * 
	 * @param <T>       el tipo de los elementos iniciales
	 * @param elementos la colección de elementos iniciales
	 * @return el nuevo bombo creado
	 */
	public static <T> BomboGenérico<T> of(List<T> elementos) {
		return new BomboGenérico<T>(elementos);
	}

	/**
	 * Crea un bombo con los elementos iniciales.
	 * 
	 * @param <T>       el tipo de los elementos iniciales
	 * @param elementos la tabla de elementos iniciales
	 * @return el nuevo bombo creado
	 */
	public static <T> BomboGenérico<T> of(T[] elementos) {
		return new BomboGenérico<T>(asList(elementos));
	}

	/**
	 * Crea un bombo con números enteros consecutivos.
	 * 
	 * @param primero el primer número incluido
	 * @param último  el último número incluido
	 * @return el nuevo bombo creado
	 */
	public static BomboGenérico<Integer> of(int primero, int último) {
		var originales = new ArrayList<Integer>();

		for (int j = primero; j <= último; j++) {
			originales.add(j);
		}

		return new BomboGenérico<Integer>(originales);
	}

	/**
	 * Crea un bombo con los valores de una enumeración.
	 * 
	 * @param <N>         el tipo de enumeración
	 * @param enumeración la clase de la enumeración
	 * @return el nuevo bombo creado
	 * @see Class#getEnumConstants()
	 */
	public static <N extends Enum<N>> BomboGenérico<N> of(Class<N> enumeración) {
		return new BomboGenérico<N>(asList(enumeración.getEnumConstants()));
	}

	/**
	 * Facilita el número de elementos restantes.
	 * 
	 * @return el valor correspondiente
	 */
	public int getNúmBolas() {
		return bolsa.size();
	}

	/**
	 * Facilita el último elemento extraído o «<code>null</code>» si todavía no se
	 * ha realizado ninguna extracción.
	 * 
	 * @return el elemento correspondiente
	 */
	public E getBandeja() {
		return bandeja;
	}

	/**
	 * Extrae un elemento del bombo y lo deja disponible en la bandeja.
	 * 
	 * @return el elemento extraído
	 * @see #bandeja
	 */
	public E sacarBola() {
		Random rnd;
		int posición;

		rnd = ThreadLocalRandom.current();
		posición = rnd.nextInt(bolsa.size());
		bandeja = bolsa.remove(posición);

		return bandeja;
	}
}
