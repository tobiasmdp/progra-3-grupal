package paquete;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * @author mikel
 * El ticket busquedaEmpleo se encarga de completar si el resultado de la contratacion fue 	exitoso.
 * La variable resultado va a ser booleana, y recibira un 0 si fue un fracaso o un 1 si fue un exito.
 * Al crearse el ticket todos los resultados van a ser 0 porque todavía no se realizao el matcheo.
 */
 public class TBusquedaEmpleo extends Ticket {
 private int resultado;
 ArrayList<Empleador> empleadoresmatcheados= new ArrayList<Empleador>();
	
 public TBusquedaEmpleo(GregorianCalendar fecha, Formulario formulario,int estado) {
		super(fecha, formulario,estado);
		this.resultado=0;
		// TODO Auto-generated constructor stub
	}
	public int getResultado() {
		return resultado;
	}
	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	
	public void nuevoEmpleadorMatcheado(Empleado empleadormatcheado) {
		this.empleadoresmatcheados.add(empleadormatcheado);
	}
	
	
	/**
	 * se usa para resetar la lista en el proximo llamado de matcheos
	 */
	public void resetListaEmpleados() {
		this.empleadoresmatcheados.clear();
	}
	
	
}
	