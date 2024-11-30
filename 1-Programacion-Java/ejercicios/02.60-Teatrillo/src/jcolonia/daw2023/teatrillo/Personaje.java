package jcolonia.daw2023.teatrillo;

public class Personaje extends Actor {
	
	private int númFrases;
	

	
	public Personaje (String nombre) {
		super(nombre);
		númFrases = 0;
		
		
	}
	
	private void anotaFrase() {
		númFrases++;
		
	}
	
	public String saluda() {
		String texto;
		anotaFrase();
		texto = String.format("%s saluda [%d]",getNombre(),númFrases);
		return texto;
		
	}
	
	public String saluda(Actor nuevoActor) {
		String texto;
		anotaFrase();
		texto = String.format("%s saluda a %s [%d]", getNombre(), nuevoActor.getNombre(),númFrases);
		return texto;		
		
	}
	
	public String despide() {
		String texto;
		anotaFrase();
		texto=String.format("%s se "
				+ "despide [%d]",getNombre(),númFrases);
		return texto;
		
	}
	
	public String despide(Actor exActor) {
		String texto;
		anotaFrase();
		texto = String.format("%s despide a %s [%d]", getNombre(), exActor.getNombre(),númFrases);
		return texto;	
		
	}
	

}
