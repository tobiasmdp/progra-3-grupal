package Persistencia;


public class FormularioDTO {
    private String locacion;
    private double remuneracion;
    private String cargaHoraria;
    private String tipoPuesto;
    private String experienciaprevia;
    private String rangoEtario;
    private String cursados;
    
    public FormularioDTO(){
    }
    
	public String getLocacion() {
		return locacion;
	}
	public void setLocacion(String locacion) {
		this.locacion = locacion;
	}
	public double getRemuneracion() {
		return remuneracion;
	}
	public void setRemuneracion(double remuneracion) {
		this.remuneracion = remuneracion;
	}
	public String getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public String getTipoPuesto() {
		return tipoPuesto;
	}
	public void setTipoPuesto(String tipoPuesto) {
		this.tipoPuesto = tipoPuesto;
	}
	public String getExperienciaprevia() {
		return experienciaprevia;
	}
	public void setExperienciaprevia(String experienciaprevia) {
		this.experienciaprevia = experienciaprevia;
	}
	public String getRangoEtario() {
		return rangoEtario;
	}
	public void setRangoEtario(String rangoEtario) {
		this.rangoEtario = rangoEtario;
	}
	public String getCursados() {
		return cursados;
	}
	public void setCursados(String cursados) {
		this.cursados = cursados;
	}
    
}
