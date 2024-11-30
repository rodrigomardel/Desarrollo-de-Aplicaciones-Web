package jcolonia.daw2024.mvc;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Control de introducción, listado, borrado, exportación e importación de
 * cadenas de texto.
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel@educa.jcyl.es&gt;
 * @version 2.3 (20240412)
 */
public class ControlNotas {

	/** Entrada estándar. */
	private Scanner entrada;
	/** Notas introducidas. */
	private ArrayList<String> notas;
	/** Opciones del menú. */
	public static final String[] OPCIONES_MENÚ_PRINCIPAL = { "Introducir notas", "Listar notas", "Exportar notas",
			"Importar notas", "Borrar notas", "Salir Programa" };
	/** Ruta completa del archivo */
	private static final String NOMBRE_PREDETERMINADO = "notas.txt";
	/** Texto para confirmación. */
	private static final String SI = "S";
	/** Texto para negación. */
	private static final String NO = "N";

	/**
	 * Inicializa la lista y asigna la entrada a la entrada estándar del control.
	 * 
	 * @param entrada entrada deseada
	 */
	public ControlNotas(Scanner entrada) {
		this.entrada = entrada;
		notas = new ArrayList<String>();
	}

	/**
	 * Importa el archivo de las notas añadiendolas al listado.
	 */
	public void importarNotas() {
		Importar importación = new Importar();

		out.println("** Perderá los registros no exportados, ¿Desea continuar?");
		if (pedirConfirmación() == true) {
			notas.clear();
			importación.importarArchivo(NOMBRE_PREDETERMINADO, notas);
		} else {
			out.println("✕ Importación NO realizada");
		}
	}

	/**
	 * Exporta las notas introducidas a un archivo, advirtiendo al usuario que dicha
	 * acción puede sobrescribir notas exportadas anteriormente.
	 */
	public void exportarNotas() {
		Exportar exportación = new Exportar();
		exportación.exportarArchivo(notas);
	}

	/**
	 * Lista las notas introducidas, volcando el resultado por pantalla de forma
	 * enumerada.
	 */
	public void listarNotas() {
		if (notas.isEmpty()) {
			out.println("¡No hay ninguna nota para listar!");
		} else {
			out.println("-Notas introducidas-");
			for (int i = 0; i < notas.size(); i++) {
				out.printf("%d.- %s %n", i + 1, notas.get(i));
			}
		}
	}

	/**
	 * Genera una vista de altas la cual nos permite introducir cadenas de texto.
	 */
	public void introducirNotas() {
		VistaAltas altas;
		altas = new VistaAltas("Introduzca la nota deseada:", entrada);

		altas.mostrarTítulo();
		notas.addAll(altas.introducirAlta());
	}

	/**
	 * Borra todas la notas introducidas, pidiendo confirmación al usuario.
	 */
	public void borrarNotas() {
		if (notas.isEmpty()) {
			out.println("¡No hay ninguna nota para borrar!");
		} else {
			if (pedirConfirmación() == true) {
				notas.clear();
				out.println("✓ Todas las notas han sido eliminadas");
			} else {
				out.println("No ha habido ninguna modificación");
			}
		}
	}

	/**
	 * Muestra el menú principal con las opciones para la gestión de notas.
	 */
	public void buclePrincipal() {
		VistaMenú menú;
		int opción;

		menú = new VistaMenú("~ Gestión de notas ~", OPCIONES_MENÚ_PRINCIPAL, entrada);

		do {
			out.println();
			menú.mostrarTítulo();
			menú.mostrarMenú();
			opción = menú.pedirOpción();

			switch (opción) {
			case 1:
				introducirNotas();
				break;
			case 2:
				listarNotas();
				break;
			case 3:
				exportarNotas();
				break;
			case 4:
				importarNotas();
				break;
			case 5:
				borrarNotas();
				break;
			}
		} while (opción != 6);
		out.println("* Fin programa *");
	}

	/**
	 * Genera un control en forma de vista, con un menú para la gestión de notas.
	 * 
	 * @param argumentos argumentos dados al ejecutar –no se usan–
	 */
	public static void main(String[] argumentos) {
		ControlNotas programa;
		Scanner entrada;

		entrada = new Scanner(System.in);

		programa = new ControlNotas(entrada);
		programa.buclePrincipal();
		entrada.close();
	}

	/**
	 * Pregunta al usuario si desea continuar.
	 * 
	 * @return salir o continuar si el usuario lo desea
	 */
	private boolean pedirConfirmación() {
		boolean salir = false, respuesta = false;
		String textoIntroducido;

		do {
			out.println("¿Desea continuar? (S/N)");
			textoIntroducido = entrada.nextLine();
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
