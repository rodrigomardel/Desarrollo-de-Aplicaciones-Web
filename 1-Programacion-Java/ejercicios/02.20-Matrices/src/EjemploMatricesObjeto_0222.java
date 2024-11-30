
public class EjemploMatricesObjeto_0222 {
	private String[] díasSemana = { "1", "2", "3", "" };
	
	
	public void mostrarDatos(){
		System.out.printf("El primer elemento es '%s'%n", díasSemana[0]);
		System.out.printf("El último elemento es '%s'%n", díasSemana[díasSemana.length - 1]);

		this.mostrarLista();
	}

	public void mostrarLista(){
		int posición = 0;
		while (posición < díasSemana.length) {
			System.out.printf("Elemento %d: «%s»%n", posición, díasSemana[posición]);
			++posición;
		}
	}
	
	public static void main(String[] args) {	
		EjemploMatricesObjeto_0222 ejemplo;
		ejemplo= new EjemploMatricesObjeto_0222();
		
		ejemplo.mostrarDatos();
	}
}
