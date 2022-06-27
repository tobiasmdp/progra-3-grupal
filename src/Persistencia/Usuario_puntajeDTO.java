package persistencia;

public class Usuario_puntajeDTO {
	private TiposDeUsuariosDTO usuario;
	private double puntaje;
	
	public Usuario_puntajeDTO() {
	}
	
	public TiposDeUsuariosDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(TiposDeUsuariosDTO usuario) {
		this.usuario = usuario;
	}
	public double getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(double puntaje) {
		this.puntaje = puntaje;
	}
	
	
}
