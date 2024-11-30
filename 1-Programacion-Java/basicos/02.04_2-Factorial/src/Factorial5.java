public class Factorial5{
	
	public static void main(String[] agrs){
		
		int n,i,factorial;
		String mensaje;

		n=5;
		factorial=1;

		for (i=n;i>1;i--){
			factorial=factorial*i;
			//factorial*=i;

		}

		mensaje=String.format("El factorial de %d es %d",n,factorial);
		System.out.println(mensaje);	
	}
}