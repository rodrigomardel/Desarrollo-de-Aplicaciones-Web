package jcolonia.daw2023.ut6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Vista de ejemplo empleando valores obtenidos de una enumeración.
 * @see DíaSemana
 */
public class VistaAltaDía extends VistaGeneral {
	/** Alma
	 * @param nombre
	 * @param scEntrada
	 */
	public VistaAltaDía(String nombre, Scanner scEntrada) {
		super(nombre, scEntrada);
	}

	public DíaSemana introducirDía() {
		VistaMenú menúDía;

		int opción;
		boolean salir = false;
		Scanner in = getScEntrada();

		DíaSemana día;
		menúDía = new VistaMenú("DíaSemana", DíaSemana.getNames(), in);

		menúDía.mostrarMenú();
		opción = menúDía.pedirOpción();
		día = DíaSemana.values()[opción - 1];

		return día;
	}

	public static void main(String[] args) {
		VistaAltaDía vista = new VistaAltaDía("Ejemplo día semana",
				new Scanner(System.in));

		DíaSemana díaElegido = vista.introducirDía();
		VistaGeneral.mostrarTexto(díaElegido.toString());
	}
}
