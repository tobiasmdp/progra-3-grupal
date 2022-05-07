package capaDeNegocios;

import capaDeDatos.EmpleadoPretenso;
import capaDeDatos.TiposDeUsuarios;
import capaDePresentacion.Usuario;

public class NodoLogeoEmpleado {
	private Usuario usuario;
	private EmpleadoPretenso empleado;
		
	
	
	
	public NodoLogeoEmpleado(Usuario usuario, EmpleadoPretenso empleado) {
		super();
		this.usuario = usuario;
		this.empleado = empleado;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public EmpleadoPretenso getEmpleado() {
		return empleado;
	}
		
		
		
		
}
