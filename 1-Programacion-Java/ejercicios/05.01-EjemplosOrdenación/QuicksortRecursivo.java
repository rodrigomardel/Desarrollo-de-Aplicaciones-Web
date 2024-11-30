package jcolonia.daw2023.ordenación;

public class QuicksortRecursivo extends EjemploOrdenación {
	public QuicksortRecursivo(boolean imprimir) {
		super(imprimir);
	}

	@Override
	public void ordenar() {
		ordenar(0, númElementos - 1);
	}

	public void ordenar(int inicio, int fin) {
		if (fin > inicio) { // Detener recursividad
			int i, d;
			int pivote, posPivote;

			posPivote = fin;
			pivote = lista[posPivote];

			i = inicio;
			d = fin;

			while (i < d) {
				while (i < d && lista[i] <= pivote) { // Avanzar por los menores
					númComparaciones++;
					i++;
				}
				while (i < d && lista[d] >= pivote) { // Avanzar por los mayores
					númComparaciones++;
					d--;
				}
				intercambiar(i, d); // Permutar porque estarán descolocados
			}

			if (i != posPivote) {
				intercambiar(d, posPivote); // Pivote al centro
			}

			if (imprimir) {
				imprimir(this);
				imprimir(marcaElemento(d));
			}
			ordenar(inicio, d - 1); // Ordenar los menores
			ordenar(d + 1, fin); // Ordenar los mayores
		}
	}

	public static void main(String[] args) {
		QuicksortRecursivo ejemplo = new QuicksortRecursivo(true);
		System.out.println(ejemplo);
		ejemplo.ordenar();
		ejemplo.verificar();
		System.out.printf("Elementos: %d Comparaciones: %s Cambios: %d%n", ejemplo.númElementos,
				ejemplo.númComparaciones, ejemplo.númCambios);
	}
}
