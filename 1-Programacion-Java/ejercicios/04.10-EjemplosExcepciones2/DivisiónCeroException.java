package jcolonia.daw2023.ut4;

/**
 * Excepción usada por la clases de ejemplo sobre excepciones para informar
 * sobre una división por cero.
 * 
 * @author <a href= "mailto:dmartin.jcolonia@gmail.com">David H. Martín</a>
 * @version 1.0 (20240215)
 *
 */
public class DivisiónCeroException extends Exception {

	/** Identificación de versión de la clase. */
	private static final long serialVersionUID = 20240115000L;

	/**
	 * Crea una nueva excepción sin ningún contenido. No contiene ningún texto
	 * descriptivo.
	 * 
	 * @see Exception#Exception()
	 */
	public DivisiónCeroException() {
		super();
	}

	/**
	 * Crea una nueva excepción con un texto descriptivo.
	 * 
	 * @param mensaje el texto correspondiente.
	 * @see Exception#Exception(String)
	 */
	public DivisiónCeroException(String mensaje) {
		super(mensaje);
	}

	/**
	 * Crea una excepción que contiene otra –o cualquier {@link Throwable}. Emplea
	 * como texto descriptivo el de la excepción encapsulada.
	 * 
	 * @param causa la excepción a incorporar
	 * @see Exception#Exception(Throwable)
	 * 
	 */
	public DivisiónCeroException(Throwable causa) {
		super(causa);
	}

	/**
	 * Crea una excepción que contiene otra –o cualquier {@link Throwable} y un
	 * texto descriptivo personalizado. El texto descriptivo puede así ser diferente
	 * al de la excepción contenida.
	 * 
	 * @param mensaje el texto descriptivo a incorporar
	 * @param causa   la excepción a incorporar
	 * @see Exception#Exception(String, Throwable)
	 */
	public DivisiónCeroException(String mensaje, Throwable causa) {
		super(mensaje, causa);
	}

	/**
	 * Crea una excepción que contiene otra –o cualquier {@link Throwable} y un
	 * texto descriptivo personalizado; con posibilidad de habilitar o deshabilitar
	 * la supresión o la edición de pila.
	 * 
	 * @param mensaje            el texto descriptivo a incorporar
	 * @param causa              la excepción a incorporar
	 * @param habilitarSupresión si la supresión está habilitada o no
	 * @param trazaPilaEditable  si la edición de pila está habilitada o no
	 * @see Exception#Exception(String, Throwable, boolean, boolean)
	 * @see Throwable#fillInStackTrace()
	 * @see Throwable#addSuppressed(Throwable)
	 */
	public DivisiónCeroException(String mensaje, Throwable causa, boolean habilitarSupresión,
			boolean trazaPilaEditable) {
		super(mensaje, causa, habilitarSupresión, trazaPilaEditable);
	}
}
