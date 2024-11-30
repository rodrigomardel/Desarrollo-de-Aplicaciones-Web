package jcolonia.daw2023.g4d;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Pruebas sobre la clase {@link Conjunto4D}. Comprobaciones básicas de los
 * valores inicializados en el constructor, consulta, eliminado de elementos,
 * control del número de elementos y capacidad de la lista.
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel@educa.jcyl.es&gt;
 * @version 1.0 (20240206)
 */
class Conjunto4DTest {

	/** Conjunto de un número determinado de elementos. */
	private Conjunto4D conjunto;

	/** Grupo mejorado de 4 números decimales. */
	private Grupo4DMejorado grupo4DMejorado;

	/** Primer valor del Grupo4D Mejorado. */
	private double a;

	/** Segundo valor del Grupo4D Mejorado. */
	private double b;

	/** Tercer valor del Grupo4D Mejorado. */
	private double c;

	/** Cuarto valor del Grupo4D Mejorado. */
	private double d;

	/** Capacidad conjunto */
	int capacidad;

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
		a = .234;
		b = 3.141592;
		c = -28.3;
		d = 0.2e-10;
		capacidad = 6;

		grupo4DMejorado = new Grupo4DMejorado(a, b, c, d);
		conjunto = new Conjunto4D(capacidad);

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
	 * Comprueba que usando el constructor con una lista de elementos de tamaño
	 * adecuado, los grupos quedan inicializados correctamente.
	 * 
	 * @throws Grupo4DException no se espera que salte para este caso
	 * @see Conjunto4D#Conjunto4D(int)
	 */
	@Test
	@DisplayName("Constructor ← Lista Elementos")
	void testConstructorListaElementos() throws Grupo4DException {
		assertEquals(null, conjunto.consultarElemento(0), "Primer elemento");
		assertEquals(null, conjunto.consultarElemento(1), "Primer elemento");
		assertEquals(null, conjunto.consultarElemento(2), "Primer elemento");
		assertEquals(null, conjunto.consultarElemento(3), "Primer elemento");
		assertEquals(null, conjunto.consultarElemento(4), "Primer elemento");
		assertEquals(null, conjunto.consultarElemento(5), "Primer elemento");

	}

	/**
	 * Verifica que usando el constructor con una lista de capacidad 1, lanza la
	 * excepción {@link Grupo4DException} y que la misma contiene un texto
	 * descriptivo.
	 * 
	 * @throws Grupo4DException excepción esperada
	 * @see Conjunto4D#Conjunto4D(int)
	 */
	@Test
	@DisplayName("Excepción Constructor ← Lista Capacidad 1")
	void testExcepciónConstructorListaCapacidad1() throws Grupo4DException {
		Grupo4DException ex;
		int capacidad;

		capacidad = 1;

		ex = assertThrows(Grupo4DException.class, () -> new Conjunto4D(capacidad),
				"Excepción por lista de tamaño inadecuado esperada");
		verificarTextoExcepción(ex);

	}

	/**
	 * Verifica que usando el constructor con una lista de capacidad 16, lanza la
	 * excepción {@link Grupo4DException} y que la misma contiene un texto
	 * descriptivo.
	 * 
	 * @throws Grupo4DException excepción esperada
	 * @see Conjunto4D#Conjunto4D(int)
	 */
	@Test
	@DisplayName("Excepción Constructor ← Lista Capacidad 16")
	void testExcepciónConstructorListaCapacidad16() throws Grupo4DException {
		Grupo4DException ex;
		int capacidad;

		capacidad = 16;

		ex = assertThrows(Grupo4DException.class, () -> new Conjunto4D(capacidad),
				"Excepción por lista de tamaño inadecuado esperada");
		verificarTextoExcepción(ex);

	}

	/**
	 * Comprueba que al consultar un elemento en una posición determinada, se
	 * devuelve dicho elemento.
	 * 
	 * @throws Grupo4DException no se espera excepción para este caso
	 */
	@Test
	@DisplayName("Consultar elemento ← Posición Correcta")
	void testConsultarElemento() throws Grupo4DException {
		int capacidad, posición;

		capacidad = 14;
		posición = 8;

		conjunto = new Conjunto4D(capacidad);

		for (int i = 0; i < capacidad; i++) {
			conjunto.añadirElemento(grupo4DMejorado);
		}

		assertEquals(grupo4DMejorado, conjunto.consultarElemento(posición), "Octavo elemento");

	}

