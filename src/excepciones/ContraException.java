package excepciones;

/**
 * Esta excepcion se extiende de Las excepciones de login, y es para cuando la contraseña es incorrecta
 */
public class ContraException extends LoginException {
	private String contra;
	
	public ContraException(String arg,String contra) {
		super(arg);
		this.contra = contra;
	}

	public String getContra() {
		return contra;
	}
	
}
