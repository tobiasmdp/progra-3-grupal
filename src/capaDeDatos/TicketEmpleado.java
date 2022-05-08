package capaDeDatos;

import java.util.Calendar;

import capaDeNegocios.Formulario;

/**
 * <b>
 * El ticket busquedaEmpleo se encarga de completar si el resultado de la contratacion fue 	exitoso.
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
	