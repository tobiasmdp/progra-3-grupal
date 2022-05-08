package capaDeDatos;

import excepciones.UsuarioNoEncontradoException;

public abstract class Cliente extends TiposDeUsuarios{
protected int puntaje;
	
	protected Cliente(String nombreUsuario, String password) {
		super(nombreUsuario, password);
		this.puntaje=0;
		// TODO Auto-generated constructor stub
	}
	
	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public abstract void elegirUsuario_puntaje(String nombreUsuario) throws UsuarioNoEncontradoException;

	public abstract ListaDeAsignacion getListaDeAsignacion();
}
