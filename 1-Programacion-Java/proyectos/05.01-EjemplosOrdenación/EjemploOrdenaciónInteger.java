package jcolonia.daw2023.ordenación;

import static java.lang.System.out;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class EjemploOrdenaciónInteger {
	private Integer[] lista;
	private int númElementos;

	public EjemploOrdenaciónInteger() {
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
		int posCandidatoMáx, posDestino, j;
		int tmp;
		for (posDestino = númElementos - 1; posDestino >= 0; posDestino--) {
			posCandidatoMáx = 0;
			for (j = 1; j <= posDestino; j++) {
				if (lista[j].compareTo(lista[posCandidatoMáx]) > 0) { // Comparación de objetos Integer
					posCandidatoMáx = j;
				}
			}
			if (posDestino != posCandidatoMáx) {
				tmp = lista[posDestino];
				lista[posDestino] = lista[posCandidatoMáx];
				lista[posCandidatoMáx] = tmp;
			}
		}
	}

	public static void main(String[] args) {
		EjemploOrdenaciónInteger lote;
		lote = new EjemploOrdenaciónInteger();
		lote.rellenarAleatorios();
		out.printf("Originales:    %s%n", lote);
		lote.ordenar();
		out.printf("Ascendente:    %s%n", lote);
	}
}
