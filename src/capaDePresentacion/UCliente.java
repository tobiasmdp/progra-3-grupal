package capaDePresentacion;

import capaDeNegocios.Agencia;
import capaDeNegocios.Usuario_puntaje;

public abstract class UCliente extends Usuario{
	
	public void cambiarEstadoTicket(String estado) {
		Agencia.getInstance().cambiarEstadoTicket(estado, this);
	}
	
	public boolean elegirUsuario_puntaje(String nombreUsuario) {
        return Agencia.getInstance().elegirUsuario_puntaje(nombreUsuario, this);
    }
	
	public void mostrarListaAsignaciones() {
		for(Usuario_puntaje listaDeAsignacion:Agencia.getInstance().getListaDeAsignacion(this).getLista()) {
			System.out.println(listaDeAsignacion);
		}
	}
}
