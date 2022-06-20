package capaDeDatos;

import comisiones.IRubro;
import formulario.Locacion;

public class PuestoTrabajo { //lo crea empleador
private Locacion locacion;
private IRubro rubro;
private Empleador empleador;

	public PuestoTrabajo(Empleador empleador) {
		this.empleador=empleador;
		this.locacion= empleador.getTicket().formulario.getLocacion();
		this.rubro=empleador.getRubro();
	}
	
	public Locacion getLocacion() {
		return locacion;
	}

	public IRubro getRubro() {
		return rubro;
	}

	public Empleador getEmpleador() {
		return empleador;
	}

}
