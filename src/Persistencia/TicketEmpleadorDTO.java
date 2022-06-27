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
	
	public int getPLocacion() {
		return pLocacion;
	}
	
	public void setPLocacion(int pLocacion) {
		this.pLocacion = pLocacion;
	}
	
	public int getPRemuneracion() {
		return pRemuneracion;
	}
	
	public void setPRemuneracion(int pRemuneracion) {
		this.pRemuneracion = pRemuneracion;
	}
	
	public int getPCargaHoraria() {
		return pCargaHoraria;
	}
	
	public void setPCargaHoraria(int pCargaHoraria) {
		this.pCargaHoraria = pCargaHoraria;
	}
	
	public int getPTipodePuesto() {
		return pTipodePuesto;
	}
	
	public void setPTipodePuesto(int pTipodePuesto) {
		this.pTipodePuesto = pTipodePuesto;
	}
	
	public int getPExperienciaPrevia() {
		return pExperienciaPrevia;
	}
	
	public void setPExperienciaPrevia(int pExperienciaPrevia) {
		this.pExperienciaPrevia = pExperienciaPrevia;
	}
	
	public int getPRangoEtario() {
		return pRangoEtario;
	}
	
	public void setPRangoEtario(int pRangoEtario) {
		this.pRangoEtario = pRangoEtario;
	}
	
	public int getPEstudiosCursados() {
		return pEstudiosCursados;
	}
	
	public void setPEstudiosCursados(int pEstudiosCursados) {
		this.pEstudiosCursados = pEstudiosCursados;
	}
	
	
}
