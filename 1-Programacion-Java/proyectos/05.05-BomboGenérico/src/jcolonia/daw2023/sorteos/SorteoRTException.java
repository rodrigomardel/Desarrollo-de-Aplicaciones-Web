package jcolonia.daw2023.sorteos;

/**
 * Excepción usada por la clase {@link Bombo} cuando los parámetros de creación
 * del mismo no son coherentes o compatibles.
 * 
 * @author <a href= "mailto:rodrigo.mardel@educa.jcyl.es">Rodrigo Martínez Delgado</a>
 * @version 1.4 (20240209)
 */
public class SorteoRTException extends RuntimeException {

	/** Identificación de versión de la clase. */
	private static final long serialVersionUID = 2024020900;

	/**
	 * Crea una nueva excepción sin ningún contenido. No contiene ningún texto
	 * descriptivo.
	 * 
	 * @see Exception#Exception()
	 */
	public SorteoRTException() {
		super();	
	}

	/**
	 * Crea una nueva excepción con un texto descriptivo.
	 * 
	 * @param message el texto correspondiente.
	 */
	public SorteoRTException(String message) {
		super(message);
	}

	/**
	 * Crea una excepción que contiene otra –o cualquier {@link Throwable}. Emplea
	 * como texto descriptivo el de la excepción encapsulada.
	 * 
	 * @param cause la excepción a incorporar
	 * @see Exception#Exception(Throwable)
	 * 
	 */
	public SorteoRTException(Throwable cause) {
		super(cause);
		// TODO Esbozo de constructor generado automáticamente
	}

	/**
	 * Crea una excepción que contiene otra –o cualquier {@link Throwable} y un
	 * texto descriptivo personalizado. El texto descriptivo puede así ser diferente
	 * al de la excepción contenida.
	 * 
	 * @param message el texto descriptivo a incorporar
	 * @param cause   la excepción a incorporar
	 * @see Exception#Exception(String, Throwable)
	 */
	public SorteoRTException(String message, Throwable cause) {
		super(message, cause);
		// TODO Esbozo de constructor generado automáticamente
	}

	/**
	 * Crea una excepción que contiene otra –o cualquier {@link Throwable} y un
	 * texto descriptivo personalizado; con posibilidad de habilitar o deshabilitar
	 * la supresión o la edición de pila.
	 * 
	 * @param message            el texto descriptivo a incorporar
	 * @param cause          	la excepción a incorporar
	 * @param enableSuppression si la supresión está habilitada o no
	 * @param writableStackTrace  si la edición de pila está habilitada o no
	 */
	public SorteoRTException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Esbozo de constructor generado automáticamente
	}

}
