public class MediaMúltiplos3{
	
	public static void main (String[] args){

		int suma=0;
		int númeroElementos=0;
		double media=0;
		
		for(int i=1; i<=10; i++){
			if(i%3==0){
				//suma=suma+i;
				suma +=i;
				númeroElementos++;
			}
		}
	
	media = (double)suma/númeroElementos;
	System.out.printf("Encontrados %d múltiplos de 3 que suman %d\n", númeroElementos,suma);
	System.out.printf("La media es %f", media);

	}		
}