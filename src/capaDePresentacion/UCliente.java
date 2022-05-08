package capaDePresentacion;

import capaDeNegocios.Agencia;
import capaDeNegocios.Usuario_puntaje;
import excepciones.UsuarioNoEncontradoException;


/**
*<b>
*Clase abstracta que comparten tanto UEmpleado como Uempleador.
 */
public abstract class UCliente extends Usuario{
	
	public abstract void cambiarEstadoTicket(String estado);
	
	/**
	 * Elige al usuario pasado por parametro.
	 * <b>Pre: </b> se ejecuta luego de la ronda de contrataciones.
	 * @param nombreUsuario: nombre de usuario elegido.
	 */
	public void elegirUsuario_puntaje(String nombreUsuario) {
        try {
			Agencia.getInstance().elegirUsuario_puntaje(nombreUsuario, this);
		} catch (UsuarioNoEncontradoException e) {
			System.out.println(e.getMessage());
		}
        
    }
	
	public void miPuntaje() {
		Agencia.getInstance().miPuntaje(this);
	}
	
	public void mostrarListaAsignaciones() {
		for(Usuario_puntaje listaDeAsignacion:Agencia.getInstance().getListaDeAsignacion(this).getLista()) {
			System.out.println(listaDeAsignacion);
		}
	}
}
