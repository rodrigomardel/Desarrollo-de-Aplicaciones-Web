package jcolonia.daw2023.sorteos;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

/**
 * Batería de pruebas fundamentales sobre el bombo para sorteos. Incluye:
 * <ul>
 * <li>Creación y estado inicial.</li>
 * <li>Control de entradas no válidas.</li>
 * <li>Información del estado del bombo.</li>
 * </ul>
 * 
 * @see Bombo
 * @author <a href= "mailto:dmartin.jcolonia@gmail.com">David H. Martín</a>
 * @version 20240207000
 */
public final class TestsGeneralesBombo {
	/** Identificación para sorteo a cara o cruz. */
	private static final String ID_MONEDA = "Cara y cruz";
	/** Identificación para sorteo entre alumnos. */
	private static final String ID_CLASE = "Lista alumnos";
	/** Identificación para sorteo de lotería primitiva. */
	private static final String ID_PRIMITIVA = "Primitiva [1..49]";
	/** Número de opciones para sorteo de lotería primitiva. */
	private static final int NÚM_BOLAS_PRIMITIVA = 49;

	/** Etiquetas para sorteo a cara o cruz. */
	private static final String[] datosMoneda = { "cara", "cruz" };
	/** Etiquetas para sorteo entre alumnos. */
	private static final String[] datosClase = { "Ana", "Borja", "Clara", "Dani", "Elúa", "Fran" };

	/** Bombo con dos elementos, para sorteo a cara o cruz. */
	private Bombo bomboMoneda;
	/** Bombo con varios nombres, para sorteo entre alumnos. */
	private Bombo bomboClase;
	/** Bombo con 49 números, para sorteo de lotería primitiva. */
	private Bombo bomboPrimitiva;

	/** Preparación general previa a la batería de pruebas. Sin contenido. */
	@BeforeAll
	static void setUpBeforeClass() {
	}

	/** Finalización general posterior a la batería de pruebas. Sin contenido. */
	@AfterAll
	static void tearDownAfterClass() {
	}

	/**
	 * Preparación particular previa a cada prueba. Inicializa tres bombos.
	 * @throws SorteoRTException no se espera excepción para este caso
	 * 
	 * @see #bomboMoneda
	 * @see #bomboClase
	 * @see #bomboPrimitiva
	 */
	@BeforeEach
	void setUp() throws SorteoRTException {
		bomboMoneda = new Bombo(datosMoneda);
		bomboClase = new Bombo(datosClase);
		bomboPrimitiva = new Bombo(1, NÚM_BOLAS_PRIMITIVA);
	}

	/** Finalización particular posterior a cada prueba. Sin contenido. */
	@AfterEach
	void tearDown() {
	}

	/**
	 * Comprueba que no se pueda crear un bombo con una lista nula o vacía.
	 * 
	 * @see Bombo#Bombo(String[])
	 * 
	 * @param etiquetas una lista nula o vacía
	 */
	@ParameterizedTest(name = "lista ← {0}")
	@DisplayName("Constructor no recibe lista")
	@NullAndEmptySource
	void testConstructorListaSinEtiquetas(String[] etiquetas) {
		SorteoRTException ex;
		ex = assertThrows(SorteoRTException.class, () -> new Bombo(etiquetas), 
				"Control de lista de entrada deficiente"); // se espera excepción lanzada por el bloque de código "() -> new Bombo(etiquetas)"
		verificarTextoExcepción(ex); // verifica que el texto de la excepción cumpla ciertos requisitos
	}

	/**
	 * Analiza que el texto de la excepción no sea banal. Comprueba que no sea nulo
	 * y que no esté vacío.
	 * 
	 * @param ex la excepción a analizar
	 */
	private void verificarTextoExcepción(Exception ex) {
		String textoExcepción, prefijo;

		textoExcepción = ex.getMessage();
		assertNotNull(textoExcepción, "Excepción sin texto –texto nulo–");
		assertNotEquals(0, textoExcepción.length(), "Excepción sin texto –texto vacío–");

		prefijo = Bombo.class.getName() + '@';
		assertFalse(textoExcepción.startsWith(prefijo), "Coincidencia sospechosa con Object.toString()");
	}

	/**
	 * Verifica que el tamaño inicial informado es el correcto cuando el bombo se
	 * crea por etiquetas.
	 * 
	 * @see Bombo#Bombo(String[])
	 * @see Bombo#getNúmBolas()
	 */
	@Test
	@DisplayName("Tamaños iniciales por etiquetas")
	void testTamañosInicialesLista() {
		assertEquals(datosMoneda.length, bomboMoneda.getNúmBolas(), ID_MONEDA);
		assertEquals(datosClase.length, bomboClase.getNúmBolas(), ID_CLASE);
	}

