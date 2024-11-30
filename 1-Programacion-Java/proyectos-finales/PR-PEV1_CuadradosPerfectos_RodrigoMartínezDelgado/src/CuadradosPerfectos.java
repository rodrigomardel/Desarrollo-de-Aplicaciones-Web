
public class CuadradosPerfectos {

	public static void main(String[] args) {
		
		int númeroClase, valorInicial, valorFinal;
		int cuadradoPerfecto, primerCuadrado, últimoCuadrado, contadorCuadrados, sumaCuadrados;
		int i;
		
		númeroClase=13;
		valorInicial=númeroClase*1000;
		valorFinal=númeroClase*100000;
		cuadradoPerfecto=0;
		primerCuadrado=0;
		últimoCuadrado=0;
		contadorCuadrados=0;
		sumaCuadrados=0;
		
		i=0;
		while(cuadradoPerfecto<=valorFinal) {
			
			if(cuadradoPerfecto>=valorInicial) {
				contadorCuadrados++;
				sumaCuadrados += cuadradoPerfecto;
				
					if(contadorCuadrados==1) {
						primerCuadrado=cuadradoPerfecto;	
					}		
			}		
		i++;
		cuadradoPerfecto=i*i;
		}
		
		i--;
		últimoCuadrado=i*i;
		
		System.out.println("• Cuadrados perfectos entre 13.000 y 1.300.000 •");
		System.out.println("------------------------------------------------");
		System.out.printf("Martínez Delgado, Rodrigo - IC%d", númeroClase);
		System.out.println("");
		System.out.println("");
		System.out.printf("Valor inicial: %d%n", valorInicial);
		System.out.printf("Valor final: %d%n", valorFinal);
		System.out.println("");
		System.out.printf("Primer cuadrado: %d%n", primerCuadrado);
		System.out.printf("Último cuadrado: %d%n", últimoCuadrado);
		System.out.printf("Número de cuadrados: %d%n", contadorCuadrados);
		System.out.printf("Suma de todos los cuadrados: %d%n", sumaCuadrados);		
	}
}
