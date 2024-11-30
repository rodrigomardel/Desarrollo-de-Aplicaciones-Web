package jcolonia.daw2024.mvc;

import static java.lang.System.out;

import java.util.Scanner;

/**
 * 
 */
public class EjemploMenú {
	public static final String[] OPCIONES_MENÚ_PRINCIPAL = { "lunes", "martes", "miércoles", "jueves", "viernes",
			"sábado", "domingo" };


	/**
	 * @param argumentos
	 */
	public static void main(String[] argumentos) {
		VistaMenú menú;
		int opción, opciónProvisional = -1;

		Scanner entrada;
		entrada = new Scanner (System.in);
		
		menú = new VistaMenú("Horario semanal", OPCIONES_MENÚ_PRINCIPAL, entrada);

		menú.mostrarTítulo();
		do {
			menú.mostrarMenú();
			opción = menú.pedirOpción();

			if (opción != 0) {
				opciónProvisional = opción;
				out.printf("El examen será el «%s»", OPCIONES_MENÚ_PRINCIPAL[opciónProvisional - 1]);
				System.out.println("Piénselo de nuevo…\n");
			}
		} while (opción != 0);

		out.printf("Definitivamentye, el examen será el «%s»", OPCIONES_MENÚ_PRINCIPAL[opciónProvisional - 1]);
	}

	
}
