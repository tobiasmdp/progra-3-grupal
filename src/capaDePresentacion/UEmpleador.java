package capaDePresentacion;

import capaDeNegocios.Agencia;
/**
 *<b>
 *Clase que representa al empleador desde la capa de presentacion.
 */
public class UEmpleador extends UCliente{

	public UEmpleador() {
	}
	
	/**
	 * <b>
	 * Registra al empleador en el sistema.
	 */
	public void registrarse(String usuario, String contrasenia, String nombre, 
			String tPersona, String rubro) {
		Agencia.getInstance().registroEmpleador(usuario, contrasenia, nombre, tPersona, rubro);
	}
	
	/**
	 * <b>
	 * Crea el ticket de busqueda de empleados con todos sus datos y sus pesos.
	 */
	public void crearTicket(String locacion, double remuneracion, String cargaHoraria, String tipoPuesto, 
			int rangoEtario, String experienciaPrevia, String estudiosCursados, int cantEmpleados, int pLocacion,int pRemuneracion,int pCargaHoraria,int pTipodePuesto,int pExperienciaPrevia,int pRangoEtario,int pEstudiosCursados) {
		Agencia.getInstance().crearTicketEmpleador(locacion, remuneracion, cargaHoraria, tipoPuesto, rangoEtario, experienciaPrevia, estudiosCursados,
				cantEmpleados,pLocacion,pRemuneracion, pCargaHoraria, pTipodePuesto, pExperienciaPrevia, pRangoEtario, pEstudiosCursados, this);
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

}
