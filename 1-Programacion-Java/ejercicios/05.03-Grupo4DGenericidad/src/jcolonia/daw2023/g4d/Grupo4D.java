/** 
 * Primer ejemplo de la UT4 donde vamos a trabajar con números en coma flotante.
 * Nos va a servir para poner ejemplos de pruebas y excepciones.
 */
package jcolonia.daw2023.g4d;

/**
 * Conjunto de cuatro números decimales.
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel@educa.jcyl.es&gt;
 * @version 1.0 (20240118)
 */

public class Grupo4D {

	/** Primer número. */
	private double a;

	/** Segundo número. */
	private double b;

	/** Tercer número. */
	private double c;

	/** Cuarto número. */
	private double d;

	/**
	 * Inicializa y da valor 0 a los cuatro números.
	 */
	public Grupo4D() {
		a = 0.00;
		b = 0.00;
		c = 0.00;
		d = 0.00;
	}

	/**
	 * Asigna el valor deaseado a los cuatro números.
	 * 
	 * @param a el valor deseado para el primer número
	 * @param b el valor deseado para el segundo número
	 * @param c el valor deseado para el tercer número
	 * @param d el valor deseado para el cuarto número
	 */
	public Grupo4D(double a, double b, double c, double d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	/**
	 * Consulta el primer valor.
	 * 
	 * @return valor correspondiente
	 */
	public double getA() {
		return a;
	}

	/**
	 * Modifica el primer valor.
	 * 
	 * @param valor nuevo valor deseado
	 */
	public void setA(double valor) {
		a = valor;

	}

	/**
	 * Consulta el segundo valor.
	 * 
	 * @return valor correspondiente
	 */
	public double getB() {
		return b;
	}

	/**
	 * Modifica el segundo valor.
	 * 
	 * @param valor nuevo valor deseado
	 */
	public void setB(double valor) {
		b = valor;

	}

	/**
	 * Consulta el tercer valor.
	 * 
	 * @return valor correspondiente
	 */
	public double getC() {
		return c;
	}

	/**
	 * Modifica el tercer valor.
	 * 
	 * @param valor nuevo valor deseado
	 */
	public void setC(double valor) {
		c = valor;

	}

	/**
	 * Consulta el cuarto valor.
	 * 
	 * @return valor correspondiente
	 */
	public double getD() {
		return d;
	}

	/**
	 * Modifica el cuarto valor.
	 * 
	 * @param valor nuevo valor deseado
	 */
	public void setD(double valor) {
		d = valor;

	}

	/**
	 * Crea un texto con los cuatro números. El formato de los número será el
	 * predeterminado del sistema operativo. <div> Ejemplo:
	 * 
	 * <pre>
	 * (0,00 1,00 3,00 5,00)
	 * </pre>
	 * 
	 * </div>
	 * 
	 * @return texto correspondiente
	 */
	@Override
	public String toString() {
		String texto;
		texto = String.format("(% .2f, % .2f, % .2f, % .2f)", a, b, c, d);
		return texto;

	}

}
