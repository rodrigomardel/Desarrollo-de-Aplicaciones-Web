package jcolonia.daw2023.sorteos;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Programa ejemplo de uso del {@link BomboGenérico} en el que se simula un
 * sorteo de la «Lotería Primitiva». En la lotería primitiva hay que acertar una
 * serie de seis números sin repetir entre 1 y 49. En este ejemplo no se aborda
 * la extracción del séptimo valor «complementario».
 * 
 * @author <a href= "mailto:dmartin.jcolonia@gmail.com">David H. Martín</a>
 * @version 3.0 (20240228)
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
		String línea;
		for (int j = 'a'; j <= 'z'; j++) {
			var combinación = new ArrayList<Integer>();
			var bombo = BomboGenérico.of(1, 49);

			System.out.printf("%c) ", j);
			for (int i = 0; i < 6; i++) {
				combinación.add(bombo.sacarBola());
			}

			combinación.sort(null);
			línea = combinación.stream().map((i) -> String.format("%02d", i)).collect(Collectors.joining(" - "));
			out.println(línea);
		}
	}
}
