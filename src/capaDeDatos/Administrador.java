package capaDeDatos;

import capaDeNegocios.Agencia;

/**
 * <br>
 *Clase que representa al administrador.
 */
public class Administrador extends TiposDeUsuarios{

	public Administrador(String nombreUsuario, String password) {
		super(nombreUsuario, password);
		Agencia.getInstance().addAdministrador(this);
	}

}
