package Persistencia;

import capaDeDatos.TicketEmpleador;
import comisiones.IPersona;
import comisiones.IRubro;

public class EmpleadorDTO {
	private String nombre;
	private IPersona tPersona;
	private IRubro rubro;
	//private TicketEmpleador ticket;
	private double comision;
	
	public EmpleadorDTO() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public IPersona gettPersona() {
		return tPersona;
	}

	public void settPersona(IPersona tPersona) {
		this.tPersona = tPersona;
	}

	public IRubro getRubro() {
		return rubro;
	}

	public void setRubro(IRubro rubro) {
		this.rubro = rubro;
	}

//	public TicketEmpleador getTicket() {
//		return ticket;
//	}
//
//	public void setTicket(TicketEmpleador ticket) {
//		this.ticket = ticket;
//	}

	public double getComision() {
		return comision;
	}

	public void setComision(double comision) {
		this.comision = comision;
	}
	
	
}
