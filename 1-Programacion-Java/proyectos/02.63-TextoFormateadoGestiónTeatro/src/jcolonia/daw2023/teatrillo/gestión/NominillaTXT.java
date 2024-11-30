package jcolonia.daw2023.teatrillo.gestión;

public class NominillaTXT extends Nominilla {
	private static final String FORMATO_LÍNEA_TXT = "%10.10s %-20.20s %6.2f uds.  × %8.2f  × %8.2f €  =  %8.2f €%n";

	public NominillaTXT(Cotizable[] listaOriginal) {
		super(listaOriginal);
	}
	
	@Override
	public String getFormato() {
		return FORMATO_LÍNEA_TXT;
	}
}
