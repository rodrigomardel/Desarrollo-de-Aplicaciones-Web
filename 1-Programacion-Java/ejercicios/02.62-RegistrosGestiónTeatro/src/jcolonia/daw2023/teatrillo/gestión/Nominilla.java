package jcolonia.daw2023.teatrillo.gestión;

import jcolonia.daw2023.teatrillo.gestión.Cotizable.DatosNómina;

/**
 * Gestión, contabilidad sobre una colección de sujetos con distintos valores de
 * trabajo o participación.
 *
 * @author David H. Martín
 * @version 4.0 (20221212)
 */
public class Nominilla {
	/**
	 * Formato tipo «print» para generar una línea de datos de cada sujeto.
	 * <div>Ejemplo:
	 * 
	 * <pre>
	 *  34A Juan 10 1 48,08 480,8 3424C Ana 10 2 48,08 961,6
	 * </pre>
	 * 
	 * </div>
	 */
	private static final String FORMATO_LÍNEA_BÁSICO = "%s %s %f %f %f %f%n";

	private static final String FORMATO_LÍNEA_MEJORADO = "%5.5s %-20.20s %6.2f %6.2f %6.2f %6.2f%n";

	private String formatoLínea;

	/** Colección de sujetos. */
	private Cotizable[] listaSujetos;

	/**
	 * Enlaza la lista de datos facilitada.
	 * 
	 * @param listaOriginal la lista de entrada con los sujetos
	 */
	public Nominilla(Cotizable[] listaOriginal) {
		listaSujetos = listaOriginal;
		formatoLínea = FORMATO_LÍNEA_MEJORADO;
	}

	/**
	 * Construye una tabla de texto con todos los sujetos y los importes computados.
	 * Cada sujeto aparece en una línea independiente con los valores separados por
	 * espacios.
	 * 
	 * <pre>
	 * 34A Juan 10 1 48,08 480,8
	 * 3424C Ana 10 2 48,08 961,6
	 * </pre>
	 * 
	 * @return el texto completo
	 * @see #FORMATO_LÍNEA_BÁSICO
	 */
	@Override
	public String toString() {
		DatosNómina datos;

		String resultado = "";
		String id, nombre;
		double cantidad, coeficiente;

		for (Cotizable sujeto : listaSujetos) {
			datos = sujeto.getDatos();
			id = datos.id();
			nombre = datos.nombre();
			cantidad = datos.cantidad();
			coeficiente = datos.coeficiente();

			resultado += String.format(formatoLínea, id,
					nombre, cantidad, coeficiente,
					Cotizable.PRECIO, cantidad * coeficiente
							* Cotizable.PRECIO);
		}

		return resultado;
	}
}
