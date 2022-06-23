package excepciones;

<<<<<<< HEAD
/**
 * Esta excepcion se extiende de Las excepciones de login, y es para cuando la contraseña es incorrecta
 */
=======
>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
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
