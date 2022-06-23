package capaDeDatos;



/**
 * <br>
 * Clase que se usa para el manejo de logeo/registros.
 */
public abstract class TiposDeUsuarios  {
	private String nombreUsuario;
	private String password;
	
	public TiposDeUsuarios(String nombreUsuario, String password) {
		this.nombreUsuario = nombreUsuario;
		this.password = password;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public String getPassword() {
		return password;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
