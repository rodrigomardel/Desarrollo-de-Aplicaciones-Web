
public class EjemploExcepciónDivZero_0413 {

	public int dividir(int dividendo, int divisor) {
		int cociente;

		cociente = dividendo / divisor;

		return cociente;

	}

	public void ejecutar() {
		int i = 527;
		int división;
		for (i = -10; i <= 10; i++) {
			división = dividir(5, i);
			System.out.printf("%d / %d = %d%n", 5, i, división);
		}
		System.out.println("--FIN--");
	}

	public static void main(String[] args) {
		EjemploExcepciónDivZero_0413 programa;
		programa = new EjemploExcepciónDivZero_0413();

		programa.ejecutar();

	}
}
