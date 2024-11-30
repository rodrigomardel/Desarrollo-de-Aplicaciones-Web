package jcolonia.daw2023.ordenación;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author dmartin
 *
 */
public class EjemploOrdenaciónArraysSortLambda {
	private Integer[] lista;
	private int númElementos;

	public EjemploOrdenaciónArraysSortLambda() {
		Random rnd = ThreadLocalRandom.current();
		lista = new Integer[20 + rnd.nextInt(2)];
		númElementos = 0;
	}

	public void rellenarAleatorios() {
		int i, n;
		Random rnd = ThreadLocalRandom.current();
		n = (int) (lista.length * 0.8) + rnd.nextInt(2);
		for (i = 0; i < n; i++) {
			lista[i] = Integer.valueOf(-10 + rnd.nextInt(21));
		}
		for (; i < lista.length; i++) {
			lista[i] = null;
		}
		númElementos = n;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < lista.length; i++) {
			try {
				sb.append(lista[i].toString());
			} catch (NullPointerException e) {
				sb.append("(null)");
			}
			if (i != lista.length - 1) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}

	private void ordenar() {
		Arrays.sort(lista, 0, númElementos, new Comparator<Integer>() {
			// ¡Clase anónima!
			@Override
			public int compare(Integer uno, Integer otro) {
				return uno.compareTo(otro);
			}
		});
	}

	private void ordenar1() {
		// ¡¡¡Con una expresión lambda sencilla!!!
		Arrays.sort(lista, 0, númElementos, (Integer uno, Integer otro) -> -uno.compareTo(otro));
	}

	private void ordenar2() {
		// ¡¡¡Con una mega-expresión lambda!!!
		Arrays.sort(lista, 0, númElementos, (Integer uno, Integer otro) -> {
			int resultado = 0;
			if (Math.abs(uno) % 2 == Math.abs(otro) % 2) {
				resultado = -uno.compareTo(otro); // orden descendente
			} else if (Math.abs(uno) % 2 == 0) { // pares menores
				resultado = -1;
			} else { // impares mayores
				resultado = 1;
			}
			return resultado;
		});
	}

	public static void main(String[] args) {
		EjemploOrdenaciónArraysSortLambda lote;
		lote = new EjemploOrdenaciónArraysSortLambda();
		lote.rellenarAleatorios();
		out.printf("Originales:    %s%n", lote);
		lote.ordenar();
		out.printf("Ascendente:    %s%n", lote);
		lote.ordenar1();
		out.printf("Descente:      %s%n", lote);
		lote.ordenar2();
		out.printf("Pares/impares: %s%n", lote);
	}
}
