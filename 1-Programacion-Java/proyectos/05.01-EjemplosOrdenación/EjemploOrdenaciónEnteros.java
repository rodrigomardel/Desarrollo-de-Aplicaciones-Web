package jcolonia.daw2023.ordenación;

import static java.lang.System.out;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class EjemploOrdenaciónEnteros {
	private int[] lista;
	private int númElementos;

	public EjemploOrdenaciónEnteros() {
		Random rnd = ThreadLocalRandom.current();

		lista = new int[20 + rnd.nextInt(2)];
		númElementos = 0;
	}

	public void rellenarAleatorios() {
		Random rnd = ThreadLocalRandom.current();

		int n = (int) (lista.length * 0.8);
		for (int i = 0; i < lista.length; i++) {
			lista[i] = (i < n) ? -10 + rnd.nextInt(21) : 0;
		}
		númElementos = n;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < lista.length; i++) {
			sb.append(lista[i]);
			if (i != lista.length - 1) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}

	private void ordenar() {
		int posCandidatoMáx, posDestino, j;
		int tmp;
		for (posDestino = númElementos - 1; posDestino > 0; posDestino--) {
			posCandidatoMáx = 0;
			for (j = 1; j <= posDestino; j++) {
				if (lista[j] > lista[posCandidatoMáx]) { // Comparación de valores int
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
		EjemploOrdenaciónEnteros lote;
		lote = new EjemploOrdenaciónEnteros();
		lote.rellenarAleatorios();
		out.printf("Originales:    %s%n", lote);
		lote.ordenar();
		out.printf("Ascendente:    %s%n", lote);
	}
}
