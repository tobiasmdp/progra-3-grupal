package capaDeDatos;

import java.util.Calendar;

import capaDeNegocios.Formulario;

/**
 * @author mikel
 * El ticket busquedaEmpleo se encarga de completar si el resultado de la contratacion fue 	exitoso.
 * La variable resultado va a ser booleana, y recibira un 0 si fue un fracaso o un 1 si fue un exito.
 * Al crearse el ticket todos los resultados van a ser 0 porque todavía no se realizao el matcheo.
 */
 public class TicketEmpleado extends Ticket {
 private int resultado;

 
 public TicketEmpleado(Calendar fecha, Formulario formulario) {
		super(formulario);
		this.resultado=0;
	}
 
	public int getResultado() { 
		return resultado;
	}
	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	
	
}
	