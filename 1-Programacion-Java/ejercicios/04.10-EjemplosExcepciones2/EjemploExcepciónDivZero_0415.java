package jcolonia.daw2023.ut4;

/**
 * UT5: Sexto ejemplo final sobre excepciones. La división por cero se controla
 * en el método correspondiente, lanzando una excepción personalizada que es
 * <strong>capturada</strong> en uno de los métodos intermedios permitiendo la <strong>continuación</strong> del
 * programa.
 * 
 * @author <a href= "mailto:dmartin.jcolonia@gmail.com">David H. Martín</a>
 * @version 1.5 (20240215)
 */
public class EjemploExcepciónDivZero_0415 {

	/**
	 * Divide dos números enteros. Controla que el divisor no sea cero para
	 * anticipar el error.
	 * 
	 * @param dividendo el valor correspondiente
	 * @param divisor   el valor correspondiente
	 * @return el cociente
	 * @throws DivisiónCeroException si el divisor es cero
	 */
	public int dividir(int dividendo, int divisor) throws DivisiónCeroException {
		int cociente;

		// no podemos dividir por cero → provocamos excepción
		if (divisor == 0) {
			throw new DivisiónCeroException("No se permite dividir por cero");
		}

		cociente = dividendo / divisor;

		return cociente;
	}

	/**
	 * Provoca, dentro de un bucle con divisiones enteras, un error al
	 * {@link #dividir(int, int) dividir} por cero. En ese caso atiende la excepción
	 * recibida, y continua la ejecución para el resto de valores del bucle.
	 * 
	 */
	public void ejecutar() {
		int i = 999;
		int división;

		for (i = -10; i <= 10; i++) {
			try {
				división = dividir(5, i);
				System.out.printf("%d / %d = %d%n", 5, i, división);
			} catch (DivisiónCeroException ex) {
				String mensaje;
				mensaje = String.format("Error con i=%d «%s»", i, ex.getLocalizedMessage());
				System.err.println(mensaje);
			}
		}

		System.out.println("--FIN--");
	}

	/**
	 * Activa la {@link #ejecutar() ejecución} del programa.
	 * 
	 * @param argumentos argumentos en línea de órdenes -no se usan-
	 */
	public static void main(String[] argumentos) {
		EjemploExcepciónDivZero_0415 programa;
		programa = new EjemploExcepciónDivZero_0415();

		programa.ejecutar();
	}

}
