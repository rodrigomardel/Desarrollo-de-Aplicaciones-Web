package jcolonia.daw2023.g4d;

/**
 * Excepción usada por las clases {@link Conjunto4DTest},
 * {@link Grupo4DMejoradoAzulTest}, {@link Grupo4DMejoradoRojoTest},
 * {@link Grupo4DMejoradoVerdeTest}, {@link Grupo4DTest}
 * 
 * @author Rodrigo Martínez Delgado &lt;rodrigo.mardel@educa.jcyl.es&gt;
 * @version 1.0 (20240201)
 */
public class Grupo4DException extends Exception {

	/**
	 * Versión de serialización, garantizando la compatibilidad.
	 */
	private static final long serialVersionUID = 20240201000L;

	/**
	 * Construye una nueva excepción de {@code Grupo4DException} sin un mensaje de
	 * detalle. La causa no se inicializa, y posteriormente puede inicializarse
	 * llamando a {@link #initCause}.
	 */
	public Grupo4DException() {
	}

	/**
	 * Construye una nueva excepción de {@code Grupo4DException} con el mensaje de
	 * detalle especificado.
	 *
	 * @param message el mensaje de detalle. El mensaje de detalle se guarda para su
	 *                posterior recuperación por el método {@link #getMessage()}.
	 */
	public Grupo4DException(String message) {
		super(message);
	}

	/**
	 * Construye una nueva excepción de {@code Grupo4DException} con la causa
	 * especificada y un mensaje de detalle de
	 * {@code (cause==null ? null : cause.toString())} (que normalmente contiene la
	 * clase y el mensaje de detalle de {@code cause}).
	 *
	 * @param cause la causa (que se guarda para su posterior recuperación por el
	 *              método {@link #getCause()}). (Un valor {@code null} es
	 *              permitido, y significa que la causa es inexistente o
	 *              desconocida.)
	 */
	public Grupo4DException(Throwable cause) {
		super(cause);
	}

	/**
	 * Construye una nueva excepción de {@code Grupo4DException} con el mensaje de
	 * detalle especificado y la causa.
	 *
	 * @param message el mensaje de detalle.
	 * @param cause   la causa (que se guarda para su posterior recuperación por el
	 *                método {@link #getCause()}). (Un valor {@code null} es
	 *                permitido, y significa que la causa es inexistente o
	 *                desconocida.)
	 */
	public Grupo4DException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Construye una nueva excepción de {@code Grupo4DException} con el mensaje de
	 * detalle especificado, la causa, la supresión habilitada o deshabilitada, y la
	 * escriturabilidad de la pila de seguimiento habilitada o deshabilitada.
	 *
	 * @param message            el mensaje de detalle.
	 * @param cause              la causa. (Un valor {@code null} es permitido, y
	 *                           significa que la causa es inexistente o
	 *                           desconocida.)
	 * @param enableSuppression  indica si la supresión está habilitada o
	 *                           deshabilitada
	 * @param writableStackTrace si la pila de seguimiento es writable o no
	 */
	public Grupo4DException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