	/**
	 * Verifica que el tamaño inicial informado es el correcto cuando el bombo se
	 * crea por rango de números.
	 * 
	 * @see Bombo#Bombo(int, int)
	 * @see Bombo#getNúmBolas()
	 */
	@Test
	@DisplayName("Tamaños iniciales por números")
	void testTamañosInicialesNúmeros() {
		assertEquals(NÚM_BOLAS_PRIMITIVA, bomboPrimitiva.getNúmBolas(), ID_PRIMITIVA);
	}

	/**
	 * Verifica que el tamaño final informado es cero tras vaciar el bombo para cara
	 * y cruz.
	 * 
	 * @see Bombo#Bombo(String[])
	 * @see Bombo#getNúmBolas()
	 */
	@Test
	@DisplayName("Tamaños finales –moneda–")
	void testTamañosFinalesMoneda() {
		Bombo bomboPrueba = bomboMoneda;
		int númeroTotal = datosMoneda.length;

		for (int i = 0; i < númeroTotal; i++) {
			assertDoesNotThrow(() -> bomboPrueba.sacarBola(), "Bombo no vacío, excepción improcedente");
		}
		assertEquals(0, bomboPrueba.getNúmBolas(), "Bombo vacío");
	}

	/**
	 * Verifica que el tamaño final informado es cero tras vaciar el bombo con
	 * nombres.
	 * 
	 * @see Bombo#Bombo(String[])
	 * @see Bombo#getNúmBolas()
	 */
	@Test
	@DisplayName("Tamaños finales –alumnos–")
	void testTamañosFinalesListaNombres() {
		Bombo bomboPrueba = bomboClase;
		int númeroTotal = datosClase.length;

		for (int i = 0; i < númeroTotal; i++) {
			assertDoesNotThrow(() -> bomboPrueba.sacarBola(), "Bombo no vacío, excepción improcedente");
		}
		assertEquals(0, bomboPrueba.getNúmBolas(), "Bombo vacío");
	}

	/**
	 * Verifica que el tamaño final informado es cero tras vaciar el bombo para la
	 * lotería primitiva.
	 * 
	 * @see Bombo#Bombo(String[])
	 * @see Bombo#getNúmBolas()
	 */
	@Test
	@DisplayName("Tamaños finales –primitiva–")
	void testTamañosFinalesPrimitiva() {
		Bombo bomboPrueba = bomboPrimitiva;
		int númeroTotal = NÚM_BOLAS_PRIMITIVA;

		for (int i = 0; i < númeroTotal; i++) {
			assertDoesNotThrow(() -> bomboPrueba.sacarBola(), "Bombo no vacío, excepción improcedente");
		}
		assertEquals(0, bomboPrueba.getNúmBolas(), "Bombo vacío");
	}

	/**
	 * Verifica que no se permiten más extracciones tras vaciar el bombo para cara y
	 * cruz.
	 * 
	 * @see Bombo#Bombo(String[])
	 * @see Bombo#sacarBola()
	 */
	@Test
	@DisplayName("Extracción bombo vacío –moneda–")
	void testControlMoneda() {
		Bombo bomboPrueba = bomboMoneda;
		int númeroTotal = datosMoneda.length;

		for (int i = 0; i < númeroTotal; i++) {
			assertDoesNotThrow(() -> bomboPrueba.sacarBola(), "Bombo no vacío, excepción improcedente");
		}
		assertThrows(SorteoRTException.class, () -> bomboPrueba.sacarBola(), "Consulta sobre bombo vacío");
	}

	/**
	 * Verifica que no se permiten más extracciones tras vaciar el bombo con
	 * nombres.
	 * 
	 * @see Bombo#Bombo(String[])
	 * @see Bombo#sacarBola()
	 */
	@Test
	@DisplayName("Extracción bombo vacío –alumnos–")
	void testControlListaNombresVacía() {
		Bombo bomboPrueba = bomboClase;
		int númeroTotal = datosClase.length;

		for (int i = 0; i < númeroTotal; i++) {
			assertDoesNotThrow(() -> bomboPrueba.sacarBola(), "Bombo no vacío, excepción improcedente");
		}
		assertThrows(SorteoRTException.class, () -> bomboPrueba.sacarBola(), "Consulta sobre bombo vacío");
	}

	/**
	 * Verifica que no se permiten más extracciones tras vaciar el bombo para la
	 * lotería primitiva.
	 * 
	 * @see Bombo#Bombo(String[])
	 * @see Bombo#sacarBola()
	 */
	@Test
	@DisplayName("Extracción bombo vacío –primitiva–")
	void testControlPrimitiva() {
		Bombo bomboPrueba = bomboPrimitiva;
		int númeroTotal = NÚM_BOLAS_PRIMITIVA;

		for (int i = 0; i < númeroTotal; i++) {
			assertDoesNotThrow(() -> bomboPrueba.sacarBola(), "Bombo no vacío, excepción improcedente");
		}
		assertThrows(SorteoRTException.class, () -> bomboPrueba.sacarBola(), "Consulta sobre bombo vacío");
	}
}
