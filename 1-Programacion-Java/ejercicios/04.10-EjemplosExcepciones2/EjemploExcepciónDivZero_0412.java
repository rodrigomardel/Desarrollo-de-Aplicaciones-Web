package jcolonia.daw2023.ut4;

/**
 * UT5: Tercer ejemplo sobre excepciones. <strong>Captura</strong> una excepción
 * pero, en vez de abortar, permite <strong>completar la ejecución</strong>.
 * 
 * @author <a href= "mailto:dmartin.jcolonia@gmail.com">David H. Martín</a>
 * @version 1.2 (20240215)
 */
public class EjemploExcepciónDivZero_0412 {

	/**
	 * Provoca, dentro de un bucle con divisiones enteras, un error al dividir por
	 * cero. Dentro del bucle, captura la excepción y muestra, antes de continuar el
	 * programa, información de la operación en curso y del contenido de la propia
	 * excepción.
	 * 
	 * @param argumentos argumentos en línea de órdenes -no se usan-
	 */
	public static void main(String[] argumentos) {
		int i = 999;

		for (i = -10; i <= 10; i++) {
			try {
				System.out.printf("%d / %d = %d%n", 5, i, 5 / i);
			} catch (ArithmeticException ex) {
				String mensaje;
				mensaje = String.format("Error con i=%d «%s»", i, ex.getLocalizedMessage());
				System.err.println(mensaje);
			}
		}

		System.out.println("--FIN--");
	}

}
