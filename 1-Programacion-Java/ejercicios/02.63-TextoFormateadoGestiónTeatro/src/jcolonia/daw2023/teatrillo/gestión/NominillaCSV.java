package jcolonia.daw2023.teatrillo.gestión;

public class NominillaCSV extends Nominilla {
	private static final String FORMATO_LÍNEA_CSV = "%s;%s;%f;%f;%f;%f%n";

	public NominillaCSV(Cotizable[] listaOriginal) {
		super(listaOriginal);
	}
	
	@Override
	public String getFormato() {
		return FORMATO_LÍNEA_CSV;
	}
}
