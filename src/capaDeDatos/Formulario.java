package capaDeDatos;

import formulario.*;

/**
 * <br>
 * Formulario de busqueda con los datos necesarios para operar.
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
		this.locacion = FactoryLocacion.getLocacion(locacion);   
        this.remuneracion = FactoryRemuneracion.getRemuneracion(remuneracion);
        this.cargaHoraria = FactoryCargaHoraria.getCargaHoraria(cargaHoraria);
        this.tipoPuesto = FactoryTipodePuesto.getTipodePuesto(tipoPuesto);
        this.rangoEtario = FactoryRangoEtario.getRangoEtario(rangoEtario);
        this.experienciaprevia = FactoryExperienciaPrevia.getExperienciaPrevia(experienciaprevia);
        this.cursados = FactoryEstudiosCursados.getEstudiosCursados(cursados);
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
