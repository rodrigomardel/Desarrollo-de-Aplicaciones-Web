//package jcolonia.daw2023.sorteos;
//
///**
// * La classe Main contient la méthode principale qui démarre l'application.
// * Elle effectue le tirage des numéros principaux et des étoiles dans un jeu
// * de loterie, puis les affiche.
// */
//public class Main {
//    /**
//     * Méthode principale de l'application.
//     * 
//     * @param args les arguments de la ligne de commande (non utilisés)
//     */
//    public static void main(String[] args) {
//        // Création d'un bombo pour les numéros principaux
//        NumerosPrincipauxBombo bomboNumerosPrincipaux = new NumerosPrincipauxBombo();
//
//        // Création d'un bombo pour les étoiles
//        EtoilesBombo bomboEtoiles = new EtoilesBombo();
//
//        // Tirage des numéros principaux
//        String[] numerosPrincipaux = new String[5];
//        for (int i = 0; i < 5; i++) {
//            numerosPrincipaux[i] = bomboNumerosPrincipaux.sacarBola();
//        }
//        System.out.println("Numéros principaux tirés : " + String.join(", ", numerosPrincipaux));
//
//        // Tirage des étoiles
//        String[] etoiles = new String[2];
//        for (int i = 0; i < 2; i++) {
//            etoiles[i] = bomboEtoiles.sacarBola();
//        }
//        System.out.println("Étoiles tirées : " + String.join(", ", etoiles));
//    }
//}

package jcolonia.daw2023.sorteos;

/**
 * La clase Main contiene el método principal que inicia la aplicación. Realiza
 * el sorteo de los números principales y de las estrellas en un juego de
 * lotería, y luego los muestra.
 */
public class Main {
	/**
	 * Método principal de la aplicación.
	 * 
	 * @param args los argumentos de la línea de comandos (no utilizados)
	 */
	public static void main(String[] args) {

		try {
			// Creación de un bombo para los números principales
			NumerosPrincipauxBombo bomboNumerosPrincipales = new NumerosPrincipauxBombo();

			// Creación de un bombo para las estrellas
			EtoilesBombo bomboEtoiles = new EtoilesBombo();

			// Sorteo de los números principales
			String[] numerosPrincipales = new String[5];
			for (int i = 0; i < 5; i++) {
				numerosPrincipales[i] = bomboNumerosPrincipales.sacarBola();
			}
			System.out.println("Números principales sorteados: " + String.join(", ", numerosPrincipales));

			// Sorteo de las estrellas
			String[] estrellas = new String[2];
			for (int i = 0; i < 2; i++) {
				estrellas[i] = bomboEtoiles.sacarBola();
			}
			System.out.println("Estrellas sorteadas: " + String.join(", ", estrellas));

		} catch (SorteoRTException ex) {
			String mensaje = String.format(("Error inesperado al generar el sorteo: %s"), ex.getLocalizedMessage());

			System.err.println(mensaje);

			System.exit(27);
		}
	}
}
