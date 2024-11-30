package jcolonia.daw2024.tablaMultiplicar;

import java.util.ArrayList;

/**
 * Tabla de multiplicar usando la clase de utilidad ArrayList.
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel@educa.jcyl.es&gt;
 * @version 1.0 (20240304)
 */
public class TablaMultiplicar {

	/** Número de la tabla de multiplicar */
	private int número;

	/** Resultados */
	private ArrayList<String> líneasProductos;

	/**
	 * Asigna el número recibido e inicializa las líneas de productos.
	 * 
	 * @param número el número a multiplicar deseado
	 */
	public TablaMultiplicar(int número) {
		this.número = número;
		líneasProductos = new ArrayList<String>();

	}

	/**
	 * Agrega las líneas de la tabla de multiplicar.
	 */
	public void generarLíneas() {
		int númeroLínea = 0;
		for (int i = 0; i <= 10; i++) {
			númeroLínea++;
			líneasProductos.add(String.format("(%d.)→ %2d * %2d = %2d",númeroLínea, número, i, número * i));
		}

	}

	/**
	 * Consulta las líneas de la tabla de multiplicar.
	 * 
	 * @return las líneas de la tabla
	 */
	public String[] getLíneas() {
		String[] líneas;
		líneas = new String[líneasProductos.size()];
		return líneasProductos.toArray(líneas);
		//Equivalente
//		for (int i = 0; i < líneas.length; i++) {
//		líneas[i] = líneasProductos.get(i);
//		}
	}

	/**
	 * Crea el texto de las líneas de la tabla de multiplicar usando la clase
	 * StringBuffer, evitando la concatenación y sobrecarga de String. <div>
	 * Ejemplo:
	 * 
	 * <pre>
	 * 2 * 0 = 0
	 * 2 * 1 = 2
	 * 2 * 2 = 4
	 * 2 * 3 = 6
	 * 2 * 4 = 8
	 * 2 * 5 = 10
	 * 2 * 6 = 12
	 * 2 * 7 = 14
	 * 2 * 8 = 16
	 * 2 * 9 = 18
	 * 2 * 10 = 20
	 * </pre>
	 * 
	 * </div>
	 * 
	 * @return el texto deseado
	 */
	public String toString() {
		StringBuffer sbtexto;
		sbtexto = new StringBuffer();

		for (String línea : líneasProductos) {
			sbtexto.append(línea);
			sbtexto.append("\n");
		}
		return sbtexto.toString();

	}
}
