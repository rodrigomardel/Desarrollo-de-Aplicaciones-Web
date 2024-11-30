import java.io.Console;

/**
 * Ejemplo básico de entrada por consola de solo números.
 * 
 * @author <a href= "mailto:rodrigo.mardel@educa.jcyl.es">Rodrigo Martínez
 *         Delgado</a>
 * @version 1.0 (20240301)
 */
public class Consola {

	/**
	 * 
	 */
	public Consola() {
	
	}
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Console consola = System.console();
		if (consola == null) {
			System.err.println("No hay consola");
			System.exit(1);
		}
		String s;
		int entrada;
		int n = 0;
		boolean salir = false;
		do {
			try {
				s = consola.readLine();
				if (s.compareTo("F") == 0) {
					salir = true;
				} else {
					entrada = Integer.parseInt(s);
					n++;
					consola.printf("--> (%d) %d%n", n, entrada);
				}
			} catch (NumberFormatException e) {
				consola.printf("*** ¡El sistema solo admite números enteros!%n");
			}
		} while (!salir);
	}

}


