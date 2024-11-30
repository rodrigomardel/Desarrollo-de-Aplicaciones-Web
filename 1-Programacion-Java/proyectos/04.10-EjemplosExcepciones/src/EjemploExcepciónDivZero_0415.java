
public class EjemploExcepciónDivZero_0415 {

	public int dividir(int dividendo, int divisor) throws EjemploException {
		int cociente;

		// no podemos dividir por cero → provocamos excepcion
		if (divisor == 0) {
			throw new EjemploException("No se permite dividir por cero");
		}
		cociente = dividendo / divisor;

		return cociente;

	}

	public void ejecutar() {
		int i = 527;
		int división;
		for (i = -10; i <= 10; i++) {
			try {
				división = dividir(5, i);
				System.out.printf("%d / %d = %d%n", 5, i, división);

			} catch (EjemploException ex) {
				String mensaje;
				mensaje = String.format("Error con i=%d «%s»", i, ex.getLocalizedMessage());
				System.err.println(mensaje);
			}
		}
		System.out.println("--FIN--");
	}

	public static void main(String[] args) {
		EjemploExcepciónDivZero_0415 programa;
		programa = new EjemploExcepciónDivZero_0415();

		programa.ejecutar();

	}
}
