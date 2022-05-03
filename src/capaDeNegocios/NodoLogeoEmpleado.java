package capaDeNegocios;

import capaDeDatos.EmpleadoPretenso;
import capaDeDatos.TiposDeUsuarios;

public class NodoLogeoEmpleado {
	private TiposDeUsuarios usuario;
	private EmpleadoPretenso empleado;
		
	
	
	
	public NodoLogeoEmpleado(TiposDeUsuarios usuario, EmpleadoPretenso empleado) {
		super();
		this.usuario = usuario;
		this.empleado = empleado;
	}
	
	public TiposDeUsuarios getUsuario() {
		return usuario;
	}
	public EmpleadoPretenso getEmpleado() {
		return empleado;
	}
		
		
		
		
}
