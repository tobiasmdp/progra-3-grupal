package paquete;

/**
 * @author mikel
 * Crea la clase formulario, para que esta se cree en la funcion que lo invoca, se deben validar todos los datos
 */
public class Formulario {
	private	String locacion,cargaHoraria,tipoPuesto,experienciaprevia,cursados;
	private double remuneracion,rangoEtario;
	
	public Formulario(String locacion, double remuneracion, String cargaHoraria, String tipoPuesto, double rangoEtario,
			String experienciaprevia, String cursados) {
		this.locacion = locacion;
		this.remuneracion = remuneracion;
		this.cargaHoraria = cargaHoraria;
		this.tipoPuesto = tipoPuesto;
		this.rangoEtario = rangoEtario;
		this.experienciaprevia = experienciaprevia;
		this.cursados = cursados;
	}

	public String getLocacion() {
		return locacion;
	}

	public double getRemuneracion() {
		return remuneracion;
	}

	public String getCargaHoraria() {
		return cargaHoraria;
	}

	public double getRangoEtario() {
		return rangoEtario;
	}

	public String getExperienciaprevia() {
		return experienciaprevia;
	}

	public String getCursados() {
		return cursados;
	}

	public String getTipoPuesto() {
		return tipoPuesto;
	}
	
}
