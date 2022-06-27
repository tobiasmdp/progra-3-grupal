package Persistencia;

public class TiposDeUsuariosDTO {
	private String nombreUsuario;
	private String password;
	
	protected TiposDeUsuariosDTO(){
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
