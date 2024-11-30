
public class EjemploMatrices_0220 {

	public static void main(String[] args) {
		String[] díasSemana= {"1","2","3",""};
		
		
		// Bucle «for»
		int tamañoMatriz = díasSemana.length;
			for(int i=0; i<tamañoMatriz;i++) {
				System.out.printf("Elemento %d: «%s»%n",i,díasSemana[i]);				
			}
		System.out.println();	
		
		
		// Bucle «for-each»	
		for (String nombreDía: díasSemana) {
			System.out.printf("Elemento: «%s»%n",nombreDía);		
		}
		System.out.println();	
		
		
		// Bucle «while»
		int posición;
		posición=0;
		while(posición < díasSemana.length) {
			System.out.printf("Elemento %d: «%s»%n", posición, díasSemana[posición]);
			++posición;	
		}	
		System.out.println();	
		
	}
}
