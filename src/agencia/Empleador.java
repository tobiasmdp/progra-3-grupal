package agencia;

import agencia.Agencia;
import dispatch.Formulario;
import tickets.Ticket;
import tickets.TicketEmpleador;

import java.util.GregorianCalendar;

public class Empleador extends Usuario {
	private String nombre;
	private Persona tPersona;
	private Rubro rubro;
	private TicketEmpleador ticket;
	//Implementar peso
	
	public Empleador(String nombreUsuario,String contra) {
		super(nombreUsuario,contra);
		Agencia.getInstance().addEmpleador(this);
	}
	
	
	public Empleador(String nombreUsuario,String contra,String nombre, Persona tPersona, Rubro rubro) {
		super(nombreUsuario,contra);
		Agencia.getInstance().addEmpleador(this);
		this.nombre = nombre;
		this.tPersona = tPersona;
		this.rubro = rubro;
		
	}
	
	
	public void nuevoTicket(GregorianCalendar fecha, Formulario formulario, int cantempleadosbuscados, int estado ) {
		this.ticket = new TicketEmpleador(fecha, formulario, cantempleadosbuscados, estado); //terminar la creacion de un empleador
	}

	public Empleador registro(String nombreUsuario,String contra,String nombre, Persona tPersona, Rubro rubro) {
		return new Empleador(nombreUsuario,contra,nombre,tPersona,rubro);
	}
	
	public Empleador registro(String nombreUsuario,String contra) {
		return new Empleador(nombreUsuario,contra);
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public Persona gettPersona() {
		return tPersona;
	}
	public Rubro getRubro() {
		return rubro;
	}

	
	public TicketEmpleador getTicket() {
		return ticket;
	}


	@Override
	public void actualizarPuntaje() {
		/*
		por cada Ticket finalizado suma 50 puntos
 		por no ser elegido por ningún empleado pretenso resta 20 puntos.
 		por ser primero en la Lista de Empleadores suma 10 puntos por cada una.
		*/
	}

	@Override
	public double calcularComisiones() {
		return tPersona.calcularComisiones(rubro);
	}

}
