package Persistencia;

import java.util.ArrayList;
import java.util.Calendar;

public class ListaDeAsignacionDTO {
	private ArrayList<Usuario_puntajeDTO> listaAsignacion;
	private Calendar fecha ;
	
	public ListaDeAsignacionDTO() {
	}
	
	public ArrayList<Usuario_puntajeDTO> getListaAsignacion() {
		return listaAsignacion;
	}
	public void setListaAsignacion(ArrayList<Usuario_puntajeDTO> listaAsignacion) {
		this.listaAsignacion = listaAsignacion;
	}
	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	
	
}
