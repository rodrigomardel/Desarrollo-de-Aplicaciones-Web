package jcolonia.daw2023.ut4;

/**
 * UT5: Segundo ejemplo sobre excepciones. <strong>Captura</strong> de una
 * excepción para mostrar un <strong>mensaje personalizado</strong> en consola.
 * 
 * @author <a href= "mailto:dmartin.jcolonia@gmail.com">David H. Martín</a>
 * @version 1.1 (20240215)
 */
public class EjemploExcepciónDivZero_0411 {

	/**
	 * Provoca, dentro de un bucle con divisiones enteras, un error al dividir por
	 * cero. Captura la excepción y muestra, antes de finalizar el programa,
	 * información de la operación en curso y del contenido de la propia excepción.
	 * 
	 * @see Throwable#getMessage()
	 * @see Throwable#getLocalizedMessage()
	 * 
	 * @param argumentos argumentos en línea de órdenes -no se usan-
	 */
	public static void main(String[] argumentos) {
		int i = 999;

		try {
			for (i = -10; i <= 10; i++) {
				System.out.printf("%d / %d = %d%n", 5, i, 5 / i);
			}
		} catch (ArithmeticException ex) {
			String mensaje;
			mensaje = String.format("Error con i=%d «%s»", i, ex.getLocalizedMessage());
			System.err.println(mensaje);
		} finally {
			System.out.println("--FIN--");
		}
	}
}
