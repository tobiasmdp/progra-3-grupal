package capaDeDatos;

import capaDeNegocios.Agencia;
import excepciones.UsuarioNoEncontradoException;

/**
 * @author tobia
 *
 */
public class EmpleadoPretenso extends Cliente {
	private String nombre, apellido, telefono;
	private TicketEmpleado ticket;
	private int puntaje, edad;
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

	public void elegirUsuario_puntaje(String nombreUsuario) throws UsuarioNoEncontradoException {
		this.ticket.elegirUsuario_puntaje(nombreUsuario);
	}

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

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public TicketEmpleado getTicket() {
		return ticket;
	}

	@Override
	public String toString() {
		return nombre + "         " + apellido + "         " + edad + "         " + ticket;
	}

}