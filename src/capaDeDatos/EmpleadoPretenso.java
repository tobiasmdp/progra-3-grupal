package capaDeDatos;

import capaDeNegocios.Agencia;

/**
 * @author tobia
 *
 */
public class EmpleadoPretenso extends TiposDeUsuarios{
	private String nombre,apellido,telefono;
	protected int edad;
	private TicketEmpleado ticket;
	private int puntaje;
	//private static int codUsuario;
	

	public EmpleadoPretenso(String nombreUsuario, String password, String nombre, String apellido, String telefono,int edad) {
		super(nombreUsuario, password);
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.edad = edad;
		//EmpleadoPretenso.codUsuario++;
		Agencia.getInstance().addEmpleadoPretenso(this);
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
		return nombre  + "         " + apellido + "         " + edad + "         " + ticket;
	}
	

}