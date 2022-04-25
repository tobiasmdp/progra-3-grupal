package tickets;

import java.util.GregorianCalendar;

import formulario.Formulario;

/**
 * @author mikel
 * la clase ticket es abstracta y es para generar los tickets de empleados y empleadores
 */
/**
 * @author mikel
 *
 */
public abstract class Ticket { 
	private GregorianCalendar fecha;
	private String estado= "Activo";
	protected Formulario formulario;
	/**
	 *<b>Pos:</b> 
	 * @param fecha en el constructor cada vez que se genera un  nuevo ticket, en el parametro fecha, crear siempre un nuevo objeto de Gregorian Calenadar
	 * @param estado a la hora de crear el ticket, el estado esta en activo por defecto.
	 * @param formulario, en el constructor cada vez que se genera un  nuevo ticket, en el parametro formulario, crear siempre un nuevo objeto de Formulario
	 */
	public Ticket(GregorianCalendar fecha,Formulario formulario,String estado) { //contructor en caso de que se requiera crear un ticket que no este activo
		this.fecha = fecha;
		this.formulario=formulario;
		this.estado = estado;
	}
		
	public Ticket(GregorianCalendar fecha,Formulario formulario) {  //inicializa el ticket en activo por default
		this.fecha = fecha;
		this.formulario=formulario;
		this.estado = "Activo";
	}
	
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado de no estar entre los valores 1(activo), 2(suspendido), 3(cancelado),4(finalizado), no se puede ingresar un estado negativo
	 */
	public void setEstado(String estado) {
		if (this.estado.equalsIgnoreCase("Cancelado")) // asi haria que no se cambie a otro si fue cancelado
			this.estado="Cancelado";
		else
			if (this.estado.equalsIgnoreCase("Activo") || this.estado.equalsIgnoreCase("Finalizado")) 
				this.estado=estado;
	}
	public GregorianCalendar getFecha() {
		return fecha;
	}
	
	public Formulario getFormulario() {
		return this.formulario;
	}

	@Override
	public String toString() {
		return "Ticket [formulario=" + formulario + "]";
	}

	
	
	
}