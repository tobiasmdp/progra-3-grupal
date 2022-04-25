package agencia;

import excepciones.LoginException;
import formulario.Formulario;
import tickets.Ticket;
import tickets.TicketEmpleador;
import java.util.GregorianCalendar;

public class Empleador extends Usuario implements IMuestraLista{
	private String nombre;
	private IPersona tPersona;
	private IRubro rubro;
	//private TicketEmpleador ticket;
	
	private Empleador(String nombreUsuario,String contra) {
		super(nombreUsuario,contra);
		Agencia.getInstance().addEmpleador(this);
	}
	
	
	private Empleador(String nombreUsuario,String password,String nombre, String tPersona, String rubro) {
		this(nombreUsuario,password);
		//Agencia.getInstance().addEmpleador(this);
		this.nombre = nombre;
		this.tPersona = FactoryPersona.getPersona(tPersona);
		this.rubro = FactoryRubro.getRubro(rubro);
		
	}
	
	public void nuevoTicket(Formulario formulario, String estado, int cantempleadosbuscados, int pLocacion, int pRemuneracion, int pCargaHoraria,
			int pTipodePuesto, int pExperienciaPrevia, int pRangoEtario, int pEstudiosCursados) {
		Ticket ticketNuevo = new TicketEmpleador((GregorianCalendar) GregorianCalendar.getInstance(), formulario,estado, cantempleadosbuscados, pLocacion,pRemuneracion, pCargaHoraria,
				pTipodePuesto, pExperienciaPrevia, pRangoEtario, pEstudiosCursados); 
		super.altaTicket(ticketNuevo);
	}

	public static Empleador registro(String nombreUsuario,String password,String nombre, String tPersona, String rubro) throws LoginException {
		Empleador empleadorCreado = null;
		if(Usuario.validarRegistro(nombreUsuario, password)) //si es valido el registro creado el empleador sino propaga excepcion
			empleadorCreado = new Empleador(nombreUsuario,password,nombre,tPersona,rubro);
		return empleadorCreado;
	}
	
	public static Empleador registro(String nombreUsuario,String password) throws LoginException {//En el caso de validar el logeo para que no se repitan los usuarios
		Empleador empleadorCreado = null;
		if(Usuario.validarRegistro(nombreUsuario, password))
			empleadorCreado = new Empleador(nombreUsuario,password);
		return empleadorCreado;
	}
	
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
		return (TicketEmpleador) this.ticket;
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
		System.out.println( "Puesto    Puntaje    Empleadores");
		for (Usuario_puntaje usuarioPuntaje : ((TicketEmpleador)this.ticket).getEmpleadosmatcheados()) {
			System.out.println(usuarioPuntaje);
		}
	}
	
	@Override
	public String toString() {
		return "Empleador [nombre=" + nombre + ", tPersona=" + tPersona + ", rubro=" + rubro +"]";
	}
	
}
