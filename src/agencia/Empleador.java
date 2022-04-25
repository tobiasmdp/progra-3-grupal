package agencia;

import agencia.Agencia;
import formulario.Formulario;
import tickets.Ticket;
import tickets.TicketEmpleador;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Empleador extends Usuario implements IMuestraLista{
	private String nombre;
	private IPersona tPersona;
	private IRubro rubro;
	private TicketEmpleador ticket;
	
	public Empleador(String nombreUsuario,String contra) {
		super(nombreUsuario,contra);
		Agencia.getInstance().addEmpleador(this);
	}
	
	
	public Empleador(String nombreUsuario,String contra,String nombre, String tPersona, String rubro) {
		super(nombreUsuario,contra);
		Agencia.getInstance().addEmpleador(this);
		this.nombre = nombre;
		this.tPersona = FactoryPersona.getPersona(tPersona);
		this.rubro = FactoryRubro.getRubro(rubro);
		
	}
	
	
	public void nuevoTicket(GregorianCalendar fecha, Formulario formulario, String estado, int cantempleadosbuscados, int pLocacion, int pRemuneracion, int pCargaHoraria,
			int pTipodePuesto, int pExperienciaPrevia, int pRangoEtario, int pEstudiosCursados) {
		this.ticket = new TicketEmpleador(fecha, formulario,estado, cantempleadosbuscados, pLocacion,pRemuneracion, pCargaHoraria,
				pTipodePuesto, pExperienciaPrevia, pRangoEtario, pEstudiosCursados); 
	}

	/*public Empleador registro(String nombreUsuario,String contra,String nombre, IPersona tPersona, IRubro rubro) {//En el caso de validar el logeo
		return new Empleador(nombreUsuario,contra,nombre,tPersona,rubro);
	}
	
	public Empleador registro(String nombreUsuario,String contra) {//En el caso de validar el logeo para que no se repitan los usuarios
		return new Empleador(nombreUsuario,contra);
	}
	*/
	
	public String getNombre() {
		return nombre;
	}
	public IPersona gettPersona() {
		return tPersona;
	}
	public IRubro getRubro() {
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
	public void mostrarLista() {
		int i;
		Usuario_puntaje auxUsuario;
		System.out.println( "Puesto    Puntaje    Empleadores");
		for (i=0;i<this.ticket.getEmpleadosmatcheados().size();i++) {
			auxUsuario=this.ticket.getEmpleadosmatcheados().get(i);
			System.out.println((i+1)+":"+auxUsuario);//FOR EACH
		}
	}
	
	@Override
	public String toString() {
		return "Empleador [nombre=" + nombre + ", tPersona=" + tPersona + ", rubro=" + rubro +"]";
	}

	
	
	
}
