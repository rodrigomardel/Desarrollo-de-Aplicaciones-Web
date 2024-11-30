package jcolonia.daw2024.mvc;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Control de introducción, listado, exportación e importación de notas.
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel@educa.jcyl.es&gt;
 * @version 2.0 (20240411)
 */
public class ControlNotas {

	/** Entrada estándar. */
	private Scanner entrada;
	/** Notas introducidas. */
	private ArrayList<String> notas;
	/** Opciones del menú. */
	public static final String[] OPCIONES_MENÚ_PRINCIPAL = { "Introducir", "Listar", "Exportar", "Importar", "Salir" };
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
	 * Importa el archivo de las notas introducidas de forma enumerada, volcando el
	 * resultado por pantalla.
	 */
	public void importarNota() {
		String nombreArchivo = NOMBRE_PREDETERMINADO;
		boolean salir = false;
		String línea;

		try {
			File refArchivo = new File(nombreArchivo);
			FileReader fr = new FileReader(refArchivo);
			BufferedReader archivo = new BufferedReader(fr);

			notas.removeAll(notas);
			do {
				línea = archivo.readLine();
				if (línea == null) {
					salir = true;
				} else {
					notas.add(línea);
				}
			} while (!salir);
			out.println("✓ Importación realizada");
			archivo.close();

		} catch (NoSuchFileException e) {
			System.err.printf("Ruta no encontrada: %s %n", e.getLocalizedMessage());
		} catch (IOException e) {
			System.err.printf("Error de lectura: %s %n", e.getLocalizedMessage());
		}
	}

	/**
	 * Exporta las notas introducidas a un archivo, advirtiendo al usuario que dicha
	 * acción puede sobrescribir notas exportadas anteriormente.
	 */
	public void exportarNota() {
		String nombreArchivo = NOMBRE_PREDETERMINADO;
		Path refArchivo = Path.of(nombreArchivo);

		try {
			if (notas.isEmpty()) {
				out.println("¡No hay ninguna nota!");
				buclePrincipal();
			} else if (pedirConfirmación() == true) {
				Files.deleteIfExists(refArchivo);
				Path archivo = Files.createFile(refArchivo);
				PrintWriter out = new PrintWriter(Files.newBufferedWriter(archivo));

				for (int i = 0; i < notas.size(); i++) {
					out.printf("%s %n", notas.get(i));
				}			
				out.close();
			}
			out.println("✓ Exportación realizada");
		} catch (NoSuchFileException e) {
			System.err.printf("Ruta no encontrada: %s %n", e.getLocalizedMessage());
		} catch (IOException e) {
			System.err.printf("Error de escritura: %s %n", e.getLocalizedMessage());
		}
	}

	/**
	 * Lista las notas introducidas, volcando el resultado por pantalla de forma
	 * enumerada.
	 */
	public void listarNota() {
		if (notas.isEmpty()) {
			out.println("¡No hay ninguna nota!");
			buclePrincipal();
		}
		out.println("-Notas introducidas-");
		for (int i = 0; i < notas.size(); i++) {
			out.printf("%d.- %s %n", i + 1, notas.get(i));
		}
	}

	/**
	 * Genera una vista de altas la cual nos permite introducir cadenas de texto.
	 */
	public void introducirNota() {
		VistaAltas altas;
		altas = new VistaAltas("Introduzca la nota deseada:", entrada);

		altas.mostrarTítulo();
		notas.addAll(altas.introducirAlta());
	}

	/**
	 * Muestra el menú principal con las opciones para la gestión de notas.
	 */
	public void buclePrincipal() {
		VistaMenú menú;
		int opción;

		menú = new VistaMenú("Gestión de notas", OPCIONES_MENÚ_PRINCIPAL, entrada);

		do {
			out.println();
			menú.mostrarTítulo();
			menú.mostrarMenú();
			opción = menú.pedirOpción();

			switch (opción) {
			case 1:
				introducirNota();
				break;
			case 2:
				listarNota();
				break;
			case 3:
				exportarNota();
				break;
			case 4:
				importarNota();
				break;
			}
		} while (opción != 5);
		out.println("Fin programa");
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
		Scanner in = entrada;

		do {
			System.out.println("¿Desea sobrescribir las notas exportadas anteriormente? (S/N)");
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
}
