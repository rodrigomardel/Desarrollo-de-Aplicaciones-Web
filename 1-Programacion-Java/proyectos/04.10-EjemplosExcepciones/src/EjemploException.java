
public class EjemploException extends Exception {

	public EjemploException() {
		super ();
	}

	public EjemploException(String message) {
		super(message);
	}

	public EjemploException(Throwable cause) {
		super(cause);
	}

	public EjemploException(String message, Throwable cause) {
		super(message, cause);
	}

	public EjemploException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
