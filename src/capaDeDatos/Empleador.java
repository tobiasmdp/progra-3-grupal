package capaDeDatos;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import capaDeNegocios.Agencia;
import capaDeNegocios.Formulario;
import capaDeNegocios.IMuestraLista;
import capaDeNegocios.IPuntaje;
import capaDeNegocios.Usuario_puntaje;
import comisiones.FactoryPersona;
import comisiones.FactoryRubro;
import comisiones.IPersona;
import comisiones.IRubro;

public class Empleador extends TiposDeUsuarios {
	private String nombre;
	private IPersona tPersona;
	private IRubro rubro;
	private TicketEmpleador ticket;
	private int puntaje;
	
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
	public void setComisionPersona(IPersona tPersona) {
		this.tPersona = tPersona.calcularComisiones();
	}


	public void setComisionRubro(IRubro rubro) {
		this.rubro = rubro;
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
