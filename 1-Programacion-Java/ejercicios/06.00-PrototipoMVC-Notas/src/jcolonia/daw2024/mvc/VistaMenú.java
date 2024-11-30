package jcolonia.daw2024.mvc;

import static java.lang.System.out;

import java.util.Scanner;

/**
 * Vista de menú para la interacción con el usuario.
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel@educa.jcyl.es&gt;
 * @version 1.0 (20240408)
 */
public class VistaMenú extends VistaGeneral {

	/** Opciones almacenadas. */
	private String[] listaOpciones;
	/** Opciones numéricas del menú. */
	private int opción;
	/** Nombre del menú. */
	private String nombre;

	/**
	 * Inicializa y asigna el nombre del menú, la lista de opciones y la entrada
	 * recibida.
	 * 
	 * @param nombre        nombre deseado
	 * @param listaOpciones lista de opciones recibida
	 * @param entrada       entrada de usuario
	 */
	public VistaMenú(String nombre, String[] listaOpciones, Scanner entrada) {
		super(nombre, entrada);
		this.listaOpciones = listaOpciones;
		this.nombre = nombre;
	}

	/**
	 * Pide al usuario ún numero, admitiendo como valor solo número enteros.
	 * 
	 * @return la opción seleccionada
	 */
	public int pedirOpción() {
		boolean salir;
		String textoEntrada;
		Scanner in = getScEntrada();

		salir = false; // Dar vueltas hasta que pase algo...

		do {
			try {
				System.out.println("Seleccione la opción deseada:");
				textoEntrada = in.nextLine();
				opción = Integer.parseInt(textoEntrada);

				if (opción <= 0 || opción > listaOpciones.length) {// Opción no válida
					out.printf("Opción no válida%n");
				} else {// Opción válida, ¡ya podemos salir!
					salir = true;
				}

			} catch (NumberFormatException e) {
				out.printf("*** ¡El sistema solo admite números enteros!%n");
			}
		} while (!salir);
		return opción;
	}

	/**
	 * Muestra el título asigando para el menú.
	 */
	public void mostrarTítulo() {
		out.println(nombre);
		for (int i = 0; i < nombre.length(); i++) {
			out.print("=");
		}
		out.println();
	}

	/**
	 * Muestra las opciones con su enumeración correspondiente.
	 */
	public void mostrarMenú() {
		for (int i = 0; i < listaOpciones.length; i++) {
			out.printf("%d.- %s %n", i + 1, listaOpciones[i]);
		}
	}
}
