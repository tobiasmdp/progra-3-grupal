package capaDeDatos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import capaDeNegocios.Formulario;
import capaDeNegocios.Usuario_puntaje;

/**
 * @author mikel
 * El ticket busquedaEmpleo se encarga de completar si el resultado de la contratacion fue 	exitoso.
 * La variable resultado va a ser booleana, y recibira un 0 si fue un fracaso o un 1 si fue un exito.
 * Al crearse el ticket todos los resultados van a ser 0 porque todavía no se realizao el matcheo.
 */
 public class TicketEmpleado extends Ticket {
 private int resultado;
 ArrayList<Usuario_puntaje> empleadoresmatcheados= new ArrayList<Usuario_puntaje>();

 public TicketEmpleado(Calendar fecha, Formulario formulario, String estado) {
		super(fecha, formulario,estado);
		this.resultado=0;
	}
 
 public TicketEmpleado(Calendar fecha, Formulario formulario) {
		super(fecha, formulario);
		this.resultado=0;
	}
 
	public int getResultado() { 
		return resultado;
	}
	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	
	public void nuevoEmpleadorMatcheado(Usuario_puntaje empleadormatcheado) {
		this.empleadoresmatcheados.add(empleadormatcheado);
	}
	
	
	/**
	 * se usa para resetar la lista en el proximo llamado de matcheos
	 */
	public void resetListaEmpleados() {
		this.empleadoresmatcheados.clear();
	}

	public ArrayList<Usuario_puntaje> getEmpleadoresmatcheados() {
		return empleadoresmatcheados;
	}
	
	@Override
	protected void seleccionar(Usuario_puntaje elemento) {
		if(this.getUsuariosElegidos().isEmpty())
			super.seleccionar(elemento);
	}
}
	