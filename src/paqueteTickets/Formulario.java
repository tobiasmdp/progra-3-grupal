package paqueteTickets;

/**
 * @author mikel
 * Crea la clase formulario, para que esta se cree en la funcion que lo invoca, se deben validar todos los datos
 */
public class Formulario {
	private Locacion locacion;
	private Remuneracion remuneracion;
	private CargaHoraria cargaHoraria;
	private TipodePuesto tipoPuesto;
	private ExperienciaPrevia experienciaprevia;
	private RangoEtario rangoEtario;
	private EstudiosCursados cursados;
	
	public Formulario(String locacion, double remuneracion, String cargaHoraria, String tipoPuesto, double rangoEtario,
			String experienciaprevia, String cursados) {
		this.locacion = locacion;
		getLocacion(this.locacion);
		this.remuneracion = remuneracion;
		getRemuneracion(this.remuneracion);
		this.cargaHoraria = cargaHoraria;
		getCargaHoraria(this.cargaHoraria);
		this.tipoPuesto = tipoPuesto;
		getTipodePuesto(this.tipoPuesto);
		this.rangoEtario = rangoEtario;
		getRangoEtario(this.rangoEtario);
		this.experienciaprevia = experienciaprevia;
		getExperienciaPrevia(this.experienciaprevia);
		this.cursados = cursados;
		getEstudiosCursados(this.cursados);
	}

	public Locacion getLocacion() {
		return locacion;
	}

	public Remuneracion getRemuneracion() {
		return remuneracion;
	}

	public CargaHoraria getCargaHoraria() {
		return cargaHoraria;
	}

	public TipodePuesto getTipoPuesto() {
		return tipoPuesto;
	}

	public ExperienciaPrevia getExperienciaprevia() {
		return experienciaprevia;
	}

	public RangoEtario getRangoEtario() {
		return rangoEtario;
	}

	public EstudiosCursados getCursados() {
		return cursados;
	}
	

}