	/**
	 * Verifica que al consultar un elemento de una posición menor que 0,lanza la
	 * excepción {@link Grupo4DException} y que la misma contiene un texto
	 * descriptivo.
	 * 
	 * @see Conjunto4D#consultarElemento(int)
	 */
	@Test
	@DisplayName("Excepción consultar elemento ← Posición menor que 0")
	void testExcepciónConsultarElementoMenor0() {
		Grupo4DException ex;
		int posición;

		posición = -13;

		ex = assertThrows(Grupo4DException.class, () -> conjunto.consultarElemento(posición),
				"Excepción por posición no esperada");
		verificarTextoExcepción(ex);

	}

	/**
	 * Verifica que al consultar una posición mayor que la longitud de la lista,
	 * lanza la excepción {@link Grupo4DException} y que la misma contiene un texto
	 * descriptivo.
	 * 
	 * @see Conjunto4D#consultarElemento(int)
	 */
	@Test
	@DisplayName("Excepción consultar elemento ← Posición mayor longitud lista")
	void testExcepcióinConsultarElementoMayorLongitudLista() {
		Grupo4DException ex;
		int posición, númElementos;

		posición = 7;
		númElementos = 4;

		for (int i = 0; i < númElementos; i++) {
			assertDoesNotThrow(() -> conjunto.añadirElemento(grupo4DMejorado), "Datos correctos excepción no esperada");
		}

		ex = assertThrows(Grupo4DException.class, () -> conjunto.consultarElemento(posición),
				"Excepción por posición no esperada");
		verificarTextoExcepción(ex);

	}

	/**
	 * Comprueba que al eliminar un elemento en una posición determinada, se elimina
	 * dicho elemento.
	 * 
	 * @throws Grupo4DException no se espera excepción para este caso
	 */
	@Test
	@DisplayName("Eliminar elemento ← Posición Eliminada")
	void testEliminarElemento() throws Grupo4DException {
		int capacidad, posiciónEliminada, númElementos;

		capacidad = 6;
		númElementos = 4;
		posiciónEliminada = 2;

		conjunto = new Conjunto4D(capacidad);

		for (int i = 0; i < númElementos; i++) {
			conjunto.añadirElemento(grupo4DMejorado);
		}

		conjunto.eliminarElemento(posiciónEliminada);

		assertEquals(null, conjunto.consultarElemento(posiciónEliminada), "Posición eliminada");
		assertEquals(grupo4DMejorado, conjunto.consultarElemento(0), "Primera posición");
		assertEquals(grupo4DMejorado, conjunto.consultarElemento(1), "Segunda posición");
//		assertEquals(grupo4DMejorado, conjunto.consultarElemento(2), "Tercera posición");

	}

	/**
	 * Verifica que al eliminar un elemento de una posición menor que 0,lanza la
	 * excepción {@link Grupo4DException} y que la misma contiene un texto
	 * descriptivo.
	 * 
	 * @see Conjunto4D#eliminarElemento(int)
	 */
	@Test
	@DisplayName("Excepción eliminar elemento ← Posición menor que 0")
	void testExcepcióinEliminarElementoMenor0() {
		Grupo4DException ex;
		int posición;

		posición = -1;

		ex = assertThrows(Grupo4DException.class, () -> conjunto.eliminarElemento(posición),
				"Excepción por posición no esperada");
		verificarTextoExcepción(ex);

	}

	/**
	 * Verifica que al eliminar un grupo de una posición mayor que el número de
	 * elementos, lanza la excepción {@link Grupo4DException} y que la misma
	 * contiene un texto descriptivo.
	 * 
	 * @see Conjunto4D#eliminarElemento(int)
	 */
	@Test
	@DisplayName("Excepción eliminar elemento ← Posición mayor que número de elementos")
	void testExcepcióinEliminarElementoMayorNúmElementos() {
		Grupo4DException ex;
		int posición, númElementos;

		posición = 5;
		númElementos = 4;

		for (int i = 0; i < númElementos; i++) {
			assertDoesNotThrow(() -> conjunto.añadirElemento(grupo4DMejorado), "Datos correctos excepción no esperada");
		}

		ex = assertThrows(Grupo4DException.class, () -> conjunto.eliminarElemento(posición),
				"Excepción por posición no esperada");
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
