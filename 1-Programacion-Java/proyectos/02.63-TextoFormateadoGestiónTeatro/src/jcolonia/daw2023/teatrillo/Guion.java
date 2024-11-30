package jcolonia.daw2023.teatrillo;

import jcolonia.daw2023.teatrillo.gestión.Nominilla;
import jcolonia.daw2023.teatrillo.gestión.Nominilla.TipoNominilla;

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
		nómina = Nominilla.ofNominilla(TipoNominilla.HTML, obra.créditos);
		// nómina = new NominillaTXT(obra.creditos);
		System.out.println(nómina);
		
	}	
		
		/**
		 * Analizar los argumentos introducibles por la línea de ordenes 
		 * para determinar el tipo de Nominilla deseado. En caso de no contener
		 * ninguna opción se muestra un texto de ayuda y la aplicación finaliza.
		 * En caso de recibir una opción no reconocida se muestra un mensaje de error
		 * y la aplicación aborta.
		 * 
		 * Admite como opciones validas:
		 * <ul>
		 * <li>TXT</li>
		 * <li>CSV</li>
		 * <li>HTML</li>
		 * </ul>
		 * 
		 * @param opciones la lista de opciones de ejecución
		 * @return la opción deseada
		 */
		
		private static TipoNominilla analizarArgumentos (String[] opciones) {
			
			TipoNominilla tipo;
			String mensaje;
		
			tipo = null;
	
			if(opciones.length==0) {
				mensaje = String.format("Introduzca la opción deseada.");
				System.err.println(mensaje);
				System.exit(1);
				
			}else if(opciones.length==1){
				tipo = TipoNominilla.TXT;
				
			}else if(opciones.length==2){
				tipo = TipoNominilla.CSV;
				
			}else if(opciones.length==3){
				tipo = TipoNominilla.HTML;
				
			}
				
			return tipo;
					
		}
}
