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
import org.junit.jupiter.params.provider.NullAndEmptySource;

/**
 * Batería de pruebas de vaciado sobre el bombo para sorteos. Incluye:
 * <ul>
 * <li>Vaciado del bombo.</li>
 * <li>Información del estado del bombo.</li>
 * </ul>
 * 
 * @see Bombo
 * @author <a href= "mailto:rodrigo.mardel@educa.jcyl.es">Rodrigo Martínez Delgado</a>
 * @version 1.4 (20240209)
 */
public final class TestsVaciadoBombo {
	/** Número de opciones para sorteo de lotería primitiva. */
	private static final int NÚM_BOLAS_PRIMITIVA = 49;

	/** Etiquetas para sorteo entre alumnos. */
	private static final String[] datosClase = { "Ana", "Borja", "Clara", "Dani", "Elúa", "Fran" };

	/** Bombo con varios nombres, para sorteo entre alumnos. */
	private Bombo bomboClase;
	/** Bombo con 49 números, para sorteo de lotería primitiva. */
	private Bombo bomboPrimitiva;

	/** Contador disponible para uso general. */
	private int contador;

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
	 * @throws SorteoException no se espera que salte para este caso
	 * 
	 * @see #bomboClase
	 * @see #bomboPrimitiva
	 */
	@BeforeEach
	void setUp() throws SorteoException {
		bomboClase = new Bombo(datosClase);
		bomboPrimitiva = new Bombo(1, NÚM_BOLAS_PRIMITIVA);
		contador = 0;
	}

	/** Finalización particular posterior a cada prueba. Sin contenido. */
	@AfterEach
	void tearDown() {
	}

	/**
	 * Vacía el bombo de nombres sacando los elementos de uno en uno y comprueba en
	 * cada extracción que:
	 * <ul>
	 * <li>Devuelve un texto, no nulo y no vacío.</li>
	 * <li>La consulta de la bandeja devuelve el mismo texto, al menos en tres
	 * llamadas repetidas.</li>
	 * <li>El número de bolas se reduce en cada extracción hasta llegar a cero en la
	 * última.</li>
	 * </ul>
	 * 
	 * @see Bombo#sacarBola()
	 * @see Bombo#getBandeja()
	 * @see Bombo#getNúmBolas()
	 */
	@Test
	@DisplayName("Sacar bolas -alumnos-")
	@NullAndEmptySource
	void testsacarBolas2() {

		assertEquals(datosClase[0], bomboClase.getBandeja(), contador + "Comprobación");
		assertEquals(datosClase[1], bomboClase.getBandeja(), contador + "Comprobación");
		assertEquals(datosClase[2], bomboClase.getBandeja(), contador + "Comprobación");

	}

	/**
	 * Vacía el bombo de la primitiva sacando los elementos de uno en uno y
	 * comprueba en cada extracción que:
	 * <ul>
	 * <li>Devuelve un texto, no nulo y no vacío.</li>
	 * <li>La consulta de la bandeja devuelve el mismo texto, al menos en tres
	 * llamadas repetidas.</li>
	 * <li>El número de bolas se reduce en cada extracción hasta llegar a cero en la
	 * última.</li>
	 * </ul>
	 * 
	 * @see Bombo#sacarBola()
	 * @see Bombo#getBandeja()
	 * @see Bombo#getNúmBolas()
	 */
	@Test
	@DisplayName("Sacar bolas -primitiva-")
	@NullAndEmptySource
	void testsacarBolas3() {

	}

	/**
	 * -Ejercicio 3- Vacía el bombo de nombres sacando los elementos de uno en uno,
	 * una vez vaciado el bombo comprueba que salta la SorteoRTException.
	 * 
	 * @see Bombo#sacarBola()
	 */
	@Test
	@DisplayName("Excepción sacar bolas -alumnos-")
	void testExcepciónsacarBolas() {
		SorteoRTException ex;

		for (int i = 0; i < datosClase.length; i++) {
			bomboClase.sacarBola();
		}

		ex = assertThrows(SorteoRTException.class, () -> bomboClase.sacarBola(), "Bombo vacío");
		verificarTextoExcepción(ex);

	}

	/**
	 * - Ejercicio 4 - Antes de la primera extracción devuelve null aunque se repita
	 * la llamada a {@link Bombo#getBandeja()}.
	 * 
	 * @see Bombo#getBandeja()
	 */
	@Test
	@DisplayName("Get bandeja(5) -primitiva-")
	void testgetBandeja5() {

		assertEquals(null, bomboPrimitiva.getBandeja(), contador + "Comprobación");
		assertEquals(null, bomboPrimitiva.getBandeja(), contador + "Comprobación");
		assertEquals(null, bomboPrimitiva.getBandeja(), contador + "Comprobación");
		assertEquals(null, bomboPrimitiva.getBandeja(), contador + "Comprobación");
		assertEquals(null, bomboPrimitiva.getBandeja(), contador + "Comprobación");

	}

	/**
	 * - Ejercicio 4 - En una secuencia de extracciones siempre devuelve el valor
	 * extraído, repetición tantas veces como elementos contiene el bombo.
	 * 
	 * 
	 * @see Bombo#getBandeja()
	 * @see Bombo#sacarBola()
	 */
	@Test
	@DisplayName("Sacar Bola Get bandeja -alumnos-")
	void testSacarBolaGetBandeja() {

		for (int i = 0; i < datosClase.length; i++) {
			assertEquals(bomboClase.sacarBola(), bomboClase.getBandeja(), "Extracción" + contador);
		}

	}

	/**
	 * - Ejercicio 5 - Después de extraer un elemento comprueba que ya no se
	 * producen extracciones repetidas, de manera que ese elemento extraído ya no se
	 * pueda repetir.
	 * 
	 * 
	 * @see Bombo#getBandeja()
	 * @see Bombo#sacarBola()
	 */
	@Test
	@DisplayName("Sacar Bola Extracciones no repetidas -primitiva-")
	void testSacarBolaNoRepetición() {
		String[] listaExtraídas;
		String elemento;
		int númExtracciones;
		
		listaExtraídas = new String[49];
		númExtracciones = 0;
		
		while(bomboPrimitiva.getNúmBolas()>0){
			elemento = assertDoesNotThrow(()-> bomboPrimitiva.sacarBola(),"Extracción legal, excepción no esperada");
			
			for(int contador = 0; contador < númExtracciones; contador++ ){
				assertNotEquals(elemento, listaExtraídas[contador], "Extracciones coinciden");		
			}			
			listaExtraídas[númExtracciones] = elemento;
			númExtracciones++;
		}
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

}
