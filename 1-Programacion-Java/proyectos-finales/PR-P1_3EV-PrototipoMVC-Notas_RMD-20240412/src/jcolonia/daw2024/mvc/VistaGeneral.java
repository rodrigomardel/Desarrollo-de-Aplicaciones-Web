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
	/** Texto para confirmación. */
	private static final String SI = "S";
	/** Texto para negación. */
	private static final String NO = "N";

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
	 * 
	 * @return valor correspondiente
	 */
	public Scanner getScEntrada() {
		return scEntrada;
	}

	/**
	 * Pregunta al usuario si desea continuar.
	 * 
	 * @return salir o continuar si el usuario lo desea
	 */
	public boolean pedirConfirmación() {
		boolean salir = false, respuesta = false;
		String textoIntroducido;

		do {
			out.println("¿Desea continuar? (S/N)");
			textoIntroducido = scEntrada.nextLine();
			if (SI.equals(textoIntroducido)) {
				respuesta = true;
				salir = true;
			} else if (NO.equals(textoIntroducido)) {
				respuesta = false;
				salir = true;
			} else {
				out.println("¡Solo es válido «S» o «N»!");
			}
		} while (!salir);
		return respuesta;
	}

}
