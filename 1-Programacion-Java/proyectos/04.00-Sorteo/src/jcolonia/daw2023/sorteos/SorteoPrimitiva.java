package jcolonia.daw2023.sorteos;

import java.util.Arrays;

/**
 * Programa ejemplo de uso del {@link Bombo} en el que se simula un sorteo de la
 * «Lotería Primitiva». En la lotería primitiva hay que acertar una serie de
 * seis números sin repetir entre 1 y 49. En este ejemplo no se aborda la
 * extracción del séptimo valor «complementario».
 * 
 * @author <a href= "mailto:dmartin.jcolonia@gmail.com">David H. Martín</a>
 * @version 20230118000
 *
 */
public class SorteoPrimitiva {
	/**
	 * Elige al azar varias combinaciones de seis números enteros distintos entre 1
	 * y 49. Las combinaciones se muestran etiquetadas desde la «a» hasta la «z».
	 * Los valores de cada combinación se muestran ordenados de menor a mayor.
	 * 
	 * @param args argumentos dados al ejecutar –no se usan–
	 */
	public static void main(String[] args) {
		Bombo bombo;
		int[] combinación;

		try {
			for (int j = 'a'; j <= 'z'; j++) {
				combinación = new int[6];
				bombo = new Bombo(1, 49);

				System.out.printf("%c) ", j);
				for (int i = 0; i < combinación.length; i++) {
					combinación[i] = Integer.parseInt(bombo.sacarBola());
				}

				Arrays.sort(combinación);
				for (int i = 0; i < 6; i++) {
					if (i > 0) {
						System.out.print(" - ");
					}
					System.out.printf("%02d", combinación[i]);
				}
				System.out.println();
			}

		} catch (SorteoRTException ex) {
			String mensaje = String.format(("Error inesperado al generar el sorteo: %s"), ex.getLocalizedMessage());

			System.err.println(mensaje);

			System.exit(27);
		}
	}
}
