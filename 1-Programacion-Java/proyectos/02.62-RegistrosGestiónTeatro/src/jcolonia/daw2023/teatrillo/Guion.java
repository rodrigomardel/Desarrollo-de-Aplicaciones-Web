package jcolonia.daw2023.teatrillo;

import jcolonia.daw2023.teatrillo.gestión.Nominilla;

/**
 * Ensayo/comprobación de funcionalidad de las interfaces. Ejemplo de la UT2
 * aprovechando la clase anterior {@link Personaje}.
 * 
 * @see jcolonia.daw2023.teatrillo.gestión.Cotizable Cotizable
 * @see jcolonia.daw2023.teatrillo.gestión.Nominilla Nominilla
 * 
 * @version 261 (20231212)
 */
public class Guion {
	/** Lista de nombres de ejemplo. */
	public final static String[] LISTA_ORIGINAL = { "Ana",
			"Benja", "Carla", "Demetrio", "Estefanía" };

	/** Lista de personajes participantes */
	private Personaje[] créditos;

	/**
	 * Rellena la lista de personajes con nuevos elementos creados a partir de los
	 * nombres facilitados. Crea una lista con el tamaño de la lista de nombres y
	 * crea un personaje por cada nombre facilitado. No hace ningún control sobre
	 * la presencia de nombres nulos o vacíos.
	 * 
	 * @param nombres la lista de nombres para los personajes a crear
	 */
	public Guion(String[] nombres) {
		int númPersonajes;

		Personaje personajeNuevo;

		númPersonajes = 0;

		créditos = new Personaje[nombres.length];

		for (String nombre : nombres) {
			personajeNuevo = new Personaje(nombre);
			créditos[númPersonajes] = personajeNuevo;
			númPersonajes++;
		}

	}

	/** Realiza un diálogo entre los personajes de la lista para ir aumentando 
	 * los respectivos contadores de frases.
	 */
	public void simularConversación() {
		Personaje sujetoA, sujetoB;
		String mensaje;
		int posiciónA, posiciónB;

		for (posiciónA = 0; posiciónA < créditos.length; posiciónA++) {
			sujetoA = créditos[posiciónA];
			System.out.printf("  %s%n", sujetoA.saluda());

			for (posiciónB = 0; posiciónB < posiciónA; posiciónB++) {
				sujetoB = créditos[posiciónB];
				mensaje = sujetoB.saluda(sujetoA);
				System.out.printf("    %s%n", mensaje);
			}
		}
	}

	public static void main(String[] argumentos) {
		Guion obra;
		Nominilla nómina;

		String[] listaNombres;
		listaNombres = argumentos.length > 0 ? argumentos
				: LISTA_ORIGINAL;

		obra = new Guion(listaNombres);
		obra.simularConversación();

		System.out.println();
		nómina = new Nominilla(obra.créditos);
		System.out.println(nómina);

	}
}
