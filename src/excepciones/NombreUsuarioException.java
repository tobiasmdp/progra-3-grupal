package excepciones;

<<<<<<< HEAD
/**
 * Esta excepcion es cuando el nombre de usuario ingresado es incorrecto y se extiende de las excepcion de login
 *
 */
=======
>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
public class NombreUsuarioException extends LoginException {
	private String nombreUsuario;
	
	public NombreUsuarioException(String arg,String nombreUsuario) {
		super(arg);
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}
	
}
