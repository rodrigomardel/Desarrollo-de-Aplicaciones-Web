package jcolonia.daw2023.ordenación;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public abstract class EjemploOrdenación {
	protected int[] lista;
	private final int TAMAÑO_MÁX = 100;
	protected int númElementos;
	protected int númCambios;
	protected int númComparaciones;
	protected boolean imprimir;

	public EjemploOrdenación(boolean imprimir) {
		Random rnd = ThreadLocalRandom.current();
		númElementos = 40 + rnd.nextInt(2); // Par o impar
		lista = new int[TAMAÑO_MÁX];

		númCambios = 0;
		númComparaciones = 0;

		for (int i = 0; i < númElementos; i++) {
			lista[i] = rnd.nextInt(100);
		}

		this.imprimir = imprimir;
	}

	public abstract void ordenar();

	public void intercambiar(int posA, int posB) {
		int valorAux;

		valorAux = lista[posA];
		lista[posA] = lista[posB];
		lista[posB] = valorAux;

		númCambios++;
	}

	public String marcaElemento(int n) {
		String resultado = "";

		for (int i = 0; i < númElementos; i++) {
			resultado += String.format("%2s ", (i == n) ? "-^" : "  ");
		}

		return resultado;
	}

	public void verificar() {
		int actual, anterior = lista[0];
		for (int i = 1; i < númElementos; i++) {
			actual = lista[i];
			if (actual < anterior) {
				System.out.println(marcaElemento(i));
				System.out.println("¡Errores!");
				break;
			} else {
				anterior = actual;
			}
		}
	}

	public void imprimir(Object x) {
		if (imprimir) {
			System.out.println(x);
		}
	}

	@Override
	public String toString() {
		String resultado = "";

		for (int i = 0; i < númElementos; i++) {
			resultado += String.format("%02d ", lista[i]);
		}

		return resultado;
	}
}
