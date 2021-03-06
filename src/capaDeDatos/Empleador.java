package capaDeDatos;

import java.util.ArrayList;

import capaDeNegocios.BolsaDeTrabajo;
import comisiones.FactoryPersona;
import comisiones.FactoryRubro;
import comisiones.TipoPersona;
import comisiones.TipoRubro;
import excepciones.UsuarioNoEncontradoException;

/**
 * <br>
 * Clase que representa al empleador con todos sos atributos.
 */
public class Empleador extends Cliente {
	private String nombre;
	private TipoPersona tPersona;
	private TipoRubro rubro;
	private TicketEmpleador ticket;
	private ArrayList<PuestoTrabajo> mispuestotrabajo=new ArrayList<PuestoTrabajo>();
	private double comision;
	private int cantpuestos=0;
	//parte 2 
	private BolsaDeTrabajo bolsa;
	
	public Empleador(String nombreUsuario,String contra,BolsaDeTrabajo bolsa) {
		super(nombreUsuario,contra);
		this.bolsa=bolsa;
	}
	
	public Empleador(String nombreUsuario,String contra) {
		super(nombreUsuario,contra);;
	}
	
	public Empleador(String nombreUsuario,String contra,String nombre, String tPersona, String rubro) {
		super(nombreUsuario,contra);
		this.nombre = nombre;
		this.tPersona = FactoryPersona.getPersona(tPersona);
		this.rubro = FactoryRubro.getRubro(this.tPersona,rubro);
	}
	
	/**
	 *Elige al empleado con nombre de usuario pasado por parametro.
	 *<b>Pre:</b> Se usa este metodo luego de visualizar la lista de asignacion.<br>
	 *<b>Post:</b> En el arrayList del ticket de este empleador se agrega, si existe, el empleado con el nombre de usuario del parametro.  
	 *@param nombreUsuario: nombre de usuario del empleado elegido.
	 */
	public void elegirUsuario_puntaje(String nombreUsuario) throws UsuarioNoEncontradoException{ 
		 this.ticket.elegirUsuario_puntaje(nombreUsuario);
	}
	
	
	
	/**
	 *Devuelve la lista de asignacion del empleador con todos los empleados y sus respectivos puntajes.
	 *<b>Pre:</b> Se usa este metodo luego de realizar la ronda de contratacion.<br>
	 */
	public ListaDeAsignacion getListaDeAsignacion() {
		ListaDeAsignacion listaDeAsignacion = null;
		listaDeAsignacion = this.getTicket().getListaAsignacion();
		return listaDeAsignacion;
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

	public TipoPersona gettPersona() {
		return tPersona;
	}
	
	public TipoRubro getRubro() {
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
	
	public int getCantpuestos() {
		return cantpuestos;
	}


	public void setCantpuestos(int cantpuestos) {
		this.cantpuestos = cantpuestos;
	}

	@Override
	public String toString() {
		return  nombre + "       " + tPersona + "         " + rubro + "         " + ticket;
	}

	//----------------------------------------Parte 2--------------------------------------------------
	
	public void nuevosPuestosTrabajos(PuestoTrabajo trabajo) { 
			mispuestotrabajo.add(trabajo);
		}

	
	public BolsaDeTrabajo getBolsa() {
		return bolsa;
	}


	public void setBolsa(BolsaDeTrabajo bolsa) {
		this.bolsa = bolsa;
	}


	public ArrayList<PuestoTrabajo> getMispuestotrabajo() {
		return mispuestotrabajo;
	}


	public void setMispuestotrabajo(ArrayList<PuestoTrabajo> mispuestotrabajo) {
		this.mispuestotrabajo = mispuestotrabajo;
	}
	
}
