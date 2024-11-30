package jcolonia.daw2023.g4d;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Pruebas sobre la clase {@link Grupo4DMejorado}. Comprobaciones básicas de los
 * valores inicializados constructor lista de valores, modificaciones y consulta
 * de esos valores.
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel@educa.jcyl.es&gt;
 * @version 1.0 (20240130)
 */
class Grupo4DMejoradoAzulTest {

	/**
	 * Lista con valor nulo.
	 */
	private static final double[] LISTA_NULA = null;

	/**
	 * Lista de tres ceros.
	 */
	private static final double[] LISTA_TRES_CEROS = { .0, .0, .0 };

	/**
	 * Lista de cuatro ceros.
	 */
	private static final double[] LISTA_CUATRO_CEROS = { 0.0, 0.0, 0.0, 0.0 };

	/**
	 * Lista de cinco ceros.
	 */
	private static final double[] LISTA_CINCO_CEROS = { .0, .0, .0, .0, .0 };

	/**
	 * Lista de tres números.
	 */
	private static final double[] LISTA_TRES = { 1., 2., 3. };

	/**
	 * Lista de cinco números.
	 */
	private static final double[] LISTA_CINCO = { -5., 4., -3., 2., -1. };

	/**
	 * Lista de cuatro números.
	 */
	private static final double[] LISTA_CUATRO = { -5.44, 5.33, -0.1e20, 9.65 };

	/**
	 * Inicializa recursos comunes a todas las pruebas una única vez antes de que se
	 * ejecuten todas las pruebas de la clase.
	 * 
	 * @throws Exception excepción esperada
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Inicializa recursos comunes a todas las pruebas una única vez después de que
	 * se ejecuten todas las pruebas de la clase.
	 * 
	 * @throws Exception excepción esperada
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Inicializa recursos comunes antes de cada prueba individual.
	 *
	 * @throws Exception excepción esperada
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * Inicializa recursos comunes después de cada prueba individual.
	 *
	 * @throws Exception excepción esperada
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Comprueba que usando el constructor con la lista de los cuatro valores
	 * deseados, los cuatro valores quedan modificados correctamente. Las
	 * comprobaciones se realizan a través de {@link Grupo4DMejorado#getValores()}
	 * 
	 * 
	 * @see Grupo4DMejorado#Grupo4DMejorado(double[])
	 */
	@Test
	@DisplayName("Constructor ← Lista 4 valores")
	void testConstructorListaValores() {
		Grupo4DMejorado grupo;

		grupo = assertDoesNotThrow(() -> new Grupo4DMejorado(LISTA_CUATRO), " Datos correctos excepción no esperada");

		double[] listaLeída = grupo.getValores();

		assertEquals(LISTA_CUATRO[0], listaLeída[0], "Primer elemento");
		assertEquals(LISTA_CUATRO[1], listaLeída[1], "Segundo elemento");
		assertEquals(LISTA_CUATRO[2], listaLeída[2], "Tercer elemento");
		assertEquals(LISTA_CUATRO[3], listaLeída[3], "Cuarto elemento");

	}

	/**
	 * Verifica que al tratar de crear el grupo a partir de una lista nula se lanza
	 * la excepción {@link Grupo4DException} y que la misma contiene un texto
	 * descriptivo.
	 * 
	 * @see Grupo4DMejorado#Grupo4DMejorado(double[])
	 */
	@Test
	@DisplayName("Excepción Constructor ← Lista nula")
	void testExcepciónConstructorListaNula() {
		Grupo4DException ex;

		ex = assertThrows(Grupo4DException.class, () -> new Grupo4DMejorado(LISTA_NULA),
				"Excepción por lista de tamaño inadecuado esperada");
		verificarTextoExcepción(ex);

	}

	/**
	 * Verifica que al tratar de crear el grupo a partir de una lista de 3 ceros
	 * lanza la excepción {@link Grupo4DException} y que la misma contiene un texto
	 * descriptivo.
	 * 
	 * @see Grupo4DMejorado#Grupo4DMejorado(double[])
	 */
	@Test
	@DisplayName("Excepción Constructor ← Lista 3 ceros")
	void testExcepciónConstructorLista3Ceros() {
		Grupo4DException ex;

		ex = assertThrows(Grupo4DException.class, () -> new Grupo4DMejorado(LISTA_TRES_CEROS),
				"Excepción por lista de tamaño inadecuado esperada");
		verificarTextoExcepción(ex);

	}

