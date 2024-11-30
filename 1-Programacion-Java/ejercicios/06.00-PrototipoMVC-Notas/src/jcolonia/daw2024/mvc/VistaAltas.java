package jcolonia.daw2024.mvc;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Vista para la introducción de cadenas de texto.
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel@educa.jcyl.es&gt;
 * @version 1.1 (20240410)
 */
public class VistaAltas extends VistaGeneral {

	/** Nombre de la vista. */
	private String nombre;
	/** Texto para confirmación. */
	private static final String SI = "S";
	/** Texto para negación. */
	private static final String NO = "N";

	/**
	 * Inicializa y asigna el nombre del menú y la entrada recibida.
	 * 
	 * @param nombre  nombre deseado
	 * @param entrada entrada de usuario
	 */
	public VistaAltas(String nombre, Scanner entrada) {
		super(nombre, entrada);
		this.nombre = nombre;

	}

	/**
	 * Almacena las altas introducidas en la lista de cadenas de texto.
	 * 
	 * @return altas introducidas
	 */
	public ArrayList<String> introducirAlta() {
		ArrayList<String> notas;
		notas = new ArrayList<String>();
		boolean salir;
		Scanner in = getScEntrada();
		String textoEntrada;

		salir = false;

		do {
			textoEntrada = in.nextLine();
			out.println("¡Nota registrada correctamente!");
			notas.add(textoEntrada);
			if (pedirConfirmación() == false) {
				salir = true;
			}
		} while (!salir);
		return notas;
	}

	/**
	 * Pregunta al usuario si desea continuar.
	 * 
	 * @return salir o continuar si el usuario lo desea
	 */
	private boolean pedirConfirmación() {
		boolean salir = false, respuesta = false;
		String textoIntroducido;
		Scanner in = getScEntrada();

		do {
			System.out.println("¿Desea introducir más notas? (S/N)");
			textoIntroducido = in.nextLine();
			if (SI.equals(textoIntroducido)) {
				respuesta = true;
				salir = true;
			} else if (NO.equals(textoIntroducido)) {
				respuesta = false;
				salir = true;
			} else {
				System.out.println("¡Solo es válido «S» o «N»!");
			}
		} while (!salir);
		return respuesta;
	}

	/**
	 * Muestra el título asigando para el menú.
	 */
	public void mostrarTítulo() {
		out.println(nombre);
		for (int i = 0; i < nombre.length(); i++) {
			out.print("-");
		}
		out.println();
	}

}
