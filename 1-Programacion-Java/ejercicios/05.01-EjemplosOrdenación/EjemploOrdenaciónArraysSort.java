package jcolonia.daw2023.ordenación;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.Random;

public class EjemploOrdenaciónArraysSort {
	private static final Random rnd;
	static {
		rnd = new Random();
	}

	private Integer[] lista;
	private int númElementos;

	public EjemploOrdenaciónArraysSort() {
		lista = new Integer[20 + rnd.nextInt(2)];
		númElementos = 0;
	}

	public void rellenarAleatorios() {
		int i, n;
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
		Arrays.sort(lista, 0, númElementos);
	}

	public static void main(String[] args) {
		EjemploOrdenaciónArraysSort lote;
		lote = new EjemploOrdenaciónArraysSort();
		lote.rellenarAleatorios();
		out.printf("Originales:    %s%n", lote);
		lote.ordenar();
		out.printf("Ascendente:    %s%n", lote);
	}
}
