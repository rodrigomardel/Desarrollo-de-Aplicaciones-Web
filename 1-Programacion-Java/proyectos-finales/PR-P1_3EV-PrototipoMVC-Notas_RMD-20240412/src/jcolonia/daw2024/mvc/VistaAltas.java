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
