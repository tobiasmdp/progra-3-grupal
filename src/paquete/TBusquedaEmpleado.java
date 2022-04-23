/**
 * 
 */
package paquete;

import java.util.GregorianCalendar;

/**
 * @author mikel
 *
 */
public class TBusquedaEmpleado extends Ticket {
private int cantempleadosbuscados, cantempleadosobtenidos;
	/**
	 * @param fecha definido en la clase abstracta Ticket
	 * @param formulario definido en la clase abstracta Ticket
	 * @param cantempleadosbuscados aca el empleador debe poner al cantidad de empelados que busca, no tiene que ser menor a 1
	 * canempleadosobtenidos se inicializa en 0 para todos los objetos, porque al recien crear el ticket, todavía no obtuvo ningun empleado
	 */
	public TBusquedaEmpleado(GregorianCalendar fecha,Formulario formulario, int cantempleadosbuscados, int estado) {
		super(fecha,formulario,estado);
		this.cantempleadosbuscados=cantempleadosbuscados;
		this.cantempleadosobtenidos=0;
	}
	public int getCantempleadosbuscados() {
		return cantempleadosbuscados;
	}
	
	public void setCantempleadosbuscados(int cantempleadosbuscados) {
		this.cantempleadosbuscados = cantempleadosbuscados;
	}
	
	public int getCantempleadosobtenidos() {
		return cantempleadosobtenidos;
	}
	
	public void setCantempleadosobtenidos(int cantempleadosobtenidos) {
		this.cantempleadosobtenidos=cantempleadosobtenidos;
	}
	
	/**este metodo se llama cuando los empleados son contratados
	 * @param cantempleadosobtenidos se pasa los empleados obtenidos contratados
	 */
	public void empleadosObtenido(int cantempleadosobtenidos) { //ver bien con el grupo
		this.cantempleadosobtenidos += cantempleadosobtenidos;
		if (this.cantempleadosobtenidos<this.cantempleadosbuscados)
			this.cantempleadosbuscados-=this.cantempleadosobtenidos;
		else {
			this.cantempleadosbuscados=this.cantempleadosobtenidos;
			this.setEstado(4);
		}

	}
	
	

	
}
