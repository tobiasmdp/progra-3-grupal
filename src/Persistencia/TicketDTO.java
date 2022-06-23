package Persistencia;

import java.util.ArrayList;
import java.util.Calendar;

public class TicketDTO {
	private Calendar fecha;
	private String estado;
	protected FormularioDTO formulario;
	protected ListaDeAsignacionDTO listaAsignacion; //permito que se pueda elegir varios tickets en empleado tmb, luego se limita desde su ticket
	protected ArrayList<Usuario_puntajeDTO> usuariosElegidos;
	protected int rondasTranscurridas;
	
	public TicketDTO() {
	}
	
	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public FormularioDTO getFormulario() {
		return formulario;
	}
	public void setFormulario(FormularioDTO formulario) {
		this.formulario = formulario;
	}
	public ListaDeAsignacionDTO getListaAsignacion() {
		return listaAsignacion;
	}
	public void setListaAsignacion(ListaDeAsignacionDTO listaAsignacion) {
		this.listaAsignacion = listaAsignacion;
	}
	public ArrayList<Usuario_puntajeDTO> getUsuariosElegidos() {
		return usuariosElegidos;
	}
	public void setUsuariosElegidos(ArrayList<Usuario_puntajeDTO> usuariosElegidos) {
		this.usuariosElegidos = usuariosElegidos;
	}
	public int getRondasTranscurridas() {
		return rondasTranscurridas;
	}
	public void setRondasTranscurridas(int rondasTranscurridas) {
		this.rondasTranscurridas = rondasTranscurridas;
	}
	
	
}
