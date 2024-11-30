package jcolonia.daw2023.junio;

public record País(String nombre, String capital, String idioma) {

	public String toString() {
		String texto;
		texto = String.format("Nombre: %s,\t Capital: %s,\t Idioma: %s,\t Descripción: %s\n", nombre,
				capital, idioma);
		return texto;

	}
}
