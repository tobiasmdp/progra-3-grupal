package agencia;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import agencia.Agencia;
import formulario.Formulario;
import tickets.*;

/**
 * @author tobia
 *
 */
public class EmpleadoPretenso extends Usuario implements IMuestraLista, IPuntaje{
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
	public void mostrarLista() {
		int i;
		Usuario_puntaje auxUsuario; 
		System.out.println( "Puesto    Puntaje    Empleador        Rubro       Tipo Persona   Locacion          Remuneracion               Carga horaria      Tipo de puesto        Experiencia previa    Rango etario        Estudios cursados");
		for (i=0;i<this.ticket.getEmpleadoresmatcheados().size();i++) {
			auxUsuario=this.ticket.getEmpleadoresmatcheados().get(i);
			System.out.println((i+1) +":"+auxUsuario);
		}
		
	}

	@Override
	public String toString() {
		return nombre  + "         " + apellido + "         " + edad + "         " + ticket;
	}
	

}