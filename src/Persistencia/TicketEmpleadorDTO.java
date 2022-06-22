package Persistencia;

public class TicketEmpleadorDTO extends TicketDTO{
    private int cantempleadosbuscados, cantempleadosobtenidos;
  	private int pLocacion;
	private int pRemuneracion;
	private int pCargaHoraria;
	private int pTipodePuesto;
	private int pExperienciaPrevia;
	private int pRangoEtario;
	private int pEstudiosCursados;
	
	public TicketEmpleadorDTO() {
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
		this.cantempleadosobtenidos = cantempleadosobtenidos;
	}
	
	public int getpLocacion() {
		return pLocacion;
	}
	
	public void setpLocacion(int pLocacion) {
		this.pLocacion = pLocacion;
	}
	
	public int getpRemuneracion() {
		return pRemuneracion;
	}
	
	public void setpRemuneracion(int pRemuneracion) {
		this.pRemuneracion = pRemuneracion;
	}
	
	public int getpCargaHoraria() {
		return pCargaHoraria;
	}
	
	public void setpCargaHoraria(int pCargaHoraria) {
		this.pCargaHoraria = pCargaHoraria;
	}
	
	public int getpTipodePuesto() {
		return pTipodePuesto;
	}
	
	public void setpTipodePuesto(int pTipodePuesto) {
		this.pTipodePuesto = pTipodePuesto;
	}
	
	public int getpExperienciaPrevia() {
		return pExperienciaPrevia;
	}
	
	public void setpExperienciaPrevia(int pExperienciaPrevia) {
		this.pExperienciaPrevia = pExperienciaPrevia;
	}
	
	public int getpRangoEtario() {
		return pRangoEtario;
	}
	
	public void setpRangoEtario(int pRangoEtario) {
		this.pRangoEtario = pRangoEtario;
	}
	
	public int getpEstudiosCursados() {
		return pEstudiosCursados;
	}
	
	public void setpEstudiosCursados(int pEstudiosCursados) {
		this.pEstudiosCursados = pEstudiosCursados;
	}
	
	
}
