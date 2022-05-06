package capaDeDatos;

import java.util.ArrayList;
import java.util.Calendar;

import capaDeNegocios.Usuario_puntaje;

public class ListaDeAsignacion {
	private ArrayList<Usuario_puntaje> listaAsignacion;
	private Calendar fecha = Calendar.getInstance();
	
	
	
	
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
