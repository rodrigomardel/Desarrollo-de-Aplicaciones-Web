

/**
 * UT5 - Primer ejemplo sobre excepciones. Genera una excepción aritmética que
 * no es tratada.
 */
public class EjemploExcepciónDivZero_0410 {
	
	/**
	 * Provoca, dentro de un bucle con divisiones enteras, un error al dividir por
	 * cero. Captura la excepción y muestra
	 * 
	 * @param args argumentos en línea de órdenes -no se usan-
	 */
	public static void main(String[] args) {
		for (int i = -10; i <= 10; i++) {
			System.out.printf("%d / %d = %d%n", 5, i, 5 / i);
		}
	}

}
