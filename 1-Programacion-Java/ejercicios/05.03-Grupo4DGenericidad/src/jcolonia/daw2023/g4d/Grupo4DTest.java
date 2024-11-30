package jcolonia.daw2023.g4d;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Pruebas sobre la clase {@link Grupo4D}. Primer ejemplo de prueba con JUnit.
 * Comprobaciones básicas de los valores inicializados en el constructor
 * predeterminado, constructor con valores, modificaciones y consulta de esos
 * valores.
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel@educa.jcyl.es&gt;
 * @version 1.0 (20240130)
 */

class Grupo4DTest {

	/** Cuarto conjunto de cuatro números decimales. */
	private Grupo4D grupo4;

	/** Primer valor del cuarto conjunto. */
	private double a;

	/** Segundo valor del cuarto conjunto. */
	private double b;

	/** Tercer valor del cuarto conjunto. */
	private double c;

	/** Cuarto valor del cuarto conjunto. */
	private double d;

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

		grupo4 = new Grupo4D(a, b, c, d);

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
	 * de {@link Grupo4D#getA()}, {@link Grupo4D#getB()}, {@link Grupo4D#getC()} y
	 * {@link Grupo4D#getD()}.
	 * 
	 * @see Grupo4D#Grupo4D()
	 */
	@Test
	@DisplayName("Constructor → ceros")
	void testConstructorPredeterminado() {
		Grupo4D grupo0;

		grupo0 = new Grupo4D();

		assertEquals(0.0, grupo0.getA(), "primer valor");
		assertEquals(0.0, grupo0.getB(), "segundo valor");
		assertEquals(0.0, grupo0.getC(), "tercer valor");
		assertEquals(0.0, grupo0.getD(), "cuarto valor");

	}

	/**
	 * Verifica que usando el constructor con los cuatro valores deseados, los
	 * cuatro valores quedan inicializados correctamente. Las comprobaciones se
	 * realizan a través de {@link Grupo4D#getA()}, {@link Grupo4D#getB()},
	 * {@link Grupo4D#getC()} y {@link Grupo4D#getD()}.
	 * 
	 * @see Grupo4D#Grupo4D(double, double, double, double)
	 */
	@Test
	@DisplayName("Constructor → 4 valores")
	void testConstructorConValores() {

		assertEquals(a, grupo4.getA(), "primer valor");
		assertEquals(b, grupo4.getB(), "segundo valor");
		assertEquals(c, grupo4.getC(), "tercer valor");
		assertEquals(d, grupo4.getD(), "cuarto valor");

	}

	/**
	 * Verifica que al modificar el primer valor del grupo, se cambia correctamente
	 * el valor y que los otros tres permanecen inalterados.
	 */
	@Test
	@DisplayName("Get + set A (1)")
	void testSetGetA1() {
		Grupo4D grupo1;
		double a, b, c, d, nuevo;

		a = -10.1544;
		b = 0.4511;
		c = -6888.3;
		d = 0.87e-88;
		nuevo = 0;

		grupo1 = new Grupo4D(a, b, c, d);
		grupo1.setA(nuevo);

		assertEquals(nuevo, grupo1.getA(), "primer valor");
		assertEquals(b, grupo1.getB(), "segundo valor");
		assertEquals(c, grupo1.getC(), "tercer valor");
		assertEquals(d, grupo1.getD(), "cuarto valor");

	}

	/**
	 * Verifica que al modificar el segundo valor del grupo, se cambia correctamente
	 * el valor y que los otros tres permanecen inalterados.
	 */
	@Test
	@DisplayName("Get + set B (1)")
	void testSetGetB1() {
		Grupo4D grupo2;
		double a, b, c, d, nuevo;

		a = -9.516e+29;
		b = 3.65141e+200;
		c = -4.5655e-100;
		d = 1.255e+308;
		nuevo = 1.5655e-22;

		grupo2 = new Grupo4D(a, b, c, d);
		grupo2.setB(nuevo);

		assertEquals(a, grupo2.getA(), "primer valor");
		assertEquals(nuevo, grupo2.getB(), "segundo valor");
		assertEquals(c, grupo2.getC(), "tercer valor");
		assertEquals(d, grupo2.getD(), "cuarto valor");
	}

	/**
	 * Verifica que al modificar el tercer valor del grupo, se cambia correctamente
	 * el valor y que los otros tres permanecen inalterados.
	 */
	@Test
	@DisplayName("Get + set C (1)")
	void testSetGetC1() {
		Grupo4D grupo3;
		double a, b, c, d, nuevo;

		a = 0.56e+1;
		b = -2.151421e+2;
		c = 12.0121e-10;
		d = -1212.15;
		nuevo = -0.2614e-200;

		grupo3 = new Grupo4D(a, b, c, d);
		grupo3.setC(nuevo);

		assertEquals(a, grupo3.getA(), "primer valor");
		assertEquals(b, grupo3.getB(), "segundo valor");
		assertEquals(nuevo, grupo3.getC(), "tercer valor");
		assertEquals(d, grupo3.getD(), "cuarto valor");
	}

	/**
	 * Verifica que al modificar el cuarto valor del grupo, se cambia correctamente
	 * el valor y que los otros tres permanecen inalterados.
	 */
	@Test
	@DisplayName("Get + set D (1)")
	void testSetGetD1() {
		double nuevo;

		nuevo = 5565.545;

		grupo4.setD(nuevo);

		assertEquals(a, grupo4.getA(), "primer valor");
		assertEquals(b, grupo4.getB(), "segundo valor");
		assertEquals(c, grupo4.getC(), "tercer valor");
		assertEquals(nuevo, grupo4.getD(), "cuarto valor");
	}

	/**
	 * Verifica que al consultar el primer valor del grupo se obtiene el valor
	 * correcto en sucesivos intentos -cinco repeticiones-.
	 */
	@Test
	@DisplayName("Get A (5)")
	void testGetA5() {
		Grupo4D grupo1;
		double a, b, c, d;
		int intento;

		a = -10.1544;
		b = 0.4511;
		c = -6888.3;
		d = 0.87e-88;
		intento = 0;

		grupo1 = new Grupo4D(a, b, c, d);

		assertEquals(a, grupo1.getA(), "Lectura" + (++intento));
		assertEquals(a, grupo1.getA(), "Lectura" + (++intento));
		assertEquals(a, grupo1.getA(), "Lectura" + (++intento));
		assertEquals(a, grupo1.getA(), "Lectura" + (++intento));
		assertEquals(a, grupo1.getA(), "Lectura" + (++intento));
	}

	/**
	 * Verifica que al consultar el segundo valor del grupo se obtiene el valor
	 * correcto en sucesivos intentos -cinco repeticiones-.
	 */
	@Test
	@DisplayName("Get B (5)")
	void testGetB5() {
		Grupo4D grupo2;
		double a, b, c, d;
		int intento;

		a = 9.516e+29;
		b = 3.65141e+200;
		c = 4.5655e-100;
		d = 1.255e+308;
		intento = 0;

		grupo2 = new Grupo4D(a, b, c, d);

		assertEquals(b, grupo2.getB(), "Lectura" + (++intento));
		assertEquals(b, grupo2.getB(), "Lectura" + (++intento));
		assertEquals(b, grupo2.getB(), "Lectura" + (++intento));
		assertEquals(b, grupo2.getB(), "Lectura" + (++intento));
		assertEquals(b, grupo2.getB(), "Lectura" + (++intento));
	}

	/**
	 * Verifica que al consultar el tercer valor del grupo se obtiene el valor
	 * correcto en sucesivos intentos -cinco repeticiones-.
	 */
	@Test
	@DisplayName("Get C (5)")
	void testGetC5() {
		Grupo4D grupo3;
		double a, b, c, d;
		int intento;

		a = 0.56e+1;
		b = 2.151421e+2;
		c = 12.0121e-10;
		d = 1212.15;
		intento = 0;

		grupo3 = new Grupo4D(a, b, c, d);

		assertEquals(c, grupo3.getC(), "Lectura" + (++intento));
		assertEquals(c, grupo3.getC(), "Lectura" + (++intento));
		assertEquals(c, grupo3.getC(), "Lectura" + (++intento));
		assertEquals(c, grupo3.getC(), "Lectura" + (++intento));
		assertEquals(c, grupo3.getC(), "Lectura" + (++intento));
	}

	/**
	 * Verifica que al consultar el cuarto valor del grupo se obtiene el valor
	 * correcto en sucesivos intentos -cinco repeticiones-.
	 */
	@Test
	@DisplayName("Get D (5)")
	void testGetD5() {
		int intento;

		intento = 0;

		grupo4 = new Grupo4D(a, b, c, d);

		assertEquals(d, grupo4.getD(), "Lectura" + (++intento));
		assertEquals(d, grupo4.getD(), "Lectura" + (++intento));
		assertEquals(d, grupo4.getD(), "Lectura" + (++intento));
		assertEquals(d, grupo4.getD(), "Lectura" + (++intento));
		assertEquals(d, grupo4.getD(), "Lectura" + (++intento));
	}

	/**
	 * Verifica que, tras modificar el primer valor, al consultar el primer valor
	 * del grupo se obtiene el valor modificado en sucesivos intentos -cinco
	 * repeticiones-.
	 */
	@Test
	@DisplayName("Set (1) y get A (5)")
	void testSetGetA5() {
		double nuevo;
		int intento;

		nuevo = 0;
		intento = 0;

		grupo4.setA(nuevo);

		assertEquals(nuevo, grupo4.getA(), "Lectura" + (++intento));
		assertEquals(nuevo, grupo4.getA(), "Lectura" + (++intento));
		assertEquals(nuevo, grupo4.getA(), "Lectura" + (++intento));
		assertEquals(nuevo, grupo4.getA(), "Lectura" + (++intento));
		assertEquals(nuevo, grupo4.getA(), "Lectura" + (++intento));
	}

	/**
	 * Verifica que, tras modificar el primer valor, al consultar el primer valor
	 * del grupo se obtiene el valor modificado en sucesivos intentos -cinco
	 * repeticiones-.
	 */
	@Test
	@DisplayName("Set (1) y get B (5)")
	void testSetGetB5() {
		double nuevo;
		int intento;

		nuevo = 0;
		intento = 0;

		grupo4.setB(nuevo);

		assertEquals(nuevo, grupo4.getB(), "Lectura" + (++intento));
		assertEquals(nuevo, grupo4.getB(), "Lectura" + (++intento));
		assertEquals(nuevo, grupo4.getB(), "Lectura" + (++intento));
		assertEquals(nuevo, grupo4.getB(), "Lectura" + (++intento));
		assertEquals(nuevo, grupo4.getB(), "Lectura" + (++intento));
	}

	/**
	 * Verifica que, tras modificar el tercer valor, al consultar el tercer valor
	 * del grupo se obtiene el valor modificado en sucesivos intentos -cinco
	 * repeticiones-.
	 */
	@Test
	@DisplayName("Set (1) y get C (5)")
	void testSetGetC5() {
		double nuevo;
		int intento;

		nuevo = 0;
		intento = 0;

		grupo4.setC(nuevo);

		assertEquals(nuevo, grupo4.getC(), "Lectura" + (++intento));
		assertEquals(nuevo, grupo4.getC(), "Lectura" + (++intento));
		assertEquals(nuevo, grupo4.getC(), "Lectura" + (++intento));
		assertEquals(nuevo, grupo4.getC(), "Lectura" + (++intento));
		assertEquals(nuevo, grupo4.getC(), "Lectura" + (++intento));

	}

	/**
	 * Verifica que, tras modificar el cuarto valor, al consultar el cuarto valor
	 * del grupo se obtiene el valor modificado en sucesivos intentos -cinco
	 * repeticiones-.
	 */
	@Test
	@DisplayName("Set (1) y get D (5)")
	void testSetGetD5() {
		double nuevo;
		int intento;

		nuevo = 0;
		intento = 0;

		grupo4.setD(nuevo);

		assertEquals(nuevo, grupo4.getD(), "Lectura" + (++intento));
		assertEquals(nuevo, grupo4.getD(), "Lectura" + (++intento));
		assertEquals(nuevo, grupo4.getD(), "Lectura" + (++intento));
		assertEquals(nuevo, grupo4.getD(), "Lectura" + (++intento));
		assertEquals(nuevo, grupo4.getD(), "Lectura" + (++intento));
	}

	/**
	 * Verifica que, en una secuencia de modificaciones y consultas alternadas sobre
	 * el primer valor el valor obtenido en cada uno es correcto.
	 */
	@Test
	@DisplayName("Set+get A (5)")
	void testSetGetA2() {
		int intento;
		intento = 0;

		for (double i = 0.1e-11; i < 18.0; i += 3.141592) {
			grupo4.setA(i);
			assertEquals(i, grupo4.getA(), "Lectura" + (++intento));
		}

	}

	/**
	 * Verifica que, en una secuencia de modificaciones y consultas alternadas sobre
	 * el segundo valor el valor obtenido en cada uno es correcto.
	 */
	@Test
	@DisplayName("Set+get B (5)")
	void testSetGetB2() {
		int intento;
		intento = 0;

		for (double i = 0.1e-11; i < 18.0; i += 3.141592) {
			grupo4.setB(i);
			assertEquals(i, grupo4.getB(), "Lectura" + (++intento));
		}

	}

	/**
	 * Verifica que, en una secuencia de modificaciones y consultas alternadas sobre
	 * el tercer valor el valor obtenido en cada uno es correcto.
	 */
	@Test
	@DisplayName("Set+get C (5)")
	void testSetGetC2() {
		int intento;
		intento = 0;

		for (double i = 0.1e-11; i < 18.0; i += 3.141592) {
			grupo4.setC(i);
			assertEquals(i, grupo4.getC(), "Lectura" + (++intento));
		}
	}

	/**
	 * Verifica que, en una secuencia de modificaciones y consultas alternadas sobre
	 * el cuarto valor el valor obtenido en cada uno es correcto.
	 */
	@Test
	@DisplayName("Set+get D (5)")
	void testSetGetD2() {
		int intento;
		intento = 0;

		for (double i = 0.1e-11; i < 18.0; i += 3.141592) {
			grupo4.setD(i);
			assertEquals(i, grupo4.getD(), "Lectura" + (++intento));
		}
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

		textoRecibido = grupo4.toString();
		textoProhibido = Grupo4D.class.getName(); // Equivale a → "jcolonia.daw2023.g4d.Grupo4D"

		assertNotNull(textoRecibido, "texto nulo");
		assertNotEquals(0, textoRecibido.length(), "texto nulo");
		assertFalse(textoRecibido.startsWith(textoProhibido), "texto heredado de Object");

	}

}
