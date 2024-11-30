package jcolonia.daw2023.ut4;

/**
 * UT5: Cuarto ejemplo sobre excepciones. Observación de una excepción «no
 * tratada» (<em>unchecked</em>, {@link RuntimeException}…) llamada a través de
 * <strong>varios métodos</strong> encadenados. La excepción se <strong>propaga
 * automáticamente</strong> y al final el programa <strong>aborta</strong> de
 * manera poco ortodoxa.
 * 
 * @author David H. Martín <dmartin.jcolonia@gmail.com>
 * @version 1.3 (20240215)
 */
public class EjemploExcepciónDivZero_0413 {

	/**
	 * Divide dos números enteros.
	 * 
	 * @param dividendo el valor correspondiente
	 * @param divisor   el valor correspondiente
	 * @return el cociente
	 */
	public int dividir(int dividendo, int divisor) {
		int cociente;

		cociente = dividendo / divisor;

		return cociente;
	}

	/**
	 * Provoca, dentro de un bucle con divisiones enteras, un error al
	 * {@link #dividir(int, int) dividir} por cero. Siendo una
	 * {@link RuntimeException} no se exige ningún tratamiento. El programa aborta
	 * al tratar de hacer la división, y se vuelca a consola el contenido de la
	 * excepción: texto + traza.
	 */
	public void ejecutar() {
		int i = 999;
		int división;

		for (i = -10; i <= 10; i++) {

			división = dividir(5, i);
			System.out.printf("%d / %d = %d%n", 5, i, división);

		}

		System.out.println("--FIN--");
	}

	/**
	 * Activa la {@link #ejecutar() ejecución} del programa.
	 * 
	 * @param argumentos argumentos en línea de órdenes -no se usan-
	 */
	public static void main(String[] argumentos) {
		EjemploExcepciónDivZero_0413 programa;
		programa = new EjemploExcepciónDivZero_0413();

		programa.ejecutar();
	}
}
