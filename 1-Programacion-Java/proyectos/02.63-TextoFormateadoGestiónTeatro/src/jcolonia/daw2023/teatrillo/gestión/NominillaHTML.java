package jcolonia.daw2023.teatrillo.gestión;

public class NominillaHTML extends Nominilla {
	private static final String FORMATO_LÍNEA_HTML = "<tr><td>%s</td><td>%s</td><td>%f</td><td>%f</td><td>%f</td><td>%f</td></tr>%n";

	public NominillaHTML(Cotizable[] listaOriginal) {
		super(listaOriginal);
	}

	@Override
	public String construirTextoPrefijo() {
		String texto = """
				<!DOCTYPE html>
				<html lang="es">
				<head>
				  <meta charset="utf-8">
				  <title>Nominilla HTML</title>
				</head>

				<body>
				<table>
				""";

		return texto;
	}

	@Override
	public String construirTextoSufijo() {
		String texto = """
				</table>
				</body>
				</html>
				""";

		return texto;
	}

	@Override
	public String getFormato() {
		return FORMATO_LÍNEA_HTML;
	}
}
