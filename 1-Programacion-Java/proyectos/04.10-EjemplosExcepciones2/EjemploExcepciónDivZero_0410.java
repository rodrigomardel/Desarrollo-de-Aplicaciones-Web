package jcolonia.daw2023.ut4;

/**
 * UT5: Primer ejemplo sobre excepciones. <strong>Observación de una
 * excepción</strong> «no tratada» (<em>unchecked</em>,
 * {@link RuntimeException}…). El programa <strong>aborta</strong> de manera
 * poco ortodoxa.
 * 
 * @author <a href= "mailto:dmartin.jcolonia@gmail.com">David H. Martín</a>
 * @version 1.0 (20240215)
 */
public class EjemploExcepciónDivZero_0410 {

	/**
	 * Provoca, dentro de un bucle con divisiones enteras, un error al dividir por
	 * cero. Siendo una {@link RuntimeException} no se exige ningún tratamiento. El
	 * programa aborta al tratar de hacer la división, y se vuelca a consola el
	 * contenido de la excepción: texto + traza.
	 * 
	 * @param argumentos argumentos en línea de órdenes -no se usan-
	 */
	public static void main(String[] argumentos) {
		for (int i = -10; i <= 10; i++) {
			System.out.printf("%d / %d = %d%n", 5, i, 5 / i);
		}

		System.out.println("--FIN--");
	}
}
