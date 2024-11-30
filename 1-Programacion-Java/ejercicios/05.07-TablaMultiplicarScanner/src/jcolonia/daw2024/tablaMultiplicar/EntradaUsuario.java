package jcolonia.daw2024.tablaMultiplicar;

import java.util.Scanner;

/**
 * Ejemplo utilizando la clase Scanner, interaccionando con el usuario.
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel@educa.jcyl.es&gt;
 * @version 1.0 (20240304)
 */
public class EntradaUsuario {

	private static final String SI = "S";
	private static final String NO = "N";

	/**
	 * 
	 */
	public EntradaUsuario() {
		super();
	}

	/**
	 * Pide al usuario ún numero, admitiendo como valor solo número enteros.
	 * 
	 * @param sc entrada del usuario
	 * @return multiplicando deseado
	 */
	private static int pedirEntero(Scanner sc) {
		int multiplicando = 1; // Valor provisional, siempre se reescribe para salir
		boolean salir = false;
		String s;
		do {
			try {
				System.out.println("Introduzca multiplicando deseado:");
				s = sc.nextLine();
				multiplicando = Integer.parseInt(s);
				salir = true;
			} catch (NumberFormatException e) {
				System.out.printf("*** ¡El sistema solo admite números enteros!%n");
			}
		} while (!salir);
		return multiplicando;
	}

	/**
	 * Pregunta al usuario si desea continuar.
	 * 
	 * @param sc entrada del usuario
	 * @return salir si el usuario lo desea
	 */
	private static boolean pedirConfirmación(Scanner sc) {
		boolean salir = false, respuesta = false;
		String textoIntroducido;

		do {
			System.out.println("¿Desea continuar? S/N");
			textoIntroducido = sc.nextLine();
			if (SI.equals(textoIntroducido)) {
				respuesta = false;
				salir = true;
			} else if (NO.equals(textoIntroducido)) {
				respuesta = true;
				salir = true;
			} else {
				System.out.println("Solo es válido «S» o «N»");
			}
		} while (!salir);
		return respuesta;

	}

	/**
	 * Genera un dialogo con el usuario para la creación de una tabla de
	 * multiplicar.
	 * 
	 * @param args argumentos dados al ejecutar –no se usan–
	 */
	public static void main(String[] args) {
		TablaMultiplicar tabla;
		Scanner sc = new Scanner(System.in);
		int multiplicando = 0;
		boolean salir = false;

		System.out.println("• Generador de tablas de multiplicar •");

		do {
			multiplicando = pedirEntero(sc);

			tabla = new TablaMultiplicar(multiplicando);
			tabla.generarLíneas();
			System.out.println(tabla);

			salir = pedirConfirmación(sc);

		} while (!salir);

		sc.close();
		System.out.println("Fin programa");
	}

}
