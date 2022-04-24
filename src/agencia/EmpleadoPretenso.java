package agencia;

import agencia.Agencia;
import paqueteTickets.Ticket;
import paqueteTickets.TicketEmpleado;

public class EmpleadoPretenso extends Usuario {
	private String nombre,apellido,telefono;
	private int edad;
	private TicketEmpleado ticket;
	//private static int codUsuario;
	

	public EmpleadoPretenso(String nombreUsuario, String password, String nombre, String apellido, String telefono,
			int edad) {
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

	@Override
	public void actualizarPuntaje() {
		/*
		por cada Ticket finalizado suma 50 puntos
 		por no ser elegido por ningún empleado pretenso resta 20 puntos.
 		por ser primero en la Lista de Empleadores suma 10 puntos por cada una.
		*/
	}
	public TicketEmpleado getTicket() {
		return ticket;
	}

	@Override
	public double calcularComisiones() {
		return Persona.calcularComisiones(this.rubro);//Este falta el tipopersona
	}

}