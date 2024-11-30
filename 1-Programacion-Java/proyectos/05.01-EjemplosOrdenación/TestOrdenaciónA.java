package jcolonia.daw2023.ordenación;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestOrdenaciónA {
	private static final int ITERACIONES = 100000;

	@Test
	@DisplayName("Ordenación Quicksort")
	void testQuicksort() {
		for (int i = 1; i < ITERACIONES; i++)
			verificar(new QuicksortRecursivo(false));
	}

	@Test
	@DisplayName("Ordenación por selección del máximo")
	void testSelecciónMáximo() {
		for (int i = 1; i < ITERACIONES; i++)
			verificar(new SelecciónMáximo(false));
	}

	@Test
	@DisplayName("Ordenación nativa Java «Arrays.sort()»")
	void testJArraysSort() {
		for (int i = 1; i < ITERACIONES; i++)
			verificar(new JArraysSort(false));
	}

	private static void verificar(EjemploOrdenación ejemplo) {
		int[] lista = ejemplo.lista;
		int númElementos = ejemplo.númElementos;

		ejemplo.ordenar();

		int actual, anterior = lista[0];
		for (int i = 1; i < númElementos; i++) {
			actual = lista[i];
			assertTrue(actual >= anterior,
					String.format("Elemento %d/%d descolocado: %02d > %02d", i + 1, númElementos, actual, anterior));
			anterior = actual;
		}
	}
}
