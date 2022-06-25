package capaDeDatos;

import capaDeNegocios.EmpleadorSimulado;

public class PuestoTrabajo { //lo crea empleador
private String locacion;
private String rubro;
private EmpleadorSimulado empleador;
private String estado; // 3 estados: 0 disponible, 1 en consulta, 2 finalizado

	public PuestoTrabajo(EmpleadorSimulado auxempleador, String locacion, String rubro) { //se hicieron string porque sino hay que generar todo el ticket completo, y para la simulacion no me parece necesario
		this.empleador=auxempleador;
		this.locacion= locacion;
		this.rubro=rubro;
		this.estado="disponible";
	}
	
	public String getLocacion() {
		return locacion;
	}

	public String getRubro() {
		return rubro;
	}

	public EmpleadorSimulado getEmpleador() {
		return empleador;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Locacion=" + locacion + ", rubro=" + rubro + ", empleador=" + empleador + ", estado="
				+ estado;
	}
	
	

}
