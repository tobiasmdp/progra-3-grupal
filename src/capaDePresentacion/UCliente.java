package capaDePresentacion;

import capaDeNegocios.Agencia;

public abstract class UCliente extends Usuario{
	
	public void cambiarEstadoTicket(String estado) {
		Agencia.getInstance().cambiarEstadoTicket(estado, this);
	}
	
	public void elegirUsuario_puntaje(String nombreUsuario) {
        Agencia.getInstance().elegir(nombreUsuario, this);
    }
}
