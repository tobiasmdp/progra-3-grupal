/**
 * 
 */
package capaDeDatos;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import capaDeNegocios.Formulario;
import capaDeNegocios.Usuario_puntaje;

/**
 * @author mikel
 *
 */
public class TicketEmpleador extends Ticket {
  private int cantempleadosbuscados, cantempleadosobtenidos;
  ArrayList<Usuario_puntaje> empleadosmatcheados= new ArrayList<Usuario_puntaje>();
  	private int pLocacion;
	private int pRemuneracion;
	private int pCargaHoraria;
	private int pTipodePuesto;
	private int pExperienciaPrevia;
	private int pRangoEtario;
	private int pEstudiosCursados;
	
	
	/**
	 * @param fecha definido en la clase abstracta Ticket
	 * @param formulario definido en la clase abstracta Ticket
	 * @param cantempleadosbuscados aca el empleador debe poner al cantidad de empelados que busca, no tiene que ser menor a 1
	 * canempleadosobtenidos se inicializa en 0 para todos los objetos, porque al recien crear el ticket, todavía no obtuvo ningun empleado
	 */
	
	public TicketEmpleador(GregorianCalendar fecha,Formulario formulario, int cantempleadosbuscados) {
		super(fecha,formulario);
		this.cantempleadosbuscados=cantempleadosbuscados;
		this.cantempleadosobtenidos=0;
	}
	
	public TicketEmpleador(GregorianCalendar fecha, Formulario formulario, String estado, int cantempleadosbuscados
			, int pLocacion, int pRemuneracion, int pCargaHoraria,
			int pTipodePuesto, int pExperienciaPrevia, int pRangoEtario, int pEstudiosCursados) {
		super(fecha,formulario,estado);
		this.cantempleadosbuscados=cantempleadosbuscados;
		this.cantempleadosobtenidos=0;
		this.pLocacion = pLocacion;
		this.pRemuneracion = pRemuneracion;
		this.pCargaHoraria = pCargaHoraria;
		this.pTipodePuesto = pTipodePuesto;
		this.pExperienciaPrevia = pExperienciaPrevia;
		this.pRangoEtario = pRangoEtario;
		this.pEstudiosCursados = pEstudiosCursados;
	}

	public int getpLocacion() {
		return pLocacion;
	}
	public int getpRemuneracion() {
		return pRemuneracion;
	}
	public int getpCargaHoraria() {
		return pCargaHoraria;
	}
	public int getpTipodePuesto() {
		return pTipodePuesto;
	}
	public int getpExperienciaPrevia() {
		return pExperienciaPrevia;
	}
	public int getpRangoEtario() {
		return pRangoEtario;
	}
	public int getpEstudiosCursados() {
		return pEstudiosCursados;
	}
	public int getCantempleadosbuscados() {
		return cantempleadosbuscados;
	}
	
	public void setCantempleadosbuscados(int cantempleadosbuscados) {
		this.cantempleadosbuscados = cantempleadosbuscados;
	}
	
	public int getCantempleadosobtenidos() {
		return cantempleadosobtenidos;
	}
	
	public void setCantempleadosobtenidos(int cantempleadosobtenidos) {
		this.cantempleadosobtenidos=cantempleadosobtenidos;
	}
	
	/**este metodo se llama cuando los empleados son contratados
	 * @param cantempleadosobtenidos se pasa los empleados obtenidos contratados
	 */
	public void empleadosObtenido(int cantempleadosobtenidos) { //ver bien con el grupo
		this.cantempleadosobtenidos += cantempleadosobtenidos;
		if (this.cantempleadosobtenidos<this.cantempleadosbuscados)
			this.cantempleadosbuscados-=this.cantempleadosobtenidos;
		else {
			this.cantempleadosbuscados=this.cantempleadosobtenidos;
			this.setEstado("finalizado");
		}

	}
	
	public void nuevoEmpleadoMatcheado(Usuario_puntaje usuario) {
		//INSERTARLO ORDENADO ACA
		this.empleadosmatcheados.add(usuario);
	}
	
	/**
	 * se usa para resetar la lista en el proximo llamado de matcheos
	 */
	public void resetListaEmpleados() {
		this.empleadosmatcheados.clear();
	}
	

	public ArrayList<Usuario_puntaje> getEmpleadosmatcheados() {
		return empleadosmatcheados;
	}

	
	
}