package jcolonia.daw2023.ut6;

public enum DíaSemana {
	LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SÁBADO, DOMINGO;
	
	public static String[] getNames() {
		String[] nombres;
		DíaSemana[] conjuntoDías=values();
		
		nombres=new String[conjuntoDías.length];
		
		for(int i=0; i<conjuntoDías.length;i++) {
			nombres[i]=conjuntoDías[i].name().toLowerCase();
		}
		
		return nombres;
	}
}
