package jcolonia.daw2023.g4d;

/**
 * Conjunto en forma de («<em>array</em>») de un número determinado de elementos
 * «{@link Grupo4D}».
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel@educa.jcyl.es&gt;
 * @version 2.0 (20240221)
 */
public class Conjunto4D {

	/**
	 * Lista de Grupos4D.
	 */
	private Grupo4D[] lista;

	/**
	 * Número de elementos de la lista.
	 */
	private int númElementos;

	/**
	 * Inicializa la lista y el número de elementos.
	 * 
	 * @param capacidad tamaño deseado
	 * @throws Grupo4DException si el tamaño de la lista no está permitido o el
	 *                          número de elementos es 0 o menor
	 */
	public Conjunto4D(int capacidad) throws Grupo4DException {
		if (capacidad < 2 || capacidad > 15) {
			throw new Grupo4DException("Tamaño no permitido");

		}

		lista = new Grupo4D[capacidad];
		númElementos = 0;

	}

	/**
	 * Consulta un elemento en una posición determinada dentro de la lista.
	 * 
	 * @param posición de consulta deseada
	 * @return elemento consultado
	 * @throws Grupo4DException si la posición es menor de 0 o mayor que la longitud
	 *                          de la lista
	 */
	public Grupo4D consultarElemento(int posición) throws Grupo4DException {
		if (posición < 0 || posición > númElementos) {
			throw new Grupo4DException("Posición menor que 0, mayor o igual que la capacidad de la lista");
		}

		Grupo4D grupo;
		grupo = lista[posición];

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
		if (posición < 0 || posición > númElementos) {
			throw new Grupo4DException("Posición menor de 0 o mayor que el número de elementos");
		}
		Grupo4D grupo;

		grupo = lista[posición];

		lista[posición] = lista[númElementos - 1];
		lista[númElementos - 1] = null;
		númElementos--;

		return grupo;

	}

	/**
	 * Añade un nuevo elemento a la lista.
	 * 
	 * @param elementoNuevo elemento que se desea añadir
	 * @throws Grupo4DException si la lista está llena o el elemento es nulo
	 */
	public void añadirElemento(Grupo4D elementoNuevo) throws Grupo4DException {
		if (númElementos >= lista.length || elementoNuevo == null) {
			throw new Grupo4DException("Lista llena o elemento nulo");

		}

		lista[númElementos++] = elementoNuevo;

	}

	/**
	 * Amplia la lista de grupos en un número determinado de elementos.
	 * 
	 * @param incremento deseado
	 * @throws Grupo4DException lanza una excepción si el incremento en menor o
	 *                          igual a cero
	 */
	public void ampliarLista(int incremento) throws Grupo4DException {
		if (incremento <= 0) {
			throw new Grupo4DException("Incremento no válido, menor o igual a cero");
		}
		Grupo4D[] nuevaLista;

		nuevaLista = new Grupo4D[lista.length + incremento];

		for (int i = 0; i < lista.length; i++) {
			nuevaLista[i] = lista[i];
		}

		lista = nuevaLista;

	}

	/**
	 * Consulta el número de elementos de la lista.
	 * 
	 * @return número de elementos
	 */
	public int getNúmElementos() {
		return númElementos;

	}

	/**
	 * Consulta si la lista de elementos está llena.
	 * 
	 * @return verdadero
	 */
	public boolean estáLleno() {
		boolean listaLlena;

		listaLlena = númElementos >= lista.length;

		return listaLlena;

	}

}
