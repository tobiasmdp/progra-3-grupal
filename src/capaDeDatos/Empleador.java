package capaDeDatos;


import capaDeNegocios.Agencia;
import comisiones.FactoryPersona;
import comisiones.FactoryRubro;
import comisiones.IPersona;
import comisiones.IRubro;

/**
 * @author mikel
 * los constructores de esta clase ya agregan a los arraylist de empleador de la agencia
 */
public class Empleador extends Cliente {
	private String nombre;
	private IPersona tPersona;
	private IRubro rubro;
	private TicketEmpleador ticket;
	private int puntaje;
	private double comision;
	
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
	
	public boolean elegir(String nombreUsuario) { 
		return this.ticket.elegir(nombreUsuario);
	}
	
	/*public Empleador registro(String nombreUsuario,String contra,String nombre, IPersona tPersona, IRubro rubro) {//En el caso de validar el logeo
		return new Empleador(nombreUsuario,contra,nombre,tPersona,rubro);
	}
	
	public Empleador registro(String nombreUsuario,String contra) {//En el caso de validar el logeo para que no se repitan los usuarios
		return new Empleador(nombreUsuario,contra);
	}
	*/
	
	public void setTicket(TicketEmpleador ticket) {
		this.ticket = ticket;
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

	
	public double getComision() {
		return comision;
	}


	public void setComision(double comision) {
		this.comision = comision;
	}


	public TicketEmpleador getTicket() {
		return ticket;
	}
	
	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	@Override
	public String toString() {
		return  nombre + "       " + tPersona + "         " + rubro + "         " + ticket;
	}

	
	
	
}
