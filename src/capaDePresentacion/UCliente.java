package capaDePresentacion;

import capaDeNegocios.Agencia;
import capaDeNegocios.Usuario_puntaje;
import excepciones.UsuarioNoEncontradoException;

public abstract class UCliente extends Usuario{
	
	public void cambiarEstadoTicket(String estado) {
		Agencia.getInstance().cambiarEstadoTicket(estado, this);
	}
	
	public void elegirUsuario_puntaje(String nombreUsuario) {
        try {
			Agencia.getInstance().elegirUsuario_puntaje(nombreUsuario, this);
		} catch (UsuarioNoEncontradoException e) {
			System.out.println(e.getMessage());
		}
        
    }
	
	public void mostrarListaAsignaciones() {
		for(Usuario_puntaje listaDeAsignacion:Agencia.getInstance().getListaDeAsignacion(this).getLista()) {
			System.out.println(listaDeAsignacion);
		}
	}
}
