package jcolonia.daw2023.sorteos;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;
import java.util.Vector;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Batería de pruebas fundamentales sobre el bombo para sorteos. Incluye:
 * <ul>
 * <li>Creación y estado inicial.</li>
 * <li>Información del estado del bombo.</li>
 * <li>Control de vaciado.</li>
 * </ul>
 * Son test básicos no superados en la versión inicial mínima.
 * 
 * @see BomboGenérico
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel@educa.jcyl.es&gt;
 * @version 3.1 (20240307)
 */
public final class TestsGeneralesBomboGenérico {
	/** Identificación para sorteo a cara o cruz. */
	private static final String ID_MONEDA = "Cara y cruz – enumeración";
	/** Identificación para sorteo entre alumnos. */
	private static final String ID_CLASE = "Lista alumnos – etiquetas";
	/** Identificación para sorteo de lotería primitiva. */
	private static final String ID_PRIMITIVA = "Primitiva [1..49] – números";
	/** Número de opciones para sorteo de lotería primitiva. */
	private static final int NÚM_BOLAS_PRIMITIVA = 49;

	/**
	 * Resultados del lanzamiento de una moneda al aire: cara y cruz.
	 */
	private enum Moneda {
		/** Anverso de la moneda. */
		CARA,
		/** Reverso de la moneda. */
		CRUZ
	};

	/** Etiquetas para sorteo a cara o cruz. */
	private static final Moneda[] datosMoneda = Moneda.values();
	/** Etiquetas para sorteo entre alumnos. */
	private static final String[] datosClase = { "Andrés", "Beatriz", "Cosme", "Diana", "Evelio", "Flora" };

	/** Bombo con dos elementos, para sorteo a cara o cruz. */
	private BomboGenérico<?> bomboMoneda;
	/** Bombo con varios nombres, para sorteo entre alumnos. */
	private BomboGenérico<?> bomboClase;
	/** Bombo con 49 números, para sorteo de lotería primitiva. */
	private BomboGenérico<?> bomboPrimitiva;

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
	 * 
	 * @throws Exception con datos correctos, no se espera
	 * 
	 * @see #bomboMoneda
	 * @see #bomboClase
	 * @see #bomboPrimitiva
	 */
	@BeforeEach
	void setUp() throws Exception {
		bomboMoneda = BomboGenérico.of(Moneda.class);
		bomboClase = BomboGenérico.of(datosClase);
		bomboPrimitiva = BomboGenérico.of(1, NÚM_BOLAS_PRIMITIVA);
	}

	/** Finalización particular posterior a cada prueba. Sin contenido. */
	@AfterEach
	void tearDown() {
	}

	/**
	 * Verifica que el tamaño inicial informado es el correcto cuando el bombo se
	 * crea por <em>array</em> de etiquetas.
	 * 
	 * @see BomboGenérico#of(Object[])
	 * @see BomboGenérico#getNúmBolas()
	 */
	@Test
	@DisplayName("Tamaños iniciales por array")
	void testTamañosInicialesListaNombres() {
		assertEquals(datosClase.length, bomboClase.getNúmBolas(), ID_CLASE);
	}

	/**
	 * Verifica que el tamaño inicial informado es el correcto cuando el bombo se
	 * crea por rango de números.
	 * 
	 * @see BomboGenérico#of(int, int)
	 * @see BomboGenérico#getNúmBolas()
	 */
	@Test
	@DisplayName("Tamaños iniciales por números")
	void testTamañosInicialesPrimitiva() {
		assertEquals(NÚM_BOLAS_PRIMITIVA, bomboPrimitiva.getNúmBolas(), ID_PRIMITIVA);
	}

	/**
	 * Verifica que el tamaño inicial informado es el correcto cuando el bombo se
	 * crea por enumeración.
	 * 
	 * @see BomboGenérico#of(Class)
	 * @see BomboGenérico#getNúmBolas()
	 */
	@Test
	@DisplayName("Tamaños iniciales por enumeración")
	void testTamañosInicialesMoneda() {
		assertEquals(datosMoneda.length, bomboMoneda.getNúmBolas(), ID_MONEDA);
	}

