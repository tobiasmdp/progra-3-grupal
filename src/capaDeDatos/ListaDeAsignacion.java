package capaDeDatos;

import java.util.ArrayList;
import java.util.Calendar;

import capaDeNegocios.Usuario_puntaje;

/**
 * <br>
 *Contiene el usuario (empleado pretenso/empleador),su puntaje luego de la ronda de contratacion y la fecha.
 */
public class ListaDeAsignacion {
	private ArrayList<Usuario_puntaje> listaAsignacion;
	private Calendar fecha ;
	
	public ListaDeAsignacion() {
		super();
		this.listaAsignacion = new ArrayList<Usuario_puntaje>();
		this.fecha = Calendar.getInstance();
	}

	
	public Calendar getFecha() {
		return fecha;
	}
	
	public void addlista(Usuario_puntaje usuario) {
		this.listaAsignacion.add(usuario);
	}
	
	public ArrayList<Usuario_puntaje> getLista() {
		return listaAsignacion;
	}
	
	public void removelista(Usuario_puntaje usuario) {
		this.listaAsignacion.remove(usuario);
	}
	
}
