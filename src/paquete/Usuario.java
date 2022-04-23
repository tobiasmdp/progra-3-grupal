package paquete;

public abstract class Usuario {
	protected string nombreUsuario;
	protected string contra;

	public Usuario(string nombreUsuario, string contra) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contra = contra;
	}

	public string getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(string nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public string getContra() {
		return contra;
	}

	public void setContra(string contra) {
		this.contra = contra;
	}
	

}
