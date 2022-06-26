/**
 * 
 */
package capaDeDatos;

import java.util.Calendar;

/**
 * <b>
 * Se encarga de agregar los pesos para luego utilizarlos.
 */
public class TicketEmpleador extends Ticket {
    private int cantempleadosbuscados, cantempleadosobtenidos;
  	private int pLocacion;
	private int pRemuneracion;
	private int pCargaHoraria;
	private int pTipodePuesto;
	private int pExperienciaPrevia;
	private int pRangoEtario;
	private int pEstudiosCursados;
	
	
	/**
	 * <b>
	 * Al momento de crear el ticket de empleador se pasa el formulario ya que este lo compone y la cant de empleados que se busca contratar.
	 * Los pesos se 
	 * @param formulario: se pasa el formulario.
	 * @param cantempleadosbuscados aca el empleador debe poner al cantidad de empelados que busca, no tiene que ser menor a 1.
	 * cantempleadosobtenidos se inicializa en 0 para todos los tickets empleador porque al momento de crearlo no se contrato a nadie.
	 */
	
	public TicketEmpleador(Formulario formulario, int cantempleadosbuscados) {
		super(formulario);
		this.cantempleadosbuscados=cantempleadosbuscados;
		this.cantempleadosobtenidos=0;
	}
	
	/**
	 * <b>
	 * Al momento de crear el ticket se le pasa el formulario y todos los pesos para poder operar mas adelante.
	 * @param formulario: se pasa el formulario.
	 * @param cantempleadosbuscados aca el empleador debe poner al cantidad de empelados que busca, no tiene que ser menor a 1.
	 * cantempleadosobtenidos se inicializa en 0 para todos los tickets empleador porque al momento de crearlo no se contrato a nadie.
	 */
	public TicketEmpleador( Formulario formulario, int cantempleadosbuscados
			, int pLocacion, int pRemuneracion, int pCargaHoraria,
			int pTipodePuesto, int pExperienciaPrevia, int pRangoEtario, int pEstudiosCursados) {
		super(formulario);
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
}