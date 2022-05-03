package capaDeDatos;

import java.util.GregorianCalendar;


public abstract class TiposDeUsuarios  {
	private String nombreUsuario;
	private String password;
	protected boolean logeado;
	
	protected TiposDeUsuarios(String nombreUsuario, String password) {
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.logeado=true;
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

	public void setLogeado(boolean logeado) {
		this.logeado = logeado;
	}
	
	
}
