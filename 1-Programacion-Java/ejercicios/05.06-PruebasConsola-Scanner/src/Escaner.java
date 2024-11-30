import java.util.Scanner;

/**
 * Ejemplo básico de entrada por escaner, solo números.
 * 
 * @author <a href= "mailto:rodrigo.mardel@educa.jcyl.es">Rodrigo Martínez
 *         Delgado</a>
 * @version 1.0 (20240301)
 */
public class Escaner {

	/**
	 * 
	 */
	public Escaner() {
		super();
	}

	/**
	 * @param args argumentos dados al ejecutar –no se usan–
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s;
		int entrada;
		int n = 0;
		boolean salir = false;
		do {
			try {
				s = sc.nextLine();
				if (s.compareTo("F") == 0) {
					salir = true;
				} else {
					entrada = Integer.parseInt(s);
					n++;
					System.out.printf("--> (%d) %d%n", n, entrada);
				}
			} catch (NumberFormatException e) {
				System.out.printf("*** ¡El sistema solo admite números enteros!%n");
			}
		} while (!salir);
		sc.close();

	}

}
