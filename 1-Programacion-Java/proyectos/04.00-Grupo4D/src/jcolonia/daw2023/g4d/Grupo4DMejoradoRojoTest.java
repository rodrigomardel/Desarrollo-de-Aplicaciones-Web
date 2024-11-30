/**
 * 
 */
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
 * valores inicializados en el constructor predeterminado, constructor con
 * valores, constructor lista de valores, modificaciones y consulta de esos
 * valores.
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel@educa.jcyl.es&gt;
 * @version 1.0 (20240202)
 */
class Grupo4DMejoradoRojoTest {

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
	 * Verifica que usando el constructor predeterminado sin argumentos, los cuatro
	 * valores quedan inicializados a cero. Las comprobaciones se realizan a través
	 * de {@link Grupo4DMejorado#getValores()}
	 * 
	 * @see Grupo4DMejorado#Grupo4DMejorado()
	 */
	@Test
	@DisplayName("Constructor ← ceros")
	void testConstructorPredeterminado() {
		Grupo4DMejorado grupo0;

		grupo0 = new Grupo4DMejorado();

		double[] listaLeída = grupo0.getValores();

		assertEquals(0., listaLeída[0], "Primer valor");
		assertEquals(0., listaLeída[1], "Segundo valor");
		assertEquals(0., listaLeída[2], "Tercer valor");
		assertEquals(0., listaLeída[3], "Cuarto valor");

	}

	/**
	 * Comprueba que usando el constructor con los cuatro valores deseados, los
	 * cuatro valores quedan inicializados correctamente. Las comprobaciones se
	 * realizan a través de {@link Grupo4DMejorado#getValores()}
	 * 
	 * @see Grupo4DMejorado#Grupo4DMejorado()
	 */
	@Test
	@DisplayName("Constructor ← 4 valores")
	void testConstructorConValores() {
		Grupo4DMejorado grupo4;
		double a, b, c, d;

		a = -5.44;
		b = 5.33;
		c = -0.1e20;
		d = 9.65;

		grupo4 = new Grupo4DMejorado(a, b, c, d);

		double[] listaLeída = grupo4.getValores();

		assertEquals(a, listaLeída[0], "Primer valor");
		assertEquals(b, listaLeída[1], "Segundo valor");
		assertEquals(c, listaLeída[2], "Tercer valor");
		assertEquals(d, listaLeída[3], "Cuarto valor");

	}

	/**
	 * Comprueba que usando el constructor con la lista de los cuatro valores, los
	 * cuatro valores quedan modificados correctamente. Las comprobaciones se
	 * realizan a través de {@link Grupo4D#getA()}, {@link Grupo4D#getB()},
	 * {@link Grupo4D#getC()} y {@link Grupo4D#getD()}.
	 * 
	 * 
	 * @see Grupo4DMejorado#Grupo4DMejorado(double[])
	 */
	@Test
	@DisplayName("Constructor ← Lista 4 valores")
	void testConstructorLista4Valores() {
		Grupo4DMejorado grupoLista4Valores;

		grupoLista4Valores = assertDoesNotThrow(() -> new Grupo4DMejorado(LISTA_CUATRO),
				"Datos correctos excepción no esperada");

		assertEquals(LISTA_CUATRO[0], grupoLista4Valores.getA(), "Primer valor");
		assertEquals(LISTA_CUATRO[1], grupoLista4Valores.getB(), "Segundo valor");
		assertEquals(LISTA_CUATRO[2], grupoLista4Valores.getC(), "Tercer valor");
		assertEquals(LISTA_CUATRO[3], grupoLista4Valores.getD(), "Cuarto valor");

	}

	/**
	 * Comprueba que usando el constructor con la lista de los cuatro ceros, los
	 * cuatro valores quedan modificados correctamente. Las comprobaciones se
	 * realizan a través de {@link Grupo4D#getA()}, {@link Grupo4D#getB()},
	 * {@link Grupo4D#getC()} y {@link Grupo4D#getD()}.
	 * 
	 * 
	 * @see Grupo4DMejorado#Grupo4DMejorado(double[])
	 */
	@Test
	@DisplayName("Constructor ← Lista 4 ceros")
	void testConstructorLista4Ceros() {
		Grupo4DMejorado grupoLista4Valores;

		grupoLista4Valores = assertDoesNotThrow(() -> new Grupo4DMejorado(LISTA_CUATRO_CEROS),
				"Datos correctos excepción no esperada");

		assertEquals(LISTA_CUATRO_CEROS[0], grupoLista4Valores.getA(), "Primer valor");
		assertEquals(LISTA_CUATRO_CEROS[1], grupoLista4Valores.getB(), "Segundo valor");
		assertEquals(LISTA_CUATRO_CEROS[2], grupoLista4Valores.getC(), "Tercer valor");
		assertEquals(LISTA_CUATRO_CEROS[3], grupoLista4Valores.getD(), "Cuarto valor");

	}

	/**
	 * Verifica que al tratar de modificar una lista nula con el constructor lanza
	 * la excepción {@link Grupo4DException} y que la misma contiene un texto
	 * descriptivo.
	 * 
	 * @throws Grupo4DException excepción esperada
	 * 
	 * @see Grupo4DMejorado#Grupo4DMejorado(double[])
	 */
	@Test
	@DisplayName("Excepción Constructor ← Lista Nula")
	void testExcepciónConstructorListaNula() throws Grupo4DException {
		Grupo4DException ex;

		ex = assertThrows(Grupo4DException.class, () -> new Grupo4DMejorado(LISTA_NULA),
				"Excepción por lista de tamaño inadecuado esperada");
		verificarTextoExcepción(ex);

	}

	/**
	 * Verifica que al tratar de crear una lista de 3 ceros con el constructor lanza
	 * la excepción {@link Grupo4DException} y que la misma contiene un texto
	 * descriptivo.
	 * 
	 * @throws Grupo4DException excepción esperada
	 * 
	 * @see Grupo4DMejorado#Grupo4DMejorado(double[])
	 */
	@Test
	@DisplayName("Excepción Constructor ← Lista 3 Ceros")
	void testExcepciónConstructorLista3Ceros() throws Grupo4DException {
		Grupo4DException ex;

		ex = assertThrows(Grupo4DException.class, () -> new Grupo4DMejorado(LISTA_TRES_CEROS),
				"Excepción por lista de tamaño inadecuado esperada");
		verificarTextoExcepción(ex);

	}

	/**
	 * Verifica que al tratar de crear una lista de 5 ceros con el constructor lanza
	 * la excepción {@link Grupo4DException} y que la misma contiene un texto
	 * descriptivo.
	 * 
	 * @throws Grupo4DException excepción esperada
	 * 
	 * @see Grupo4DMejorado#Grupo4DMejorado(double[])
	 */
	@Test
	@DisplayName("Excepción Constructor ← Lista 5 Ceros")
	void testExcepciónConstructorLista5Ceros() throws Grupo4DException {
		Grupo4DException ex;

		ex = assertThrows(Grupo4DException.class, () -> new Grupo4DMejorado(LISTA_CINCO_CEROS),
				"Excepción por lista de tamaño inadecuado esperada");
		verificarTextoExcepción(ex);

	}

	/**
	 * Verifica que al tratar de crear una lista de 3 valores con el constructor
	 * lanza la excepción {@link Grupo4DException} y que la misma contiene un texto
	 * descriptivo.
	 * 
	 * @throws Grupo4DException excepción esperada
	 * 
	 * @see Grupo4DMejorado#Grupo4DMejorado(double[])
	 */
	@Test
	@DisplayName("Excepción Constructor ← Lista 3 Valores")
	void testExcepciónConstructorLista3Valores() throws Grupo4DException {
		Grupo4DException ex;

		ex = assertThrows(Grupo4DException.class, () -> new Grupo4DMejorado(LISTA_TRES),
				"Excepción por lista de tamaño inadecuado esperada");
		verificarTextoExcepción(ex);

	}

	/**
	 * Verifica que al tratar de crear una lista de 5 valores con el constructor
	 * lanza la excepción {@link Grupo4DException} y que la misma contiene un texto
	 * descriptivo.
	 * 
	 * @throws Grupo4DException excepción esperada
	 * 
	 * @see Grupo4DMejorado#Grupo4DMejorado(double[])
	 */
	@Test
	@DisplayName("Excepción Constructor ← Lista 5 Valores")
	void testExcepciónConstructorLista5Valores() throws Grupo4DException {
		Grupo4DException ex;

		ex = assertThrows(Grupo4DException.class, () -> new Grupo4DMejorado(LISTA_CINCO),
				"Excepción por lista de tamaño inadecuado esperada");
		verificarTextoExcepción(ex);

	}

	/**
	 * Comprueba que al modificar el primer valor del grupo, se cambia correctamente
	 * el valor y que los otros tres permanecen inalterados.
	 */
	@Test
	@DisplayName("Set A + Get Valores")
	void testSetAGetvalores() {
		Grupo4DMejorado grupoLista4Valores;
		double nuevo;
		nuevo = Math.PI;

		grupoLista4Valores = assertDoesNotThrow(() -> new Grupo4DMejorado(LISTA_CUATRO),
				"Datos correctos excepción no esperada");

		grupoLista4Valores.setA(nuevo);

		double[] listaLeída = grupoLista4Valores.getValores();

		assertNotNull(listaLeída);
		assertEquals(4, listaLeída.length);

		assertEquals(nuevo, listaLeída[0], "Primer valor");
		assertEquals(LISTA_CUATRO[1], listaLeída[1], "Segundo valor");
		assertEquals(LISTA_CUATRO[2], listaLeída[2], "Tercer valor");
		assertEquals(LISTA_CUATRO[3], listaLeída[3], "Cuarto valor");

	}

	/**
	 * Comprueba que al modificar el segundo valor del grupo, se cambia
	 * correctamente el valor y que los otros tres permanecen inalterados.
	 */
	@Test
	@DisplayName("Set B + Get Valores")
	void testSetBGetvalores() {
		Grupo4DMejorado grupoLista4Valores;
		double nuevo;
		nuevo = Math.PI;

		grupoLista4Valores = assertDoesNotThrow(() -> new Grupo4DMejorado(LISTA_CUATRO),
				"Datos correctos excepción no esperada");

		grupoLista4Valores.setB(nuevo);

		double[] listaLeída = grupoLista4Valores.getValores();

		assertNotNull(listaLeída);
		assertEquals(4, listaLeída.length);

		assertEquals(LISTA_CUATRO[0], listaLeída[0], "Primer valor");
		assertEquals(nuevo, listaLeída[1], "Segundo valor");
		assertEquals(LISTA_CUATRO[2], listaLeída[2], "Tercer valor");
		assertEquals(LISTA_CUATRO[3], listaLeída[3], "Cuarto valor");

	}

	/**
	 * Comprueba que al modificar el tercer valor del grupo, se cambia correctamente
	 * el valor y que los otros tres permanecen inalterados.
	 */
	@Test
	@DisplayName("Set C + Get Valores")
	void testSetCGetvalores() {
		Grupo4DMejorado grupoLista4Valores;
		double nuevo;
		nuevo = Math.PI;

		grupoLista4Valores = assertDoesNotThrow(() -> new Grupo4DMejorado(LISTA_CUATRO),
				"Datos correctos excepción no esperada");

		grupoLista4Valores.setC(nuevo);

		double[] listaLeída = grupoLista4Valores.getValores();

		assertNotNull(listaLeída);
		assertEquals(4, listaLeída.length);

		assertEquals(LISTA_CUATRO[0], listaLeída[0], "Primer valor");
		assertEquals(LISTA_CUATRO[1], listaLeída[1], "Segundo valor");
		assertEquals(nuevo, listaLeída[2], "Tercer valor");
		assertEquals(LISTA_CUATRO[3], listaLeída[3], "Cuarto valor");

	}

	/**
	 * Comprueba que al modificar el cuarto valor del grupo, se cambia correctamente
	 * el valor y que los otros tres permanecen inalterados.
	 */
	@Test
	@DisplayName("Set D + Get Valores")
	void testSetDGetvalores() {
		Grupo4DMejorado grupoLista4Valores;
		double nuevo;
		nuevo = Math.PI;

		grupoLista4Valores = assertDoesNotThrow(() -> new Grupo4DMejorado(LISTA_CUATRO),
				"Datos correctos excepción no esperada");

		grupoLista4Valores.setD(nuevo);

		double[] listaLeída = grupoLista4Valores.getValores();

		assertNotNull(listaLeída);
		assertEquals(4, listaLeída.length);

		assertEquals(LISTA_CUATRO[0], listaLeída[0], "Primer valor");
		assertEquals(LISTA_CUATRO[1], listaLeída[1], "Segundo valor");
		assertEquals(LISTA_CUATRO[2], listaLeída[2], "Tercer valor");
		assertEquals(nuevo, listaLeída[3], "Cuarto valor");

	}

	/**
	 * Comprueba que al modificar el primer valor del grupo, se cambia correctamente
	 * el valor y que los otros tres permanecen inalterados.
	 * 
	 * @throws Grupo4DException no se espera que salte para este caso
	 */
	@Test
	@DisplayName("setValores A (1) + Gets")
	void testGetsSetValoresA() throws Grupo4DException {
		Grupo4DMejorado grupo4Valores;
		double a, b, c, d, nuevo;
		a = -10.1544;
		b = 0.4511;
		c = -6888.3;
		d = 0.87e-88;
		nuevo = Math.PI;

		grupo4Valores = new Grupo4DMejorado(a, b, c, d);
		double[] listaValores = new double[4];
		listaValores[0] = nuevo;
		listaValores[1] = b;
		listaValores[2] = c;
		listaValores[3] = d;

		grupo4Valores.setValores(listaValores);

		assertEquals(listaValores[0], grupo4Valores.getA(), "Primer valor");
		assertEquals(listaValores[1], grupo4Valores.getB(), "Segundo valor");
		assertEquals(listaValores[2], grupo4Valores.getC(), "Tercer valor");
		assertEquals(listaValores[3], grupo4Valores.getD(), "Cuarto valor");

	}

	/**
	 * Comprueba que al modificar el segundo valor del grupo, se cambia
	 * correctamente el valor y que los otros tres permanecen inalterados.
	 * 
	 * @throws Grupo4DException no se espera que salte para este caso
	 */
	@Test
	@DisplayName("setValores B (1) + Gets")
	void testGetsSetValoresB() throws Grupo4DException {
		Grupo4DMejorado grupo4Valores;
		double a, b, c, d, nuevo;
		a = -10.1544;
		b = 0.4511;
		c = -6888.3;
		d = 0.87e-88;
		nuevo = Math.PI;

		grupo4Valores = new Grupo4DMejorado(a, b, c, d);
		double[] listaValores = new double[4];
		listaValores[0] = a;
		listaValores[1] = nuevo;
		listaValores[2] = c;
		listaValores[3] = d;

		grupo4Valores.setValores(listaValores);

		assertEquals(listaValores[0], grupo4Valores.getA(), "Primer valor");
		assertEquals(listaValores[1], grupo4Valores.getB(), "Segundo valor");
		assertEquals(listaValores[2], grupo4Valores.getC(), "Tercer valor");
		assertEquals(listaValores[3], grupo4Valores.getD(), "Cuarto valor");

	}

	/**
	 * Comprueba que al modificar el tercer valor del grupo, se cambia correctamente
	 * el valor y que los otros tres permanecen inalterados.
	 * 
	 * @throws Grupo4DException no se espera que salte para este caso
	 */
	@Test
	@DisplayName("setValores C (1) + Gets")
	void testGetsSetValoresC() throws Grupo4DException {
		Grupo4DMejorado grupo4Valores;
		double a, b, c, d, nuevo;
		a = -10.1544;
		b = 0.4511;
		c = -6888.3;
		d = 0.87e-88;
		nuevo = Math.PI;

		grupo4Valores = new Grupo4DMejorado(a, b, c, d);
		double[] listaValores = new double[4];
		listaValores[0] = a;
		listaValores[1] = b;
		listaValores[2] = nuevo;
		listaValores[3] = d;

		grupo4Valores.setValores(listaValores);

		assertEquals(listaValores[0], grupo4Valores.getA(), "Primer valor");
		assertEquals(listaValores[1], grupo4Valores.getB(), "Segundo valor");
		assertEquals(listaValores[2], grupo4Valores.getC(), "Tercer valor");
		assertEquals(listaValores[3], grupo4Valores.getD(), "Cuarto valor");

	}

	/**
	 * Comprueba que al modificar el cuarto valor del grupo, se cambia correctamente
	 * el valor y que los otros tres permanecen inalterados.
	 * 
	 * @throws Grupo4DException no se espera que salte para este caso
	 */
	@Test
	@DisplayName("setValores D (1) + Gets")
	void testGetsSetValoresD() throws Grupo4DException {
		Grupo4DMejorado grupo4Valores;
		double a, b, c, d, nuevo;
		a = -10.1544;
		b = 0.4511;
		c = -6888.3;
		d = 0.87e-88;
		nuevo = Math.PI;

		grupo4Valores = new Grupo4DMejorado(a, b, c, d);
		double[] listaValores = new double[4];
		listaValores[0] = a;
		listaValores[1] = b;
		listaValores[2] = c;
		listaValores[3] = nuevo;

		grupo4Valores.setValores(listaValores);

		assertEquals(listaValores[0], grupo4Valores.getA(), "Primer valor");
		assertEquals(listaValores[1], grupo4Valores.getB(), "Segundo valor");
		assertEquals(listaValores[2], grupo4Valores.getC(), "Tercer valor");
		assertEquals(listaValores[3], grupo4Valores.getD(), "Cuarto valor");

	}

	/**
	 * Comprueba que, tras modificar el primer valor, al consultar el primer valor
	 * del grupo se obtiene el valor modificado en sucesivos intentos -cinco
	 * repeticiones-.
	 *
	 * @throws Grupo4DException no se espera que salte para este caso
	 */
	@Test
	@DisplayName("setValores + GetA (5)")
	void testSetvaloresGetA5() throws Grupo4DException {
		Grupo4DMejorado grupo4Valores;
		double a, b, c, d, nuevo;
		int intento;
		a = -10.1544;
		b = 0.4511;
		c = -6888.3;
		d = 0.87e-88;
		nuevo = Math.PI;
		intento = 0;

		grupo4Valores = new Grupo4DMejorado(a, b, c, d);
		double[] listaValores = new double[4];
		listaValores[0] = nuevo;
		listaValores[1] = b;
		listaValores[2] = c;
		listaValores[3] = d;

		grupo4Valores.setValores(listaValores);

		assertEquals(nuevo, grupo4Valores.getA(), "Lectura" + (++intento));
		assertEquals(nuevo, grupo4Valores.getA(), "Lectura" + (++intento));
		assertEquals(nuevo, grupo4Valores.getA(), "Lectura" + (++intento));
		assertEquals(nuevo, grupo4Valores.getA(), "Lectura" + (++intento));
		assertEquals(nuevo, grupo4Valores.getA(), "Lectura" + (++intento));

	}

	/**
	 * Comprueba que, tras modificar el segundo valor, al consultar el segundo valor
	 * del grupo se obtiene el valor modificado en sucesivos intentos -cinco
	 * repeticiones-.
	 *
	 * @throws Grupo4DException no se espera que salte para este caso
	 */
	@Test
	@DisplayName("setValores + GetB (5)")
	void testSetvaloresGetB5() throws Grupo4DException {
		Grupo4DMejorado grupo4Valores;
		double a, b, c, d, nuevo;
		int intento;
		a = -10.1544;
		b = 0.4511;
		c = -6888.3;
		d = 0.87e-88;
		nuevo = Math.PI;
		intento = 0;

		grupo4Valores = new Grupo4DMejorado(a, b, c, d);
		double[] listaValores = new double[4];
		listaValores[0] = a;
		listaValores[1] = nuevo;
		listaValores[2] = c;
		listaValores[3] = d;

		grupo4Valores.setValores(listaValores);

		assertEquals(nuevo, grupo4Valores.getB(), "Lectura" + (++intento));
		assertEquals(nuevo, grupo4Valores.getB(), "Lectura" + (++intento));
		assertEquals(nuevo, grupo4Valores.getB(), "Lectura" + (++intento));
		assertEquals(nuevo, grupo4Valores.getB(), "Lectura" + (++intento));
		assertEquals(nuevo, grupo4Valores.getB(), "Lectura" + (++intento));

	}

	/**
	 * Comprueba que, tras modificar el tercer valor, al consultar el tercer valor
	 * del grupo se obtiene el valor modificado en sucesivos intentos -cinco
	 * repeticiones-.
	 *
	 * @throws Grupo4DException no se espera que salte para este caso
	 */
	@Test
	@DisplayName("setValores + GetC (5)")
	void testSetvaloresGetC5() throws Grupo4DException {
		Grupo4DMejorado grupo4Valores;
		double a, b, c, d, nuevo;
		int intento;
		a = -10.1544;
		b = 0.4511;
		c = -6888.3;
		d = 0.87e-88;
		nuevo = Math.PI;
		intento = 0;

		grupo4Valores = new Grupo4DMejorado(a, b, c, d);
		double[] listaValores = new double[4];
		listaValores[0] = a;
		listaValores[1] = b;
		listaValores[2] = nuevo;
		listaValores[3] = d;

		grupo4Valores.setValores(listaValores);

		assertEquals(nuevo, grupo4Valores.getC(), "Lectura" + (++intento));
		assertEquals(nuevo, grupo4Valores.getC(), "Lectura" + (++intento));
		assertEquals(nuevo, grupo4Valores.getC(), "Lectura" + (++intento));
		assertEquals(nuevo, grupo4Valores.getC(), "Lectura" + (++intento));
		assertEquals(nuevo, grupo4Valores.getC(), "Lectura" + (++intento));

	}

	/**
	 * Comprueba que, tras modificar el cuarto valor, al consultar el cuarto valor
	 * del grupo se obtiene el valor modificado en sucesivos intentos -cinco
	 * repeticiones-.
	 *
	 * @throws Grupo4DException no se espera que salte para este caso
	 */
	@Test
	@DisplayName("setValores + GetD (5)")
	void testSetvaloresGetD5() throws Grupo4DException {
		Grupo4DMejorado grupo4Valores;
		double a, b, c, d, nuevo;
		int intento;
		a = -10.1544;
		b = 0.4511;
		c = -6888.3;
		d = 0.87e-88;
		nuevo = Math.PI;
		intento = 0;

		grupo4Valores = new Grupo4DMejorado(a, b, c, d);
		double[] listaValores = new double[4];
		listaValores[0] = a;
		listaValores[1] = b;
		listaValores[2] = c;
		listaValores[3] = nuevo;

		grupo4Valores.setValores(listaValores);

		assertEquals(nuevo, grupo4Valores.getD(), "Lectura" + (++intento));
		assertEquals(nuevo, grupo4Valores.getD(), "Lectura" + (++intento));
		assertEquals(nuevo, grupo4Valores.getD(), "Lectura" + (++intento));
		assertEquals(nuevo, grupo4Valores.getD(), "Lectura" + (++intento));
		assertEquals(nuevo, grupo4Valores.getD(), "Lectura" + (++intento));

	}

	/**
	 * Verifica que al tratar de modificar los valores usando
	 * {@link Grupo4DMejorado#setValores(double[])} recibiendo una lista nula lanza
	 * la excepción {@link Grupo4DException} y la misma contiene un texto
	 * descriptivo.
	 * 
	 * @throws Grupo4DException excepción esperada
	 * 
	 * @see Grupo4DMejorado#setValores(double[])
	 */
	@Test
	@DisplayName("Excepción setValores ← Lista Nula")
	void testExcepciónSetvaloresListaNula() throws Grupo4DException {
		Grupo4DException ex;
		Grupo4DMejorado grupo;

		grupo = new Grupo4DMejorado();

		ex = assertThrows(Grupo4DException.class, () -> grupo.setValores(LISTA_NULA),
				"Excepción por lista de tamaño inadecuado esperada");
		verificarTextoExcepción(ex);

	}

	/**
	 * Verifica que al tratar de modificar los valores usando
	 * {@link Grupo4DMejorado#setValores(double[])} recibiendo una lista -3 ceros-
	 * lanza la excepción {@link Grupo4DException} y la misma contiene un texto
	 * descriptivo.
	 * 
	 * @throws Grupo4DException excepción esperada
	 * 
	 * @see Grupo4DMejorado#setValores(double[])
	 */
	@Test
	@DisplayName("Excepción setValores ← Lista 3 Ceros")
	void testExcepciónSetvaloresLista3Ceros() throws Grupo4DException {
		Grupo4DException ex;
		Grupo4DMejorado grupo;

		grupo = new Grupo4DMejorado();

		ex = assertThrows(Grupo4DException.class, () -> grupo.setValores(LISTA_TRES_CEROS),
				"Excepción por lista de tamaño inadecuado esperada");
		verificarTextoExcepción(ex);

	}

	/**
	 * Verifica que al tratar de modificar los valores usando
	 * {@link Grupo4DMejorado#setValores(double[])} recibiendo una lista -5 ceros-
	 * lanza la excepción {@link Grupo4DException} y la misma contiene un texto
	 * descriptivo.
	 * 
	 * @throws Grupo4DException excepción esperada
	 * 
	 * @see Grupo4DMejorado#setValores(double[])
	 */
	@Test
	@DisplayName("Excepción setValores ← Lista 5 Ceros")
	void testExcepciónSetvaloresLista5Ceros() throws Grupo4DException {
		Grupo4DException ex;
		Grupo4DMejorado grupo;

		grupo = new Grupo4DMejorado();

		ex = assertThrows(Grupo4DException.class, () -> grupo.setValores(LISTA_CINCO_CEROS),
				"Excepción por lista de tamaño inadecuado esperada");
		verificarTextoExcepción(ex);

	}

	/**
	 * Verifica que al tratar de modificar los valores usando
	 * {@link Grupo4DMejorado#setValores(double[])} recibiendo una lista -3 valores-
	 * lanza la excepción {@link Grupo4DException} y la misma contiene un texto
	 * descriptivo.
	 * 
	 * @throws Grupo4DException excepción esperada
	 * 
	 * @see Grupo4DMejorado#setValores(double[])
	 */
	@Test
	@DisplayName("Excepción setValores ← Lista 3 Valores")
	void testExcepciónSetvaloresLista3Valores() throws Grupo4DException {
		Grupo4DException ex;
		Grupo4DMejorado grupo;

		grupo = new Grupo4DMejorado();

		ex = assertThrows(Grupo4DException.class, () -> grupo.setValores(LISTA_TRES),
				"Excepción por lista de tamaño inadecuado esperada");
		verificarTextoExcepción(ex);

	}

	/**
	 * Verifica que al tratar de modificar los valores usando
	 * {@link Grupo4DMejorado#setValores(double[])} recibiendo una lista -5 valores-
	 * lanza la excepción {@link Grupo4DException} y la misma contiene un texto
	 * descriptivo.
	 * 
	 * @throws Grupo4DException excepción esperada
	 * 
	 * @see Grupo4DMejorado#setValores(double[])
	 */
	@Test
	@DisplayName("Excepción setValores ← Lista 5 Valores")
	void testExcepciónSetvaloresLista5Valores() throws Grupo4DException {
		Grupo4DException ex;
		Grupo4DMejorado grupo;

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

	/**
	 * Verifica que el texto facilitado por {@link Grupo4D#toString()} cumple
	 * ciertos mínimos:
	 * <ul>
	 * <li>No es nulo</li>
	 * <li>No está vacío</li>
	 * <li>No encaja con el valor predeterminado por {@link Object#toString()}</li>
	 * </ul>
	 */
	@Test
	@DisplayName("Método toString → Texto")
	void testToString() {
		String textoProhibido, textoRecibido;
		Grupo4DMejorado grupo4;

		grupo4 = assertDoesNotThrow(() -> new Grupo4DMejorado(LISTA_CUATRO), "Datos correctos excepción no esperada");

		textoRecibido = grupo4.toString();
		textoProhibido = Grupo4D.class.getName(); // Equivale a → "jcolonia.daw2023.g4d.Grupo4D"

		assertNotNull(textoRecibido, "texto nulo");
		assertNotEquals(0, textoRecibido.length(), "texto nulo");
		assertFalse(textoRecibido.startsWith(textoProhibido), "texto heredado de Object");

	}

}
