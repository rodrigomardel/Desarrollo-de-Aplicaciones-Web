package jcolonia.daw2023.g4d;

/**
 * Conjunto de cuatro números decimales, facilita el acceso a esos cuatro
 * valores en forma de lista («<em>array</em>»).
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel@educa.jcyl.es&gt;
 * @version 1.0 (20240118)
 */

public class Grupo4DMejorado extends Grupo4D implements Sumable, Comparable<Grupo4DMejorado> {

	/**
	 * Inicializa y da valor 0 a los cuatro números.
	 */
	public Grupo4DMejorado() {
		super();
	}

	/**
	 * Asigna el valor deaseado a los cuatro números.
	 * 
	 * @param a el valor deseado para el primer número
	 * @param b el valor deseado para el segundo número
	 * @param c el valor deseado para el tercer número
	 * @param d el valor deseado para el cuarto número
	 */
	public Grupo4DMejorado(double a, double b, double c, double d) {
		super(a, b, c, d);

	}

	/**
	 * Recibe una lista de números decimales y los almacena.
	 * 
	 * @param valores lista de valores deseada
	 * @throws Grupo4DException si la lista de valores es nula o su tamaño es
	 *                          distinto a 4
	 */
	public Grupo4DMejorado(double[] valores) throws Grupo4DException {
		super();
		if (valores == null || valores.length != 4) {
			throw new Grupo4DException("La lista de valores es nula o su tamaño es distinto a 4");
		}

		setA(valores[0]);
		setB(valores[1]);
		setC(valores[2]);
		setD(valores[3]);

	}

	/**
	 * Modifica los cuatro valores.
	 * 
	 * @param valores nueva lista de valores deseada
	 * @throws Grupo4DException si la lista de valores es nula o su tamaño es
	 *                          distinto a 4
	 */
	public void setValores(double[] valores) throws Grupo4DException {
		if (valores == null || valores.length != 4) {
			throw new Grupo4DException("La lista de valores es nula o su tamaño es distinto a 4");
		}
		setA(valores[0]);
		setB(valores[1]);
		setC(valores[2]);
		setD(valores[3]);

	}

	/**
	 * Consulta los cuatro valores y los devuelve en forma de lista.
	 * 
	 * @return los valores correspondientes
	 */
	public double[] getValores() {
		double[] listaValores;
		listaValores = new double[4];

		listaValores[0] = getA();
		listaValores[1] = getB();
		listaValores[2] = getC();
		listaValores[3] = getD();

		return listaValores;

	}

	/**
	 * Calcula la suma de los cuatro números almacenados.
	 * 
	 * @return el resultado correspondiente
	 */
	@Override
	public double suma() {
		double resultado;

		resultado = getA();
		resultado += getB();
		resultado += getC();
		resultado += getD();

		return resultado;
	}

	/**
	 * Calcula la media entre los cuatro números almacenados.
	 * 
	 * @return el resultado correspondiente
	 */
	@Override
	public double media() {
		double resultado;

		resultado = suma() / 4;

		return resultado;
	}

	/**
	 * Calcula el valor máximo entre los números almacenados.
	 * 
	 * @return el resultado correspondiente
	 */
	@Override
	public double máximo() {
		double máximo;
		double[] valores;

		valores = getValores();
		máximo = valores[0];

		for (int i = 1; i < valores.length; i++) {
			if (valores[i] > máximo) {
				máximo = valores[i];
			}

		}

		return máximo;
	}

	/**
	 * Calcula el valor mínimo entre los números almacenados.
	 * 
	 * @return el resultado correspondiente
	 */
	@Override
	public double mínimo() {
		double mínimo;
		double[] valores;

		valores = getValores();
		mínimo = valores[0];

		for (int i = 1; i < valores.length; i++) {
			if (valores[i] < mínimo) {
				mínimo = valores[i];
			}

		}

		return mínimo;
	}

	/**
	 * Compara un grupo con otro. El criterio de comparación es la media de los
	 * cuatro valores.
	 * 
	 * @param otroGrupo grupo a comparar
	 * @return si es resultado es mayor 1, menor -1 o igual 0
	 */
	@Override
	public int compareTo(Grupo4DMejorado otroGrupo) {
		int resultado;

		if (this.media() > otroGrupo.media()) {
			resultado = 1;

		} else if (this.media() < otroGrupo.media()) {
			resultado = -1;

		} else {
			resultado = 0;
		}

		return resultado;
	}

}