	/**
	 * Verifica que al tratar de crear el grupo a partir de una lista de 5 ceros
	 * lanza la excepción {@link Grupo4DException} y que la misma contiene un texto
	 * descriptivo.
	 * 
	 * @see Grupo4DMejorado#Grupo4DMejorado(double[])
	 */
	@Test
	@DisplayName("Excepción Constructor ← Lista 5 ceros")
	void testExcepciónConstructorLista5Ceros() {
		Grupo4DException ex;

		ex = assertThrows(Grupo4DException.class, () -> new Grupo4DMejorado(LISTA_CINCO_CEROS),
				"Excepción por lista de tamaño inadecuado esperada");
		verificarTextoExcepción(ex);

	}

	/**
	 * Verifica que al tratar de crear el grupo a partir de una lista de 3 valores
	 * lanza la excepción {@link Grupo4DException} y que la misma contiene un texto
	 * descriptivo.
	 * 
	 * @see Grupo4DMejorado#Grupo4DMejorado(double[])
	 */
	@Test
	@DisplayName("Excepción Constructor ← Lista 3 valores")
	void testExcepciónConstructorLista3Valores() {
		Grupo4DException ex;

		ex = assertThrows(Grupo4DException.class, () -> new Grupo4DMejorado(LISTA_TRES),
				"Excepción por lista de tamaño inadecuado esperada");
		verificarTextoExcepción(ex);

	}

	/**
	 * Verifica que al tratar de crear el grupo a partir de una lista de 5 valores
	 * lanza la excepción {@link Grupo4DException} y que la misma contiene un texto
	 * descriptivo.
	 * 
	 * @see Grupo4DMejorado#Grupo4DMejorado(double[])
	 */
	@Test
	@DisplayName("Excepción Constructor ← Lista 5 valores")
	void testExcepciónConstructorLista5Valores() {
		Grupo4DException ex;

		ex = assertThrows(Grupo4DException.class, () -> new Grupo4DMejorado(LISTA_CINCO),
				"Excepción por lista de tamaño inadecuado esperada");
		verificarTextoExcepción(ex);

	}

	/**
	 * Comprueba que al modificar los valores del grupo quedan modificados
	 * correctamente. Las comprobaciones se realizan a través de
	 * {@link Grupo4DMejorado#getValores()}
	 * 
	 * @see Grupo4DMejorado#setValores(double[])
	 * @throws Grupo4DException no es espera que salte para este caso
	 */
	@Test
	@DisplayName("Set Valores ← Lista 4 ceros")
	void testSetvaloresLista4Ceros() throws Grupo4DException {
		Grupo4DMejorado grupo;
		double[] lista4Valores = { Math.random(), Math.random(), Math.random(), Math.random() };

		grupo = assertDoesNotThrow(() -> new Grupo4DMejorado(lista4Valores), " Datos correctos excepción no esperada");

		grupo.setValores(LISTA_CUATRO_CEROS);

		assertArrayEquals(LISTA_CUATRO_CEROS, grupo.getValores(), "Lista 4 elementos");

	}

	/**
	 * Comprueba que al modificar los valores del grupo quedan modificados
	 * correctamente. Las comprobaciones se realizan a través de
	 * {@link Grupo4DMejorado#getValores()}
	 * 
	 * @see Grupo4DMejorado#setValores(double[])
	 * @throws Grupo4DException no es espera que salte para este caso
	 */
	@Test
	@DisplayName("Set Valores ← Lista 4 valores")
	void testSetvaloresLista4Valores() throws Grupo4DException {
		Grupo4DMejorado grupo;
		double[] lista4Valores = { Math.random(), Math.random(), Math.random(), Math.random() };

		grupo = assertDoesNotThrow(() -> new Grupo4DMejorado(lista4Valores), " Datos correctos excepción no esperada");

		grupo.setValores(LISTA_CUATRO);

		assertArrayEquals(LISTA_CUATRO, grupo.getValores(), "Lista 4 elementos");

	}

