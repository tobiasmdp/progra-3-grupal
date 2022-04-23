package paquete;

import java.util.GregorianCalendar;

/**
 * @author mikel
 * la clase ticket es abstracta y es para generar los tickets de empleados y empleadores
 */
public abstract class Ticket { 
	private GregorianCalendar fecha;
	private int estado;
	protected Formulario formulario;
	/**
	 *<b>Pos:</b> 
	 * @param fecha en el constructor cada vez que se genera un  nuevo ticket, en el parametro fecha, crear siempre un nuevo objeto de Gregorian Calenadar
	 * @param estado a la hora de crear el ticket, el estado esta en activo por defecto.
	 * @param formulario, en el constructor cada vez que se genera un  nuevo ticket, en el parametro formulario, crear siempre un nuevo objeto de Formulario
	 */
	public Ticket(GregorianCalendar fecha,Formulario formulario) {
		this.fecha = fecha;
		this.formulario=formulario;
		this.estado = 1;
	}
	public int getEstado() {
		return estado;
	}
	/**
	 * @param estado de no estar entre los valores 1(activo), 2(suspendido), 3(cancelado),4(finalizado) se setea en 3 por defecto(o sea, se pone al ticket como cancelado)
	 */
	public void setEstado(int estado) {
		if (estado >0 && estado <=4)
		  this.estado = estado;
		else
		  this.estado=3;
	}
	public GregorianCalendar getFecha() {
		return fecha;
	}
	
}
