package persistencia;

public class ClienteDTO extends TiposDeUsuariosDTO{
	protected int puntaje;

	protected ClienteDTO() {
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
}
