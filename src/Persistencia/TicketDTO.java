package Persistencia;

import java.util.ArrayList;
import java.util.Calendar;

public class TicketDTO {
	private Calendar fecha;
	private String estado;
	protected FormularioDTO formulario;
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
	public int getRondasTranscurridas() {
		return rondasTranscurridas;
	}
	public void setRondasTranscurridas(int rondasTranscurridas) {
		this.rondasTranscurridas = rondasTranscurridas;
	}
	
	
}
