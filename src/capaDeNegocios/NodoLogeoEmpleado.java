package capaDeNegocios;

import capaDeDatos.EmpleadoPretenso;
import capaDePresentacion.Usuario;

/**
 *<b>
 * Clase nexo entre la capa de presentacion y la capa de datos que se usa en la capa de negocios.
 */
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

