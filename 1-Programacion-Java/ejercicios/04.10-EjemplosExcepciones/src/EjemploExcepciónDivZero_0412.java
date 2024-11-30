
public class EjemploExcepciónDivZero_0412 {

	public static void main(String[] args) {
		int i = 527;
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
