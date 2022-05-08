package capaDeDatos;

public abstract class Cliente extends TiposDeUsuarios{

	protected Cliente(String nombreUsuario, String password) {
		super(nombreUsuario, password);
		// TODO Auto-generated constructor stub
	}
	
	public abstract boolean elegirUsuario_puntaje(String nombreUsuario);

	public abstract ListaDeAsignacion getListaDeAsignacion();
}
