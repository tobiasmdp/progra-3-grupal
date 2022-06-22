package capaDeDatos;

import comisiones.IRubro;
import formulario.Locacion;

public class PuestoTrabajo { //lo crea empleador
private String locacion;
private String rubro;
private Empleador empleador;
private int estado; // 3 estados: 0 disponible, 1 en consulta, 2 finalizado

	public PuestoTrabajo(Empleador empleador, String locacion, String rubro) { //se hicieron string porque sino hay que generar todo el ticket completo, y para la simulacion no me parece necesario
		this.empleador=empleador;
		this.locacion= locacion;
		this.rubro=rubro;
	}
	
	public String getLocacion() {
		return locacion;
	}

	public String getRubro() {
		return rubro;
	}

	public Empleador getEmpleador() {
		return empleador;
	}
	
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	

}
