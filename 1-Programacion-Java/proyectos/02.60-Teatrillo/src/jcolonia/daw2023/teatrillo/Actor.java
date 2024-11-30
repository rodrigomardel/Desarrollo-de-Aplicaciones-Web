package jcolonia.daw2023.teatrillo;

public class Actor {
	
	private String nombre;
	private int id;
	private static int númActores;
	
	static {
		númActores=0;
	}
	
	public Actor(String nombre) {
		this.nombre=nombre;
		
		númActores++;
		this.id=númActores;		
		
	}
	
	public String getNombre() {
		return nombre;
		
	}
	
	public int getId() {
		return id;
		
	}
	
	public String toString() {
		String texto;
		texto=String.format("%s (%d/%d)", nombre,id,númActores);
		return texto;
		
	}
	
	public static int getNúmActores() {
		return númActores;
		
	}
}
