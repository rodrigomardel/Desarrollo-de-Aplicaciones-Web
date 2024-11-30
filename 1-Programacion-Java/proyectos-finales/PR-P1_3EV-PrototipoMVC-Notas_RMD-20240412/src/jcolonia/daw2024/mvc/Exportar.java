package jcolonia.daw2024.mvc;

import static java.lang.System.out;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Exportación de un listado de cadenas de texto a un archivo en el directorio
 * raíz del proyecto.
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel@educa.jcyl.es&gt;
 * @version 2.0 (20240412)
 */
public class Exportar {

	/** Entrada estándar. */
	private Scanner entrada;
	/** Ruta completa del archivo */
	private static final String NOMBRE_PREDETERMINADO = "notas.txt";
	/** Texto para confirmación. */
	private static final String SI = "S";
	/** Texto para negación. */
	private static final String NO = "N";

	/**
	 * Inicializa la entrada estándar.
	 */
	public Exportar() {
		entrada = new Scanner(System.in);
	}

	/**
	 * Exporta las notas introducidas a un archivo, advirtiendo al usuario que dicha
	 * acción puede sobrescribir notas exportadas anteriormente.
	 * 
	 * @param notas lista de cadenas de texto a exportar
	 */
	public void exportarArchivo(ArrayList<String> notas) {
		String nombreArchivo = NOMBRE_PREDETERMINADO;
		Path refArchivo = Path.of(nombreArchivo);

		try {
			if (notas.isEmpty()) {
				out.println("¡No hay ninguna nota para exportar!");
			} else if (pedirConfirmación() == true) {
				Files.deleteIfExists(refArchivo);
				Path archivo = Files.createFile(refArchivo);

				try (PrintWriter out = new PrintWriter(Files.newBufferedWriter(archivo));) {
					for (int i = 0; i < notas.size(); i++) {
						out.printf("%s %n", notas.get(i));
					}
				}
				out.println("✓ Exportación realizada");
			} else {
				out.println("× Exportación NO realizada");
			}
		} catch (NoSuchFileException e) {
			System.err.printf("Ruta no encontrada: %s %n", e.getLocalizedMessage());
		} catch (IOException e) {
			System.err.printf("Error de escritura: %s %n", e.getLocalizedMessage());
		}
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
