package agencia;

import java.util.GregorianCalendar;

import agencia.Agencia;
import formulario.Formulario;
import tickets.*;

/**
 * @author tobia
 *
 */
public class EmpleadoPretenso extends Usuario {
	private String nombre,apellido,telefono;
	private int edad;
	private TicketEmpleado ticket;
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

	public void nuevoTicket(GregorianCalendar fecha, Formulario formulario) {
		this.ticket = new TicketEmpleado(fecha, formulario);
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
		return 1;//Este falta el tipopersona
	}

}