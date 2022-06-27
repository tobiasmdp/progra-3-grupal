package Persistencia;

public class EmpleadoDTO  extends ClienteDTO{
	private String nombre, apellido, telefono;
	private TicketEmpleadoDTO ticket;
	private int edad;
	private double comision;
	
	
	public EmpleadoDTO() {
		super();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public TicketEmpleadoDTO getTicket() {
		return ticket;
	}
	public void setTicket(TicketEmpleadoDTO ticket) {
		this.ticket = ticket;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getComision() {
		return comision;
	}
	public void setComision(double comision) {
		this.comision = comision;
	}
	
	
}
