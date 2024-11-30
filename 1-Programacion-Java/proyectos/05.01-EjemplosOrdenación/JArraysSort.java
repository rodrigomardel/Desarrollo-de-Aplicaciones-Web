package jcolonia.daw2023.ordenación;

import java.util.Arrays;

public class JArraysSort extends EjemploOrdenación {
	public JArraysSort(boolean imprimir) {
		super(imprimir);
	}

	@Override
	public void ordenar() {
		Arrays.sort(lista, 0, númElementos);
	}

	public static void main(String[] args) {
		JArraysSort ejemplo = new JArraysSort(true);
		System.out.println(ejemplo);
		ejemplo.ordenar();
		System.out.println(ejemplo);
		ejemplo.verificar();
		System.out.printf("Elementos: %d%n", ejemplo.númElementos);
	}
}
