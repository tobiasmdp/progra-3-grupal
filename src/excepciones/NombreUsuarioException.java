package excepciones;

/**
 * Esta excepcion es cuando el nombre de usuario ingresado es incorrecto y se extiende de las excepcion de login
 *
 */
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
