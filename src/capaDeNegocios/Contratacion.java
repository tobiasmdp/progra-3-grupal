package capaDeNegocios;

import capaDeDatos.EmpleadoPretenso;
import capaDeDatos.Empleador;


/**
 *<b>
 *Clase que representa el contrato entre el empleado y empleador. Se usa durante la ronda de contrataciones.
 *<b>Pre: </b> Se tienen que haber gatillado la ronda de encuentros laborales y de elecciones.
 *<b>Post: </b> Se crea esta clase que vincula tanto al empleado como al empleador. (Ambos se eligieron mutuamente)
 */
public class Contratacion {
	private EmpleadoPretenso empleado;
	private Empleador empleador;
	
	public Contratacion(EmpleadoPretenso empleado, Empleador empleador) {
		super();
		this.empleado = empleado;
		this.empleador = empleador;
	}


	public EmpleadoPretenso getEmpleado() {
		return empleado;
	}


	public Empleador getEmpleador() {
		return empleador;
	}


	@Override
	public String toString() {
		return "El empleado " + empleado + ", fue contratado por el empleador " + empleador + ".";
	}
	
	
}
