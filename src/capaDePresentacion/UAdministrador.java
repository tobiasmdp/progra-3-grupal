package capaDePresentacion;

import capaDeDatos.EmpleadoPretenso;
import capaDeDatos.Empleador;
import capaDeNegocios.Agencia;

/**
 *<b>
 *Clase que representa al administrador desde la capa de presentacion.
 */

public class UAdministrador extends Usuario {
	private State estadoRonda;
	/**
	 * Registra al administrador en el sistema.
	 * @param usuario: nombre de usuario.
	 * @param contrasenia: contrasenia del usuario.
	 */
	
	public UAdministrador(String usuario, String contrasenia) {
		Agencia.getInstance().registroAdministrador(usuario, contrasenia, this);
		this.setEstadoRonda(new EncuentrosLaboralesState(this));
	}
	
	public State getEstadoRonda() {
		return estadoRonda;
	}

	public void setEstadoRonda(State estadoRonda) {
		this.estadoRonda = estadoRonda;
	}
	
	public void setV1(int valor) {
		Agencia.getInstance().setV1(valor);
	}

	public void setV2(int valor) {
		Agencia.getInstance().setV2(valor);
	}
	
	public void gatillarRonda() {
		this.estadoRonda.gatillarRonda();
	}
	
	/**
	 * <b>
	 * Gatilla la ronda de encuentros laborales.
	 * <b>Pre: </b> Se tienen que haber cargado todos los datos necesarios para operar en el sistema.
	 * <b>Post: </b> Se crean las listas de asignacion.
	 */
	
	/*
	 * 
	 * public void rondaEncuentrosLaborales() {
		Agencia.getInstance().rondaEncuentrosLaborales();
	}

	 * */
	/**
	 * <b>
	 * Gatilla la ronda de contrataciones.
	 * <b>Pre: </b> Se tiene que haber gatillado la ronda de encuentros laborales previamente. 
	 * <b>Post: </b> Se crean las contrataciones en caso de coincidencias.
	 */
	/*
	public void rondaContrataciones() {
		Agencia.getInstance().rondaContrataciones();
	}
	
	 * */
	/**
	 * <b>
	 * Setea el vencimiento del Ticket. 
	 */
	
	public void setVencimientoTicket(int valor){
		Agencia.getInstance().setVencimientoTicket(valor);
	}
	
	/**
	 * <b>
	 * Todos los tickets en estado "Cancelado" o "Finalizado", son seteados a null
	 */
	public void limpiarTickets() {
		Agencia.getInstance().limpiarTickets();
	}

	/**
	 * <b>
	 * Muestra todos los empleados.
	 */
	public void mostrarEmpleados() {
		for (EmpleadoPretenso empleado : Agencia.getInstance().getEmpleadosPretensos())
			System.out.println(empleado);
	}
	

	/**
	 * <b>
	 * Muestra todos los empleadores.
	 */
	public void mostrarEmpleadores() {
		for (Empleador empleador : Agencia.getInstance().getEmpleadores())
			System.out.println(empleador);
	}
	
}
