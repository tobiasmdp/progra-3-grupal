package excepciones;

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
