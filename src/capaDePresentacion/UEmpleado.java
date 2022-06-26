package capaDePresentacion;

import capaDeDatos.TicketSimplificado;
import capaDeNegocios.Agencia;

/**
 *<b>
 *Clase que representa al empleado pretenso desde la capa de presentacion.
 */
public class UEmpleado extends UCliente{
	
	private int cantBusquedas;
	
	public UEmpleado() {
		this.cantBusquedas = 0;
	}
	
	/**
	 * <b>
	 * Registra al empleado en el sistema.
	 */
	public void registrarse(String nombreUsuario, String contrasenia, String nombre, 
			String apellido, String telefono, int edad) {
		Agencia.getInstance().registroEmpleado(nombreUsuario, contrasenia, nombre, apellido, telefono, edad,this);
	}
	
	/**
	 * <b>
	 * Crea el ticket de busqueda de empleo con todos sus datos.
	 */
	public void crearTicket(String locacion, double remuneracion, String cargaHoraria, String tipoPuesto, 
			int rangoEtario, String experienciaPrevia, String estudiosCursados) {
		Agencia.getInstance().crearTicketEmpleado(locacion, remuneracion, cargaHoraria, tipoPuesto, rangoEtario, experienciaPrevia, estudiosCursados, this);
	}

	/**
	 * <b>
	 *Cambia el estado del ticket del empleado.
	 *Puede ser activo, suspendido, cancelado o finalizado.
	 */
	@Override
	public void cambiarEstadoTicket(String estado) {
		Agencia.getInstance().cambiarEstadoTicket(estado, this);
	}
	
	public void buscarTicketBolsa() {
		if(this.cantBusquedas < 10) {
			/*for (TicketSimplificado ticket : Agencia.getInstance().getBolsaDeTrabajo()) {
				if() { //lo encuentra
					ticket.notifyObservers(this);
				}
			}*/
			this.cantBusquedas++;
		}
	}
	
}
