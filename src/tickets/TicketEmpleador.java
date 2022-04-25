/**
 * 
 */
package tickets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;

import agencia.EmpleadoPretenso;
import agencia.Usuario;
import agencia.UsuarioComparator;
import agencia.Usuario_puntaje;
import dispatch.Formulario;

/**
 * @author mikel
 *
 */
public class TicketEmpleador extends Ticket {
  private int cantempleadosbuscados, cantempleadosobtenidos;
  //ArrayList<Usuario_puntaje> empleadosmatcheados= new ArrayList<Usuario_puntaje>();
  
	/**
	 * @param fecha definido en la clase abstracta Ticket
	 * @param formulario definido en la clase abstracta Ticket
	 * @param cantempleadosbuscados aca el empleador debe poner al cantidad de empelados que busca, no tiene que ser menor a 1
	 * canempleadosobtenidos se inicializa en 0 para todos los objetos, porque al recien crear el ticket, todavía no obtuvo ningun empleado
	 */
	public TicketEmpleador(GregorianCalendar fecha,Formulario formulario, int cantempleadosbuscados, int estado) {
		super(fecha,formulario,estado);
		this.cantempleadosbuscados=cantempleadosbuscados;
		this.cantempleadosobtenidos=0;
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
			this.setEstado(4);
		}

	}
	
	public void nuevoEmpleadoMatcheado(Usuario_puntaje usuario) {
		//INSERTARLO ORDENADO ACA
		//(guty) aca se inserta y se ordena
		this.lista.add(usuario);
		Collections.sort(this.lista,new UsuarioComparator());
	}
	

	
	/**
	 * se usa para resetar la lista en el proximo llamado de matcheos
	 */
	public void resetListaEmpleados() {
		this.lista.clear();
	}
	
}