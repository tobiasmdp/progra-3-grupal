package capaDeNegocios;

import capaDeDatos.EmpleadoPretenso;
import capaDeDatos.Empleador;

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
