package jcolonia.daw2023.sqlite.países;

/**
 * Excepción usada en la aplicación «Quiniela 1X2». Alerta generalmente de datos
 * incorrectos no válidos.
 * 
 * @version 1.1 (20240502000)
 * @author <a href="mailto:dmartin.jcolonia@gmail.com">David H. Martín</a>
 */
public class NombrePaísException extends Exception {
	/**
	 * Número de serie, asociado a la versión de la clase.
	 */
	private static final long serialVersionUID = 20240529000L;

	/**
	 * Crea una nueva excepción sin ninguna información adicional. No contiene
	 * ningún texto descriptivo.
	 * 
	 * @see Exception#Exception()
	 */
	public NombrePaísException() {
		super();
	}

	/**
	 * Crea una nueva excepción con un texto descriptivo.
	 * 
	 * @param mensaje el texto correspondiente.
	 * @see Exception#Exception(String)
	 */
	public NombrePaísException(String mensaje) {
		super(mensaje);
	}

	/**
	 * Crea una excepción secundaria almacenando otra excepción de referencia –o
	 * cualquier {@link Throwable}. Emplea como texto descriptivo el de la excepción
	 * encapsulada.
	 * 
	 * @param causa la excepción –o {@link Throwable}– correspondiente
	 * @see Exception#Exception(Throwable)
	 */
	public NombrePaísException(Throwable causa) {
		super(causa);
	}

	/**
	 * Crea una excepción secundaria almacenando otra excepción de referencia –o
	 * cualquier {@link Throwable}– y un texto descriptivo personalizado. El texto
	 * descriptivo puede así ser diferente al de la excepción contenida.
	 * 
	 * @param mensaje el texto correspondiente
	 * @param causa   la excepción –o {@link Throwable}– correspondiente
	 * @see Exception#Exception(String, Throwable)
	 */
	public NombrePaísException(String mensaje, Throwable causa) {
		super(mensaje, causa);
	}

	/**
	 * Crea una excepción secundaria almacenando otra excepción de referencia –o
	 * cualquier {@link Throwable}– y un texto descriptivo personalizado; con
	 * posibilidad de habilitar o deshabilitar la supresión o la edición de pila.
	 * 
	 * @param mensaje            el texto descriptivo a incorporar
	 * @param causa              la excepción a incorporar
	 * @param habilitarSupresión si la supresión está habilitada o no
	 * @param trazaPilaEditable  si la edición de pila está habilitada o no
	 * @see Exception#Exception(String, Throwable, boolean, boolean)
	 * @see Throwable#fillInStackTrace()
	 * @see Throwable#addSuppressed(Throwable)
	 */
	public NombrePaísException(String mensaje, Throwable causa, boolean habilitarSupresión,
			boolean trazaPilaEditable) {
		super(mensaje, causa, habilitarSupresión, trazaPilaEditable);
	}
}