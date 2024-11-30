package jcolonia.daw2024.mvc;

import java.util.ArrayList;
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

/**
 * Importación de un archivo al listado principal de las cadenas de texto
 * introducidas.
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel@educa.jcyl.es&gt;
 * @version 3.1 (20240412)
 */
public class Importar {

	/**
	 * Inicializa una nueva instancia, no inicializa atributos ni recibe parámetros.
	 * Se utiliza para crear un objeto básico sin estado inicial específico.
	 */
	public Importar() {
	}

	/**
	 * Vacía el listado de cadenas de texto actualmente registrado pidiendo
	 * confirmación para importar en el las cadenas de texto del archivo a importar.
	 * 
	 * @param archivoImportar referencia de archivo a importar
	 * @param notas           listado de notas actuales en el cual se almacenan las
	 *                        notas importadas
	 * @return las notas importadas
	 */
	public ArrayList<String> importarArchivo(String archivoImportar, ArrayList<String> notas) {
		String nombreArchivo = archivoImportar;
		boolean salir = false;
		String línea;

		File refArchivo = new File(nombreArchivo);

		try (BufferedReader archivo = new BufferedReader(new FileReader(refArchivo));) {
			do {
				línea = archivo.readLine();
				if (línea == null) {
					salir = true;
				} else {
					notas.add(línea);
				}
			} while (!salir);
			out.println("✓ Importación realizada");

		} catch (NoSuchFileException e) {
			System.err.printf("Ruta no encontrada: %s %n", e.getLocalizedMessage());
		} catch (IOException e) {
			System.err.printf("Error de lectura: %s %n", e.getLocalizedMessage());
		}
		
		return notas;
	}
}
