
package jcolonia.daw2023.teatrillo;

public class Teatrillo {
	public final static String[] listaNombres = {
			"Ana", "Benja", "Carla",
			"Demetrio", "Estefanía"
			};

	public static void main(String[] args) {
		Actor[] listaActores;
		int númeroActoresContratados;

		Actor actorNuevo;

		listaActores = new Actor[listaNombres.length + 5];
		númeroActoresContratados = 0;

		// Contratación/creación de los actores.
		for (String nombre : listaNombres) {
			actorNuevo = new Actor(nombre);
			listaActores[númeroActoresContratados] = actorNuevo;
			númeroActoresContratados++;
		}

		// Listado de actores contratados
		for (int i = 0; i < númeroActoresContratados; i++) {
			// System.out.println(listaActores[i]);
			System.out.println(listaActores[i].toString());
		}

	}
}
