package capaDePresentacion;

import capaDeNegocios.Agencia;
import capaDeNegocios.Usuario_puntaje;
import excepciones.UsuarioNoEncontradoException;

public abstract class UCliente extends Usuario{
	
	public abstract void cambiarEstadoTicket(String estado);
	
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
