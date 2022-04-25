package agencia;

public class Usuario_puntaje {
	private Usuario usuario;
	private double puntaje;
	
	public Usuario_puntaje(Usuario usuario, double puntaje) {
		this.usuario = usuario;
		this.puntaje = puntaje;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public double getPuntaje() {
		return puntaje;
	}

	@Override
	public String toString() {
		return "        "  + puntaje +"      " + usuario;
	}
	
	
}
