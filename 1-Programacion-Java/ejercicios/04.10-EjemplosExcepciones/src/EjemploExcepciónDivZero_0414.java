
public class EjemploExcepciónDivZero_0414 {

	public int dividir(int dividendo, int divisor) throws EjemploException {
		int cociente;
		
		// no podemos dividir por cero → provocamos excepcion
		if (divisor == 0) {
			throw new EjemploException("No se permite dividir por cero");
		}
		cociente = dividendo / divisor;

		return cociente;

	}

	public void ejecutar() throws EjemploException {
		int i = 527;
		int división;
		for (i = -10; i <= 10; i++) {
			división = dividir(5, i);
			System.out.printf("%d / %d = %d%n", 5, i, división);
		}
		System.out.println("--FIN--");
	}

	public static void main(String[] args) throws EjemploException {
		EjemploExcepciónDivZero_0414 programa;
		programa = new EjemploExcepciónDivZero_0414();

		programa.ejecutar();

	}
}
