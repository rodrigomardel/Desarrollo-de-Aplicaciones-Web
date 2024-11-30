public class TablaMultiplicar {
	
	private int número;
	

	public TablaMultiplicar(int número) {
		this.número=número;

	}
	
	public String toString() {
		String resultado ="";
		
		int producto;
			
			for(int i=1;i<=10;i++){
			producto=número*i;
			
			resultado += String.format("%2d × %2d = %2d%n", número,i,producto);
			}
			return resultado;
	}

	public static void main(String[] args) {
		TablaMultiplicar tablaDelSiete;
		tablaDelSiete = new TablaMultiplicar(7);
		System.out.print(tablaDelSiete.toString());
	}
}