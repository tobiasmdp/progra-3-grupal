package agencia;

import java.util.GregorianCalendar;
import excepciones.LoginException;
import formulario.Formulario;
import tickets.*;

/**
 * @author tobia
 *
 */
public class EmpleadoPretenso extends Usuario implements IMuestraLista{
	private String nombre,apellido,telefono;
	private int edad;
	private IPersona tPersona;
	//private TicketEmpleado ticket;
	//private static int codUsuario;
	
	
	private EmpleadoPretenso(String nombreUsuario, String password) {
		super(nombreUsuario, password);
		this.tPersona=FactoryPersona.getPersona("Juridica");
		//EmpleadoPretenso.codUsuario++;
		Agencia.getInstance().addEmpleadoPretenso(this);
	}

	private EmpleadoPretenso(String nombreUsuario, String password, String nombre, String apellido, String telefono,int edad) {
		this(nombreUsuario, password);
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.edad = edad;
		//this.tPersona=FactoryPersona.getPersona("Juridica");
		//EmpleadoPretenso.codUsuario++;
		//Agencia.getInstance().addEmpleadoPretenso(this);
	}
	
	public static EmpleadoPretenso registro(String nombreUsuario, String password, String nombre, String apellido, String telefono,int edad) throws LoginException {
		EmpleadoPretenso empleadoCreado = null;
		if(Usuario.validarRegistro(nombreUsuario, password))
			empleadoCreado = new EmpleadoPretenso(nombreUsuario,password);
		return empleadoCreado;
	}
	
	public static EmpleadoPretenso registro(String nombreUsuario,String password) throws LoginException {//En el caso de validar el logeo para que no se repitan los usuarios
		EmpleadoPretenso empleadoCreado = null;
		if(Usuario.validarRegistro(nombreUsuario, password))
			empleadoCreado = new EmpleadoPretenso(nombreUsuario,password);
		return empleadoCreado;
	}
	/*
	public EmpleadoPretenso registro(String nombreUsuario, String password, String nombre, String apellido, String telefono,int edad) {
		return new EmpleadoPretenso(nombreUsuario,password,nombre,apellido,telefono,edad);
	}
	*/
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

	public void nuevoTicket(Formulario formulario) {
		TicketEmpleado ticketEmpleado = new TicketEmpleado((GregorianCalendar) GregorianCalendar.getInstance(), formulario);
		super.altaTicket(ticketEmpleado);
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
		return (TicketEmpleado) ticket;
	}


	@Override
	public void mostrarLista() {
		System.out.println( "Puesto    Puntaje    Empleadores");
		for (Usuario_puntaje usuarioPuntaje : ((TicketEmpleado)this.ticket).getEmpleadoresmatcheados()) {
			System.out.println(usuarioPuntaje);
		}
		
	}

	@Override
	public String toString() {
		return "nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", edad="
				+ edad + ", tPersona=" + tPersona + ticket;
	}
	

}