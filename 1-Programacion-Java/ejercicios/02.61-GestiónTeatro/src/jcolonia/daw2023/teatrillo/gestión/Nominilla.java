package jcolonia.daw2023.teatrillo.gestión;

/**
 * Gestión, contabilidad sobre una colección de sujetos con distintos valores de
 * trabajo o participación.
 *
 * @author David H. Martín
 * @version 4.0 (20221212)
 */
public class Nominilla {
	private static final String FORMATO_LÍNEA_BÁSICO = "%s %s %f %f %f %f%n";
	private Cotizable[] listaSujetos;

	/**
	 * Enlaza la lista de datos facilitada.
	 * 
	 * @param listaOriginal la lista de entrada con los sujetos
	 */
	public Nominilla(Cotizable[] listaOriginal) {
		listaSujetos = listaOriginal;
	}

	/**
	 * Construye una lista con todos los sujetos y los importes computados. Cada
	 * sujeto aparece en una línea independiente con los valores separados por
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
		String resultado = "";
		String id, nombre;
		double cantidad, coeficiente;

//		for (Cotizable sujeto : listaSujetos) {
//			id = sujeto.getIdentificador();
//			nombre = sujeto.getNombre();
//			cantidad = sujeto.getCantidad();
//			coeficiente = sujeto.getCoeficiente();
//
//			resultado += String.format(FORMATO_LÍNEA_BÁSICO, id, nombre, cantidad, coeficiente, Cotizable.PRECIO,
//					cantidad * coeficiente * Cotizable.PRECIO);
//		}
		
		for (int i = 0; i < listaSujetos.length; i++) {
			id = listaSujetos[i].getIdentificador();
			nombre = listaSujetos[i].getNombre();
			cantidad = listaSujetos[i].getCantidad();
			coeficiente = listaSujetos[i].getCoeficiente();

			resultado += String.format(FORMATO_LÍNEA_BÁSICO, id, nombre, cantidad, coeficiente, Cotizable.PRECIO,
					cantidad * coeficiente * Cotizable.PRECIO);
		}

		return resultado;
	}
}
