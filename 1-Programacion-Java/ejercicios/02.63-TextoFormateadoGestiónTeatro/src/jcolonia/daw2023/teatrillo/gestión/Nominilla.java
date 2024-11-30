package jcolonia.daw2023.teatrillo.gestión;

/**
 * Gestión, contabilidad sobre una colección de sujetos con distintos valores de
 * trabajo o participación.
 *
 * @author David H. Martín
 * @version 4.0 (20231212000)
 */
public abstract class Nominilla {
	public enum TipoNominilla {
		TXT, HTML, CSV
	}

	private Cotizable[] listaSujetos;

	public abstract String getFormato();

	/**
	 * Recoge la lista da datos facilitada.
	 * 
	 * @param listaOriginal la lista de entrada con los sujetos
	 */
	public Nominilla(Cotizable[] listaOriginal) {
		listaSujetos = listaOriginal;
	}

	public String construirTextoPrefijo() {
		return "";
	}

	public String construirTextoContenido() {
		String resultado = "";
		String id, nombre;
		double cantidad, coeficiente;

		Cotizable.DatosNómina datos;

		buclegeneral: 
		for (Cotizable sujeto : listaSujetos) {
			if (sujeto == null) { // Protección frente a array con huecos
				continue buclegeneral;
			}

			datos = sujeto.getDatos();
			id = datos.id();
			nombre = datos.nombre();
			cantidad = datos.cantidad();
			coeficiente = datos.coeficiente();

			resultado += String.format(getFormato(), id, nombre, cantidad, coeficiente, Cotizable.PRECIO,
					cantidad * coeficiente * Cotizable.PRECIO);
		}

		return resultado;
	}

	public String construirTextoSufijo() {
		return "";
	}

	@Override
	public String toString() {
		return construirTextoPrefijo() + construirTextoContenido() + construirTextoSufijo();
	}

	public static Nominilla ofNominilla(TipoNominilla tipo, Cotizable[] listaOriginal) {
		Nominilla nuevaNominilla = null;
		switch (tipo) {
		case TXT:
			nuevaNominilla = new NominillaTXT(listaOriginal);
			break;
		case HTML:
			nuevaNominilla = new NominillaHTML(listaOriginal);
			break;
		case CSV:
			nuevaNominilla = new NominillaCSV(listaOriginal);
			break;
		default:
			System.err.println("ERROR: ¡Aclárate!");
			System.exit(1);
		}
		return nuevaNominilla;
	}

}
