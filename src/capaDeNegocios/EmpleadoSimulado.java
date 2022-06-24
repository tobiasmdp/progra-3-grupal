package capaDeNegocios;

import capaDeDatos.PuestoTrabajo;

public class EmpleadoSimulado extends Thread {
	private String nombre;
	private String rubro;
	private String locacion;
	private BolsaDeTrabajo bolsa;
	private PuestoTrabajo minuevopuesto;

	public EmpleadoSimulado(String nombreUsuario, String rubro, BolsaDeTrabajo bolsa, String locacion) {
		this.nombre = nombreUsuario;
		this.rubro = rubro;
		this.bolsa = bolsa;
		this.locacion = locacion;
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}

	public String getLocacion() {
		return locacion;
	}

	public void setLocacion(String locacion) {
		this.locacion = locacion;
	}

	public BolsaDeTrabajo getBolsa() {
		return bolsa;
	}

	public void setBolsa(BolsaDeTrabajo bolsa) {
		this.bolsa = bolsa;
	}

	public PuestoTrabajo getMinuevopuesto() {
		return minuevopuesto;
	}

	public void setMinuevopuesto(PuestoTrabajo minuevopuesto) {
		this.minuevopuesto = minuevopuesto;
	}

	public void run() {
		int i = 0, encontre = 0;
		PuestoTrabajo aux;
		while (i <= 10 && encontre == 0) {
			aux = bolsa.getPuestoTrabajo(this);
			if (aux.getLocacion().equalsIgnoreCase(this.locacion) || aux.getLocacion().equalsIgnoreCase("indistinto")) {
				setMinuevopuesto(aux);
				bolsa.removePuestoTrabajo(aux);
				encontre = 1;
			} else
				bolsa.putPuestoTrabajoEmpleado(aux);
			i++;
		}
	}
}
