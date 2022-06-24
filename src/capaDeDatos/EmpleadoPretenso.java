package capaDeDatos;

import excepciones.UsuarioNoEncontradoException;

/**
 *<br>
 *Clase que representa al empleado pretenso con todos sus atributos.
 */
public class EmpleadoPretenso extends Cliente{
	private String nombre, apellido, telefono;
	private TicketEmpleado ticket;
	private int edad;
	private double comision;
	// private static int codUsuario;
	
	public EmpleadoPretenso(String nombreUsuario, String contra) {
		super(nombreUsuario, contra);
	}

	public EmpleadoPretenso(String nombreUsuario, String password, String nombre, String apellido, String telefono,
			int edad) {
		super(nombreUsuario, password);
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.edad = edad;
		// EmpleadoPretenso.codUsuario++;
	}
	
	/**
	 *Elige al empleador con nombre de usuario pasado por parametro.
	 *<b>Pre:</b> Se usa este metodo luego de visualizar la lista de asignacion.<br>
	 *<b>Post:</b> En el arrayList del ticket de este empleado pretenso se agrega, si existe, el empleador con el nombre de usuario del parametro.  
	 *@param nombreUsuario: nombre de usuario del empleador elegido.
	 */
	public void elegirUsuario_puntaje(String nombreUsuario) throws UsuarioNoEncontradoException {
		this.ticket.elegirUsuario_puntaje(nombreUsuario);
	}
	
	/**
	 *Devuelve la lista de asignacion del empleado pretenso con todos los empleadores y sus respectivos puntajes.
	 *<b>Pre:</b> Se usa este metodo luego de realizar la ronda de contratacion.<br>
	 */
	public ListaDeAsignacion getListaDeAsignacion() {
		ListaDeAsignacion listaDeAsignacion = null;
		listaDeAsignacion = this.getTicket().getListaAsignacion();
		return listaDeAsignacion;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public int getEdad() {
		return edad;
	}

	public double getComision() {
		return comision;
	}

	public void setComision(double comision) {
		this.comision = comision;
	}

	public void setTicket(TicketEmpleado ticket) {
		this.ticket = ticket;
	}

	public TicketEmpleado getTicket() {
		return ticket;
	}

	@Override
	public String toString() {
		return nombre + "         " + apellido + "         " + edad + "         " + ticket;
	}
	
	
	
	


}