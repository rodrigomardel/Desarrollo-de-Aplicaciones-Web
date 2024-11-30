package jcolonia.daw2023.g4d;

import static java.lang.System.out;

import java.util.Random;

/**
 * Genera un conjunto en forma de («<em>array</em>») de doce elementos
 * «{@link Grupo4DMejorado}» con números aleatorios calculando la suma, media,
 * máximo y mínimo de los mismos. <div>
 * 
 * Ejemplo:
 * 
 * <pre>
 *
 *	( 5,62, -9,69,  3,84,  8,95)     ◦ Suma: 8,72      ◦ Media: 2,18      ◦ Máximo: 8,95      ◦ Mínimo: -9,69    
 *	( 5,05, -9,34, -8,20, -5,14)     ◦ Suma: -17,63    ◦ Media: -4,41     ◦ Máximo: 5,05      ◦ Mínimo: -9,34    
 *	(-1,03, -9,06, -7,05, -3,72)     ◦ Suma: -20,86    ◦ Media: -5,22     ◦ Máximo: -1,03     ◦ Mínimo: -9,06    
 *	(-8,76,  6,85,  6,37,  7,38)     ◦ Suma: 11,83     ◦ Media: 2,96      ◦ Máximo: 7,38      ◦ Mínimo: -8,76    
 *	(-3,21, -4,13, -6,20, -4,87)     ◦ Suma: -18,41    ◦ Media: -4,60     ◦ Máximo: -3,21     ◦ Mínimo: -6,20    
 *	(-9,85,  4,12, -3,13,  0,86)     ◦ Suma: -8,01     ◦ Media: -2,00     ◦ Máximo: 4,12      ◦ Mínimo: -9,85    
 *	( 9,72,  9,89,  3,34,  6,51)     ◦ Suma: 29,46     ◦ Media: 7,36      ◦ Máximo: 9,89      ◦ Mínimo: 3,34     
 *	( 6,57,  2,75,  9,28,  2,06)     ◦ Suma: 20,66     ◦ Media: 5,16      ◦ Máximo: 9,28      ◦ Mínimo: 2,06     
 *	(-8,49,  6,96,  9,41, -7,21)     ◦ Suma: 0,68      ◦ Media: 0,17      ◦ Máximo: 9,41      ◦ Mínimo: -8,49    
 *	( 5,41, -1,43,  9,48,  8,82)     ◦ Suma: 22,28     ◦ Media: 5,57      ◦ Máximo: 9,48      ◦ Mínimo: -1,43    
 *	(-5,93, -3,60, -8,86,  3,03)     ◦ Suma: -15,36    ◦ Media: -3,84     ◦ Máximo: 3,03      ◦ Mínimo: -8,86    
 *	(-8,51,  9,23, -7,50,  8,00)     ◦ Suma: 1,22      ◦ Media: 0,31      ◦ Máximo: 9,23      ◦ Mínimo: -8,51
 * 
 * </pre>
 * 
 * </div>
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel@educa.jcyl.es&gt;
 * @version 1.0 (20240228)
 */
public class Ensayo4DConjunto {

	/**
	 * Genera una docena de grupos de 4 números decimales aleatorios, guardandolos
	 * en un conjunto, para posteriormente calcular su suma, media, máximo y mínimo.
	 * 
	 * @param args argumentos deseados
	 */

	public static void main(String[] args) {
		Random rnd;
		Conjunto4D<Grupo4DMejorado> conjunto;
		Grupo4DMejorado grupo;
		double a, b, c, d;
		int capacidadConjunto;

		capacidadConjunto = 12;

		rnd = new Random();

		try {
			conjunto = new Conjunto4D<Grupo4DMejorado>(capacidadConjunto);
			// Rellenamos el conjunto
			for (int i = 0; i < capacidadConjunto; i++) {
				a = rnd.nextDouble(-10., +10.);
				b = rnd.nextDouble(-10., +10.);
				c = rnd.nextDouble(-10., +10.);
				d = rnd.nextDouble(-10., +10.);
				grupo = new Grupo4DMejorado(a, b, c, d);
				conjunto.añadirElemento(grupo);
			}
			// Imprimimos los originales
			out.println("Originales:");
			for (int i = 0; i < conjunto.getNúmElementos(); i++) {

				grupo = conjunto.consultarElemento(i);

				out.printf("%s     ◦ Suma: %-8.2f  ◦ Media: %-8.2f  ◦ Máximo: %-8.2f  ◦ Mínimo: %-8.2f %n", grupo,
						grupo.suma(), grupo.media(), grupo.máximo(), grupo.mínimo());
			}
			// Ordenamos e imprimimos los grupos ordenados
			conjunto.ordenar();
			out.println();
			out.println("Grupos ordenados por la media:");
			for (int i = 0; i < conjunto.getNúmElementos(); i++) {

				grupo = conjunto.consultarElemento(i);

				out.printf("%s     ◦ Suma: %-8.2f  ◦ Media: %-8.2f  ◦ Máximo: %-8.2f  ◦ Mínimo: %-8.2f %n", grupo,
						grupo.suma(), grupo.media(), grupo.máximo(), grupo.mínimo());
			}

		} catch (Grupo4DException ex) {
			String mensaje = String.format(("Error insperado al generar la lista: %s"), ex.getLocalizedMessage());
			System.err.println(mensaje);
			System.exit(27);
		}

	}
}
