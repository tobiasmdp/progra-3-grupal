package dispatch;



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
	
	public Formulario(Locacion locacion, Remuneracion remuneracion, CargaHoraria cargaHoraria, TipodePuesto tipoPuesto, RangoEtario rangoEtario,
			ExperienciaPrevia experienciaprevia, EstudiosCursados cursados) {
		this.locacion = locacion;//CAMBIAR GETS POR FACTORYS
		getLocacion(this.locacion);
		this.remuneracion = remuneracion;
		getRemuneracion(this.remuneracion);
		this.cargaHoraria = cargaHoraria;
		getCargaHoraria(this.cargaHoraria);
		this.tipoPuesto = tipoPuesto;
		getTipoPuesto(this.tipoPuesto);
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

	public CargaHoraria getCargaHoraria(CargaHoraria cargaHoraria) {
		return cargaHoraria;
	}

	public TipodePuesto getTipoPuesto(TipodePuesto tipoPuesto) {
		return tipoPuesto;
	}

	public ExperienciaPrevia getExperienciaPrevia(ExperienciaPrevia experienciaprevia) {
		return experienciaprevia;
	}

	public RangoEtario getRangoEtario(RangoEtario rangoEtario) {
		return rangoEtario;
	}

	public EstudiosCursados getEstudiosCursados(EstudiosCursados cursados) {
		return cursados;
	}
	

}