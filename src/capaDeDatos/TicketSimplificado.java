package capaDeDatos;

import java.util.Observable;

import capaDePresentacion.UEmpleador;

public class TicketSimplificado extends Observable {
	//tipoTrabajo y locacion
	private String tipoTrabajo; //test
	private String locacion; //test
	private UEmpleador empleadorTicket;
	
	public TicketSimplificado(String tipoTrabajo,String locacion,UEmpleador empleador) {
		this.tipoTrabajo = tipoTrabajo;
		this.locacion = locacion;
		this.empleadorTicket = empleador;
	}

	public String getTipoTrabajo() {
		return tipoTrabajo;
	}

	public String getLocacion() {
		return locacion;
	}

	public UEmpleador getEmpleadorTicket() {
		return empleadorTicket;
	}
}
