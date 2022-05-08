package capaDeDatos;

import excepciones.UsuarioNoEncontradoException;

public abstract class Cliente extends TiposDeUsuarios{

	protected Cliente(String nombreUsuario, String password) {
		super(nombreUsuario, password);
		// TODO Auto-generated constructor stub
	}
	
	public abstract void elegirUsuario_puntaje(String nombreUsuario) throws UsuarioNoEncontradoException;

	public abstract ListaDeAsignacion getListaDeAsignacion();
}
