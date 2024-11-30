package jcolonia.daw2024.mvc;

import static java.lang.System.out;

import java.util.Scanner;

/**
 * Vista general para la interacción con el usuario.
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel@educa.jcyl.es&gt;
 * @version 1.0 (20240408)
 */
public class VistaGeneral {

	/** Nombre del menú. */
	private String nombre;
	/** Entrada estándar. */
	private Scanner scEntrada;

	/**
	 * Inicializa y asigna el nombre del menú, la lista de opciones y la entrada
	 * recibida.
	 * 
	 * @param nombre nombre deseado
	 * @param in     entrada de usuario
	 */
	public VistaGeneral(String nombre, Scanner in) {
		this.nombre = nombre;
		this.scEntrada = in;
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
	 * Consulta la entrada estándar
	 * @return valor correspondiente
	 */
	public Scanner getScEntrada() {
		return scEntrada;
	}

}
