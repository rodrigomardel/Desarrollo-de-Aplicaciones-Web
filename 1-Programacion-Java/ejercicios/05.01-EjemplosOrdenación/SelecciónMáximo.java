package jcolonia.daw2023.ordenación;

public class SelecciónMáximo extends EjemploOrdenación {
	public SelecciónMáximo(boolean imprimir) {
		super(imprimir);
	}

	public void ordenar() {
		int i, j;
		int máx, posMáx, candidato;

		for (i = númElementos - 1; i > 0; i--) {
			posMáx = 0;
			máx = lista[posMáx];

			for (j = 1; j <= i; j++) {
				candidato = lista[j];
				if (candidato > máx) {
					númComparaciones++;

					posMáx = j;
					máx = lista[posMáx];
				}
			}
			if (i != posMáx) {
				intercambiar(i, posMáx);
			}

			if (imprimir) {
				imprimir(marcaElemento(posMáx));
				imprimir(this);
			}
		}
	}

	public static void main(String[] args) {
		SelecciónMáximo ejemplo = new SelecciónMáximo(true);
		System.out.println(ejemplo);
		ejemplo.ordenar();
		ejemplo.verificar();
		System.out.printf("Elementos: %d Comparaciones: %s Cambios: %d%n", ejemplo.númElementos,
				ejemplo.númComparaciones, ejemplo.númCambios);
	}
}
