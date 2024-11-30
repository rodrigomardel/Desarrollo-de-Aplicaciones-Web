//package jcolonia.daw2023.sorteos;
//
///**
// * La classe EtoilesBombo représente un Bombo spécifique utilisé pour le tirage
// * des étoiles dans un jeu de loterie.
// */
//public class EtoilesBombo extends Bombo {
//    /**
//     * 
//     */
//    private static final int TOTAL_ETOILES = 12;
//
//    /**
//     * Constructeur de la classe EtoilesBombo.
//     */
//    public EtoilesBombo() {
//        super(createEtoilesLabels());
//    }
//
//    /**
//     * Crée les étiquettes des étoiles.
//     * 
//     * @return un tableau d'étiquettes pour les étoiles
//     */
//    private static String[] createEtoilesLabels() {
//        String[] labels = new String[TOTAL_ETOILES];
//        for (int i = 0; i < TOTAL_ETOILES; i++) {
//            labels[i] = "⭐" + (i + 1);
//        }
//        return labels;
//    }
//}

package jcolonia.daw2023.sorteos;

/**
 * La clase EstrellasBombo representa un Bombo específico utilizado para el
 * sorteo de las estrellas en un juego de lotería.
 */
public class EtoilesBombo extends Bombo {
	/**
	 * 
	 */
	private static final int TOTAL_ESTRELLAS = 12;

	/**
	 * Constructor de la clase EstrellasBombo.
	 * 
	 * @throws SorteoRTException excepción esperada
	 */
	public EtoilesBombo() throws SorteoRTException {
		super(crearEtiquetasEstrellas());
	}

	/**
	 * Crea las etiquetas de las estrellas.
	 * 
	 * @return un array de etiquetas para las estrellas
	 */
	private static String[] crearEtiquetasEstrellas() {
		String[] etiquetas = new String[TOTAL_ESTRELLAS];
		for (int i = 0; i < TOTAL_ESTRELLAS; i++) {
			etiquetas[i] = "⭐" + (i + 1);
		}
		return etiquetas;
	}
}
