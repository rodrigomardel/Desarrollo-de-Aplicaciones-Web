package jcolonia.daw2023.g4d;

import java.util.ArrayList;

/**
 * Conjunto en forma de («<em>array</em>») de un número determinado de elementos
 * «{@link Grupo4D}».
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel@educa.jcyl.es&gt;
 * @version 2.0 (20240228)
 * @param <G>
 */
public class Conjunto4D<G extends Grupo4D & Comparable<G>> {

	/**
	 * Lista de Grupos4D.
	 */
	private ArrayList<G> lista;

	/**
	 * Inicializa la lista y el número de elementos.
	 * 
	 * @param capacidad tamaño deseado
	 * @throws Grupo4DException si el tamaño de la lista no está permitido o el
	 *                          número de elementos es 0 o menor
	 */
	public Conjunto4D(int capacidad) throws Grupo4DException {
		if (capacidad < 2 || capacidad > 250) {
			throw new Grupo4DException("Tamaño no permitido");

		}

		lista = new ArrayList<G>(capacidad);

	}

	/**
	 * Consulta un elemento en una posición determinada dentro de la lista.
	 * 
	 * @param posición de consulta deseada
	 * @return elemento consultado
	 * @throws Grupo4DException si la posición es menor de 0 o mayor que la longitud
	 *                          de la lista
	 */
	public G consultarElemento(int posición) throws Grupo4DException {
//		if (posición < 0) {
//			throw new Grupo4DException("Posición menor que 0, mayor o igual que la capacidad de la lista");
//		}

		G grupo;
		grupo = lista.get(posición);

		return grupo;

	}

	/**
	 * Elimina un elemento de una posición determinada dentro de la lista y añade el
	 * último elemento de la lista a la posición eliminada.
	 * 
	 * @param posición a eliminar deseada
	 * @return elemento eliminado
	 * @throws Grupo4DException si la posición es menor de 0 o mayor que el número
	 *                          de elementos
	 */
	public Grupo4D eliminarElemento(int posición) throws Grupo4DException {
//		if (posición < 0) {
//			throw new Grupo4DException("Posición menor de 0 o mayor que el número de elementos");
//		}
		Grupo4D grupo;

		grupo = lista.remove(posición);

		return grupo;

	}

	/**
	 * Añade un nuevo elemento a la lista.
	 * 
	 * @param elementoNuevo elemento que se desea añadir
	 * @throws Grupo4DException si la lista está llena o el elemento es nulo
	 */
	public void añadirElemento(G elementoNuevo) throws Grupo4DException {

		lista.add(elementoNuevo);
	}

	/**
	 * No tiene mayor utilidad pero garantiza la ampliación de la lista de grupos en
	 * un número determinado de elementos.
	 * 
	 * @param incremento deseado
	 * @throws Grupo4DException lanza una excepción si el incremento en menor o
	 *                          igual a cero
	 */
	public void ampliarLista(int incremento) throws Grupo4DException {
//		if (incremento <= 0) {
//			throw new Grupo4DException("Incremento no válido, menor o igual a cero");
//		}

		lista.ensureCapacity(lista.size() + incremento);

	}

	/**
	 * Consulta el número de elementos de la lista.
	 * 
	 * @return número de elementos
	 */
	public int getNúmElementos() {
		return lista.size();

	}

	/**
	 * Consulta si la lista de elementos está llena.
	 * 
	 * @return verdadero
	 */
	public boolean estáLleno() {

		return false;

	}

	/**
	 * Ordena los elementos de la lista usando la media.
	 */
	public void ordenar() {
		// lista.sort(null); //Usa orden natural, comparable.
		lista.sort((G g1, G g2) -> g1.compareTo(g2));
	}

}
