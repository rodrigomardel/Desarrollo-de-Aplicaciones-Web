public class TablaMultiplicar{

	public static void main (String[] args){
	
	int producto;
	int multiplicando;
	
	multiplicando=4;
	
	System.out.println("Tabla de multiplicar del 4");
	System.out.println("--------------------------");
	
		for(int i=1;i<=10;i++){
		producto=multiplicando*i;
		
		System.out.printf("% d×% d=%d%n", multiplicando,i,producto);
		}	
	}	
}	