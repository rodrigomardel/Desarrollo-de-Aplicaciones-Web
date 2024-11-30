package jcolonia.daw2021.g4d;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

/**
 * Ejemplo de pruebas JUnit con repetición parametrizadas como <em>array</em>.
 * 
 * @see CsvSource
 * @see ArgumentsAccessor
 */
class Grupo4DMejoradoAzulXTest {
	/**
	 * <p>
	 * Comprueba que el constructor almacena correctamente una lista de cuatro
	 * números recuperándolos en una nueva lista. Aunque los cuatro valores
	 * coincidan, anota también como fallo el caso de que ambas listas sean la
	 * misma; esto delata que se puede haber almacenado la propia lista y no los
	 * cuatro número contenidos. Verifica asimismo que no se produzca la excepción
	 * por lista de entrada incorrecta, pues no es el caso de los datos de prueba
	 * incluidos.
	 * </p>
	 * <p>
	 * La prueba se repite con varios lotes de valores incluyendo ceros, valores
	 * negativos, ordenados/desordenados…
	 * </p>
	 * 
	 * @param datos los datos, valores de prueba
	 */
	@DisplayName("constructor[] → [valores]")
	@ParameterizedTest(name = "prueba #{index} con «{arguments}»")
	@CsvSource(textBlock = """
			# A,			B			C			D
			0.0,			0.0,		0.0,		0.0
			1.0,			2.0,		3.0,		4.0
			4.0,			3.0,		2.0,		1.0
			-0.2,			-0.1,		0.0,		0.1
			-1.0,			1.0,		-1.0,		1.0
			3.141592653,	1.e-200,	1.e200,		-2024.
			""")
	void testConstructorValores(ArgumentsAccessor datos) {
		Grupo4DMejorado grupo;
		double[] listaEntrada = { datos.getDouble(0), datos.getDouble(1), datos.getDouble(2), datos.getDouble(3) };

		grupo = assertDoesNotThrow(() -> new Grupo4DMejorado(listaEntrada), "Array legal de tamaño 4");
		assertNotSame(listaEntrada, grupo.getValores(), "Array contenedores sospechosamente coincidentes");
		assertArrayEquals(listaEntrada, grupo.getValores(), "Los valores recuperados no coinciden");
	}

	/**
	 * <p>
	 * Comprueba que el constructor detecta adecuadamente listas de números nulas y
	 * de tamaño incorrecto -se requieren exactamente 4 valores- lanzando la
	 * oportuna excepción por lista de entrada incorrecta.
	 * </p>
	 * <p>
	 * La prueba se repite con varios lotes de valores para producir listas nulas y
	 * de diversos tamaños incorrectos…
	 * </p>
	 * 
	 * @param datos los datos, valores de prueba
	 */
	@DisplayName("constructor[] → excepción")
	@ParameterizedTest(name = "prueba #{index} con «{arguments}»")
	@NullSource
	@CsvSource(textBlock = """
			# A,			B			C			D
			''
			0.0
			1.0,			2.0,		3.0
			4.0,			3.0,		2.0,		1.0,		0.0
			""")
	void testConstructorExcepción(ArgumentsAccessor datos) {
		double[] listaEntrada;
		int tamaño;
		Exception ex;

		if (Objects.isNull(datos.get(0))) { // …para NullSource
			listaEntrada = null;
		} else if (datos.getString(0).length() == 0) { // …para ''
			listaEntrada = new double[0];
		} else { // …para los array con números
			tamaño = datos.size();
			assertNotEquals(4, tamaño, "Datos de esta prueba requieren tamaño incorrecto");

			listaEntrada = new double[tamaño];
			for (int i = 0; i < tamaño; i++) {
				listaEntrada[i] = datos.getDouble(i);
			}
		}

		ex = assertThrows(Grupo4DException.class, () -> new Grupo4DMejorado(listaEntrada), "Array de tamaño ilegal");
		// verificarTexto(ex);
	}
}
