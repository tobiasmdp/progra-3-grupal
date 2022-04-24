package paquete;

import java.util.ArrayList;
import java.util.GregorianCalendar;

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
	private int estado;
	protected Formulario formulario;
	ArrayList<Empleado> empleadosmatcheados= new ArrayList<Empleado>();
	/**
	 *<b>Pos:</b> 
	 * @param fecha en el constructor cada vez que se genera un  nuevo ticket, en el parametro fecha, crear siempre un nuevo objeto de Gregorian Calenadar
	 * @param estado a la hora de crear el ticket, el estado esta en activo por defecto.
	 * @param formulario, en el constructor cada vez que se genera un  nuevo ticket, en el parametro formulario, crear siempre un nuevo objeto de Formulario
	 */
	public Ticket(GregorianCalendar fecha,Formulario formulario,int estado) {
		this.fecha = fecha;
		this.formulario=formulario;
		this.estado = estado;
	}
	public int getEstado() {
		return estado;
	}
	/**
	 * @param estado de no estar entre los valores 1(activo), 2(suspendido), 3(cancelado),4(finalizado), no se puede ingresar un estado negativo
	 */
	public void setEstado(int estado) {
		if (this.estado==3) // asi haria que no se cambie a otro si fue cancelado
			this.estado=3;
		else
			if (estado>0 && estado<=4) 
				this.estado=estado;
	}
	public GregorianCalendar getFecha() {
		return fecha;
	}
	
	public void nuevoEmpleadoMatcheado(Empleado empleadomatcheado) {
		this.empleadosmatcheados.add(empleadomatcheado);
	}
	
	/**
	 * se usa para resetar la lista en el proximo llamado de matcheos
	 */
	public void resetListaEmpleados() {
		this.empleadosmatcheados.clear();
	}
	
	public Formulario getFormulario() {
		return this.formulario;
	}
	
}
