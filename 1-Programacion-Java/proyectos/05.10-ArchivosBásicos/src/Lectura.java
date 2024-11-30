import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;
import java.util.stream.Stream;

/**
 * Ejemplo de tratamiento de archivos. - Lectura de archivo de texto corto -.
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel@educa.jcyl.es&gt;
 * @version 1.0 (20240320)
 */
public class Lectura {
	
	/** Ruta completa del archivo*/
	private static final String NOMBRE_PREDETERMINADO = "recursos/ejemplo.txt";

	public static void main(String[] args) {
		String nombreArchivo = NOMBRE_PREDETERMINADO;
		boolean salir = false;
		String línea;
		int contador = 1;

		try {
			File refArchivo = new File(nombreArchivo);
			FileReader fr = new FileReader(refArchivo);
			BufferedReader archivo = new BufferedReader(fr);
			do {
				línea = archivo.readLine();
				if (línea == null) {
					salir = true;
				} else {
					System.out.printf("%d. %s%n", contador++, línea);

				}
			} while (!salir);
			archivo.close();

		} catch (FileNotFoundException e) {
			System.err.printf("Ruta no encontrada: %s", e.getLocalizedMessage());
		} catch (IOException e) {
			System.err.printf("Error de escritura: %s", e.getLocalizedMessage());
		}
	}
}
