package jcolonia.daw2023.teatrillo;

public class Guion {
	public final static String[] listaOriginal = { "Ana",
			"Benja", "Carla", "Demetrio", "Estefanía" };

	public static void main(String[] argumentos) {
		Personaje[] listaPersonajes;
		int númeroPersonajesContratados;

		Personaje personajeNuevo, personajeVeterano;
		String mensaje;

		String[] listaNombres;
		listaNombres = argumentos.length > 0 ? argumentos
				: listaOriginal;

		listaPersonajes = new Personaje[listaNombres.length
				+ 5];
		númeroPersonajesContratados = 0;

		// Contratación/creación de los pesonajes.
		for (String nombre : listaNombres) {
			personajeNuevo = new Personaje(nombre);
			listaPersonajes[númeroPersonajesContratados] = personajeNuevo;
			System.out.printf("  %s%n",
					personajeNuevo.saluda());

			for (int posición = 0; posición < númeroPersonajesContratados; posición++) {
				personajeVeterano = listaPersonajes[posición];
				mensaje = personajeVeterano
						.saluda(personajeNuevo);
				System.out.printf("    %s%n", mensaje);
			}
			númeroPersonajesContratados++;
		}

		// Despedida de los personajes
		while (númeroPersonajesContratados > 0) {
			númeroPersonajesContratados--;
			System.out.printf("  %s%n",
					listaPersonajes[númeroPersonajesContratados]
							.despide());
		}

	}
}