	/**
	 * Verifica que el tamaño final informado es cero solo tras vaciar el bombo con
	 * nombres. Al tiempo está comprobando que el número de extracciones necesarias
	 * para vaciarlo coincide con el número de elementos iniciales previsto. Este
	 * bombo fue creado con la fábrica para <em>array</em>.
	 * 
	 * @see BomboGenérico#of(Object[])
	 * @see BomboGenérico#getNúmBolas()
	 */
	@Test
	@DisplayName("Tamaños finales por array")
	void testTamañosFinalesListaNombres() {
		var bomboPrueba = bomboClase;
		int númeroTotal = datosClase.length;

		verificarTamañosFinales(bomboPrueba, númeroTotal);
	}

	/**
	 * Verifica que el tamaño final informado es cero solo tras vaciar el bombo para
	 * la lotería primitiva. Al tiempo está comprobando que el número de
	 * extracciones necesarias para vaciarlo coincide con el número de elementos
	 * iniciales previsto. Este bombo fue creado con la fábrica para rangos de
	 * números.
	 * 
	 * @see BomboGenérico#of(int, int)
	 * @see BomboGenérico#getNúmBolas()
	 */
	@Test
	@DisplayName("Tamaños finales por números")
	void testTamañosFinalesPrimitiva() {
		var bomboPrueba = bomboPrimitiva;
		int númeroTotal = NÚM_BOLAS_PRIMITIVA;

		verificarTamañosFinales(bomboPrueba, númeroTotal);
	}

	/**
	 * Verifica que el tamaño final informado es cero solo tras vaciar el bombo para
	 * cara y cruz. Al tiempo está comprobando que el número de extracciones
	 * necesarias para vaciarlo coincide con el número de elementos iniciales
	 * previsto. Este bombo fue creado con la fábrica para enumeraciones.
	 * 
	 * @see BomboGenérico#of(Class)
	 * @see BomboGenérico#getNúmBolas()
	 */
	@Test
	@DisplayName("Tamaños finales por enumeración")
	void testTamañosFinalesMoneda() {
		var bomboPrueba = bomboMoneda;
		int númeroTotal = datosMoneda.length;

		verificarTamañosFinales(bomboPrueba, númeroTotal);
	}
	
	/**
	 * Verifica que vaciando los elementos no se produzcan repeticiones.
	 */
	@Test
	@DisplayName("Comprobar No Repeticiones -moneda- ")
	void testComprobarNoRepeticiones() {
		var bomboPrueba = bomboMoneda;
		int númeroTotal = datosMoneda.length;

		comprobarNoRepeticiones(bomboPrueba, númeroTotal);
	}

	/**
	 * Prueba a extraer todos los elementos previstos y que no se informe de que
	 * está vacío hasta la última extracción.
	 * 
	 * @see BomboGenérico#getNúmBolas()
	 * 
	 * @param bombo  el bombo a probar
	 * @param tamaño el número de elementos inicial
	 */
	private void verificarTamañosFinales(BomboGenérico<?> bombo, int tamaño) {
		for (int i = 0; i < tamaño; i++) {
			assertNotEquals(0, bombo.getNúmBolas(), "Vaciado prematuro en " + i);
			assertDoesNotThrow(() -> bombo.sacarBola(), "Bombo no vacío, excepción improcedente en " + i);
		}
		assertEquals(0, bombo.getNúmBolas(), "Bombo vacío");
	}

	/**
	 * 
	 * @param <T>
	 * @param bombo
	 * @param tamaño
	 */
	private <T> void comprobarNoRepeticiones(BomboGenérico<T> bombo, int tamaño) {
		T bolaActual;

		List<T> anteriores;
		anteriores = new Vector<T>();

		for (int i = 0; i < tamaño; i++) {
			assertNotEquals(0, bombo.getNúmBolas(), "Vaciado prematuro en " + i);
			bolaActual = assertDoesNotThrow(() -> bombo.sacarBola(), "Bombo no vacío, excepción improcedente en " + i);

			assertEquals(-1, anteriores.indexOf(bolaActual), "Bola repetida" + i);

//			for (int j = 1; j < anteriores.size(); j++) {
//				assertNotEquals(bolaActual, anteriores.get(j),
//						String.format("%s repetida en extracciones %d y %d)", bolaActual, j, i));
//			}
			anteriores.add(bolaActual);	
		}
		assertEquals(0, bombo.getNúmBolas(), "Bombo vacío");
	}
}
