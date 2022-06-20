package excepciones;

/**
 * Esta excepcion es la excepcion para cuando alguien se logea mal
 */
public class LoginException extends Exception {

	public LoginException(String arg) {
		super(arg);
	}
}