	/**
	 * Verifica que al tratar de modificar el grupo a partir de una lista nula se
	 * lanza la excepción {@link Grupo4DException} y que la misma contiene un texto
	 * descriptivo.
	 * 
	 * @see Grupo4DMejorado#setValores(double[])
	 */
	@Test
	@DisplayName("Excepción setValores ← Lista nula")
	void testExcepciónSetValoresListaNula() {
		Grupo4DMejorado grupo;
		Grupo4DException ex;

		grupo = new Grupo4DMejorado();

		ex = assertThrows(Grupo4DException.class, () -> grupo.setValores(LISTA_NULA),
				"Excepción por lista nula esperada");
		verificarTextoExcepción(ex);

	}

	/**
	 * Verifica que al tratar de modificar el grupo a partir de una lista con solo
	 * tres valores -3 ceros- se lanza la excepción {@link Grupo4DException} y que
	 * la misma contiene un texto descriptivo.
	 * 
	 * @see Grupo4DMejorado#setValores(double[])
	 */
	@Test
	@DisplayName("Excepción setValores ← Lista 3 ceros")
	void testExcepciónSetValoresLista3Ceros() {
		Grupo4DMejorado grupo;
		Grupo4DException ex;

		grupo = new Grupo4DMejorado();

		ex = assertThrows(Grupo4DException.class, () -> grupo.setValores(LISTA_TRES_CEROS),
				"Excepción por lista de tamaño inadecuado esperada");
		verificarTextoExcepción(ex);

	}

	/**
	 * Verifica que al tratar de modificar el grupo a partir de una lista con cinco
	 * valores -5 ceros- se lanza la excepción {@link Grupo4DException} y que la
	 * misma contiene un texto descriptivo.
	 * 
	 * @see Grupo4DMejorado#setValores(double[])
	 */
	@Test
	@DisplayName("Excepción setValores ← Lista 5 ceros")
	void testExcepciónSetValoresLista5Ceros() {
		Grupo4DMejorado grupo;
		Grupo4DException ex;

		grupo = new Grupo4DMejorado();

		ex = assertThrows(Grupo4DException.class, () -> grupo.setValores(LISTA_CINCO_CEROS),
				"Excepción por lista de tamaño inadecuado esperada");
		verificarTextoExcepción(ex);

	}

	/**
	 * Verifica que al tratar de modificar el grupo a partir de una lista con solo
	 * tres valores se lanza la excepción {@link Grupo4DException} y que la misma
	 * contiene un texto descriptivo.
	 * 
	 * @see Grupo4DMejorado#setValores(double[])
	 */
	@Test
	@DisplayName("Excepción setValores ← Lista 3 valores")
	void testExcepciónSetValoresLista3Valores() {
		Grupo4DMejorado grupo;
		Grupo4DException ex;

		grupo = new Grupo4DMejorado();

		ex = assertThrows(Grupo4DException.class, () -> grupo.setValores(LISTA_TRES),
				"Excepción por lista de tamaño inadecuado esperada");
		verificarTextoExcepción(ex);

	}

	/**
	 * Verifica que al tratar de modificar el grupo a partir de una lista con cinco
	 * valores se lanza la excepción {@link Grupo4DException} y que la misma
	 * contiene un texto descriptivo.
	 * 
	 * @see Grupo4DMejorado#setValores(double[])
	 */
	@Test
	@DisplayName("Excepción setValores ← Lista 5 valores")
	void testExcepciónSetValoresLista5Valores() {
		Grupo4DMejorado grupo;
		Grupo4DException ex;

		grupo = new Grupo4DMejorado();

		ex = assertThrows(Grupo4DException.class, () -> grupo.setValores(LISTA_CINCO),
				"Excepción por lista de tamaño inadecuado esperada");
		verificarTextoExcepción(ex);

	}

	/**
	 * Comprueba que las excepciones contengan texto descriptivo. Comprueba que:
	 * <ul>
	 * <li>No debe ser nulo</li>
	 * <li>No debe estar vacío</li>
	 * <li>La longitud sea al menos de 8 caracteres</li>
	 * </ul>
	 * 
	 * @param ex la excepción a verificar
	 */
	private void verificarTextoExcepción(Throwable ex) {
		String texto;
		texto = ex.getMessage();
		assertNotNull(texto, "No se espera texto nulo");
		assertNotEquals(0, texto.length(), "No se espera texto vacío");
		assertFalse(texto.length() < 8, "Texto sospechosamente corto");
	}

}
