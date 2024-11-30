package jcolonia.daw2023.ut4;

/**
 * UT5: Quinto ejemplo sobre excepciones. Observación de una excepción «tratada»
 * (<em>checked</em>, {@link DivisiónCeroException}…) en una llamada a través de
 * varios métodos encadenados. Los métodos implicados declaran
 * <strong>declaran</strong> la excepción correspondiente, la <strong>
 * propagan</strong>, pero <strong>ninguno de ellos la captura</strong> y el
 * usuario recibe en consola el volcado de la excepción.
 * 
 * @author <a href= "mailto:dmartin.jcolonia@gmail.com">David H. Martín</a>
 * @version 1.4 (20240215)
 */
public class EjemploExcepciónDivZero_0414 {

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
	 * {@link #dividir(int, int) dividir} por cero. Prevé la posibilidad de recibir
	 * una excepción –cuando intente la división por cero– pero se limita a
	 * propagarla.
	 * 
	 * @throws DivisiónCeroException siempre
	 */
	public void ejecutar() throws DivisiónCeroException {
		int i = 999;
		int división;

		for (i = -10; i <= 10; i++) {
			división = dividir(5, i);
			System.out.printf("%d / %d = %d%n", 5, i, división);
		}

		System.out.println("--FIN--");
	}

	/**
	 * Activa la {@link #ejecutar() ejecución} del programa. Prevé la posibilidad de
	 * recibir una excepción pero se limita a propagarla. El programa aborta en ese
	 * momento, y se vuelca a consola el contenido de la excepción: texto + traza.
	 * 
	 * @param argumentos argumentos en línea de órdenes -no se usan-
	 * @throws DivisiónCeroException siempre
	 */
	public static void main(String[] argumentos) throws DivisiónCeroException {
		EjemploExcepciónDivZero_0414 programa;
		programa = new EjemploExcepciónDivZero_0414();

		programa.ejecutar();
	}
}
